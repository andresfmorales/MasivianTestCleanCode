package com.masivian.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masivian.model.Roulette;

public interface IRouletteRepo extends JpaRepository<Roulette, Integer> {

	@Query(value = "SELECT SUM(bet_price) FROM bet WHERE roulette_id = :rouletteid", nativeQuery = true)
	double betsTotal(@Param("rouletteid") Integer rouletteId);

}
