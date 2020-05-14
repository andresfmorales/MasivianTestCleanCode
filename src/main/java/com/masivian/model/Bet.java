package com.masivian.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bet {
	
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "betNumber")
	private int betNumber;

	@Column(name = "betColour", length = 5)
	private String betColour;

	@Column(name = "betPrice")
	private double betPrice;

	@Column(name = "bettorId")
	private int bettorId;

	@Column(name = "rouletteId")
	private int rouletteId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(int betNumber) {
		this.betNumber = betNumber;
	}

	public String getBetColour() {
		return betColour;
	}

	public void setBetColour(String betColour) {
		this.betColour = betColour;
	}

	public double getBetPrice() {
		return betPrice;
	}

	public void setBetPrice(double betPrice) {
		this.betPrice = betPrice;
	}

	public int getBettorId() {
		return bettorId;
	}

	public void setBettorId(int bettorId) {
		this.bettorId = bettorId;
	}

	public int getRouletteId() {
		return rouletteId;
	}

	public void setRouletteId(int rouletteId) {
		this.rouletteId = rouletteId;
	}

}