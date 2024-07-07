package com.netflux.netflux.services;

import com.netflux.netflux.domain.Movie;
import com.netflux.netflux.domain.MovieEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
Mono<Movie> getMovieById(String id);
Flux<Movie> getAllMovies();
Flux<MovieEvent> streamMovieEvens(String id);
}
