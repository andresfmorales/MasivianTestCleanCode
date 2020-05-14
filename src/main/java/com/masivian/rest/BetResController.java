package com.masivian.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.model.Bet;
import com.masivian.repo.IBetRepo;
import com.masivian.repo.IRouletteRepo;

@RestController
@RequestMapping("/bets")
public class BetResController {

	@Autowired
	private IBetRepo repo;
	@Autowired
	private IRouletteRepo repoR;
	
	@PostMapping(path = "/{bettorid}")
	public String placeBet(@RequestBody Bet bet, @PathVariable("bettorid") int bettorId) {
		try {
			int status = repoR.findById(bet.getRouletteId()).get().getStatus();
			if (status == 1) {
				bet.setBettorId(bettorId);
				if (bet.getBetNumber() > 36) {
					return "El numero a apostar no se encuentra disponible";
				} else if (bet.getBetPrice() > 10000.0) {
					return "El valor a apostar supera la cantidad permitida";
				} else if (!bet.getBetColour().equalsIgnoreCase("negro") && !bet.getBetColour().equalsIgnoreCase("rojo")) {
					return "El color a apostar no es permitido";
				}else {
				repo.save(bet);
				return "La apuesta se realizo correctamente, con el identificador: " + bet.getId();
				}
			}
			return "La ruleta no esta abierta";
		}catch (Exception e) {
			return "La ruleta no existe";
		}
}
}
