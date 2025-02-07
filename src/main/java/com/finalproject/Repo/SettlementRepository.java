package com.finalproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.finalproject.Entity.Settlement;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Integer> {
}