package com.masivian.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masivian.model.Bet;

public interface IBetRepo extends JpaRepository<Bet, Integer> {

}
