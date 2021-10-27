package com.example.sweater.repos;

import org.springframework.data.repository.CrudRepository;

//import com.example.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

import com.example.sweater.domain.Abonent;

import java.util.List;

public interface AbonentRepo extends CrudRepository<Abonent, Integer> {
    List<Abonent> findAbonentByNameContains(String name);
}