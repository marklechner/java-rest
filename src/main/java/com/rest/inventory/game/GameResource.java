package com.rest.inventory.game;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class GameResource {

	@Autowired
	private GameRepository gameRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/games")
	public List<Game> retrieveAllGames() {
		return gameRepository.findAll();
	}

	@GetMapping("/games/{id}")
	public Game retrieveGame(@PathVariable long id) {
		Optional<Game> game = gameRepository.findById(id);

		if (!game.isPresent())
			throw new GameNotFoundException("id-" + id);

		return game.get();
	}

	@DeleteMapping("/games/{id}")
	public void deleteGame(@PathVariable long id) {
		gameRepository.deleteById(id);
	}

	@PostMapping("/games")
	public ResponseEntity<Object> createGame(@RequestBody Game game) {
		Game savedGame = gameRepository.save(game);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedGame.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/games/{id}")
	public ResponseEntity<Object> updateGame(@RequestBody Game game, @PathVariable long id) {

		Optional<Game> gameOptional = gameRepository.findById(id);

		if (!gameOptional.isPresent())
			return ResponseEntity.notFound().build();

		game.setId(id);
		
		gameRepository.save(game);

		return ResponseEntity.noContent().build();
	}
	
}
