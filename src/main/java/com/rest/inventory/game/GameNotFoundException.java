package com.rest.inventory.game;

public class GameNotFoundException extends RuntimeException {

	public GameNotFoundException(String exception) {
		super(exception);
	}
}
