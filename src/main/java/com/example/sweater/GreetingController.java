package com.example.sweater;

import com.example.sweater.domain.Abonent;
import com.example.sweater.repos.AbonentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
    public class GreetingController {
    @Autowired
    private AbonentRepo abonentRepo;

        @GetMapping("/")
        public String greeting(
                //@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                //Model model) {
                Map<String, Object> model) {
            // model.addAttribute("name", name);
            //model.put("name", name);
            return "greeting";
        }

        @GetMapping("/main")
    public String main(Map<String, Object> model){
            Iterable<Abonent> abonents = abonentRepo.findAll();
            model.put("abonents", abonents);
            return "main";
        }

        @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam String phone, Map<String, Object> model){
            Abonent newAbonent = new Abonent(name, phone);
            abonentRepo.save(newAbonent);
            Iterable<Abonent> abonents = abonentRepo.findAll();
            model.put("abonents", abonents);

            return "main";

        }

        @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
            List<Abonent> abonentList = abonentRepo.findAbonentByNameContains(filter);
            model.put("abonents", abonentList);

            return "main";
        }


    }

