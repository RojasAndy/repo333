package com.example.lab02Rojas.Security.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab02Rojas.Security.model.Users;


@Repository
public interface IUser extends JpaRepository<Users, Serializable>{
	
}
