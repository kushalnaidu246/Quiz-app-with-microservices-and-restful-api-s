package com.kushal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kushal.model.Quiz;

@Repository
public interface Quizdao extends JpaRepository<Quiz, Integer> {

}
