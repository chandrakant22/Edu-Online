package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LiveSession;

@Repository
public interface LiveSessionRepository extends JpaRepository<LiveSession, Integer>{

}
