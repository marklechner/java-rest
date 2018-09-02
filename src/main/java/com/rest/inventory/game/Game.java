package com.rest.inventory.game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private Integer year;
	private Integer score;

	public Game() {
		super();
	}

	public Game(Long id, String name, String description, Integer year, Integer score) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.year = year;
		this.score = score;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
