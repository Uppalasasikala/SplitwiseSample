package com.finalproject.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.finalproject.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}