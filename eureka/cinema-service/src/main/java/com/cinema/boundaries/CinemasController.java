package com.cinema.boundaries;

import com.cinema.domain.Cinema;
import com.cinema.domain.Movie;
import com.cinema.persistence.CinemaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CinemasController {

    private final CinemaRepository cinemaRepository;
    private final RestTemplate restTemplate;

    public CinemasController(CinemaRepository cinemaRepository, RestTemplate restTemplate) {
        this.cinemaRepository = cinemaRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/cinemas")
    public ResponseEntity<List> listMovies() {
        final List<Cinema> movies = cinemaRepository.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/cinemas/{cinemaId}/movies")
    public ResponseEntity<Cinema> queryCinemaMovies(@PathVariable("cinemaId") Integer cinemaId) {
        Cinema cinema = cinemaRepository.findById(cinemaId).get();
        final Movie[] movies = restTemplate.getForObject("http://movies-service/movies", Movie[].class);
        cinema.setAvailableMovies(movies);
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

}
