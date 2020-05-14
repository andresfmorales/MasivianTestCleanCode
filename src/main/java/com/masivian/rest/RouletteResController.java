package com.masivian.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.model.Bet;
import com.masivian.model.Roulette;

import com.masivian.repo.IRouletteRepo;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/roulette")
public class RouletteResController {

	@Autowired
	private IRouletteRepo repo;

	@GetMapping(path = "/roulettelist")
	public List<Roulette> List() {
		return repo.findAll();
	}

	@GetMapping(path = "/createroulette")
	public String createRoulette() {
		Roulette roulette = new Roulette();
		repo.save(roulette);
		return "El id de la ruleta creada es: " + roulette.getId();
	}

	@GetMapping(path = "/openroulette/{rouletteid}")
	public String openRoulette(@PathVariable("rouletteid") Integer rouletteId) {
		Roulette roulette = repo.findById(rouletteId).get();
		if (roulette.getId() == rouletteId) {
			if (roulette.getStatus() == 0) {
				roulette.setStatus(1);
				repo.save(roulette);
				return "La operacion fue exitosa";
			}
		}
		return "La operacion fue denegada";
	}

	@GetMapping(path = "/closeroulette/{rouletteid}")
	public String closeRoulette(@PathVariable("rouletteid") int rouletteId) {
		Roulette roulette;
		try {
			roulette = repo.findById(rouletteId).get();
			try {
				double total = repo.betsTotal(rouletteId);
				
				roulette.setStatus(0);
				repo.save(roulette);
				return "La ruleta fue cerrada y tenia un total de valor de apuestas por : " + total;
			} catch (Exception e) {
				roulette.setStatus(0);
				repo.save(roulette);
				return "La ruleta fue cerrada y tenia un total de valor de apuestas por : 0";
			}
		} catch (Exception e) {
			return "La ruleta no existe";
		}

	}
}