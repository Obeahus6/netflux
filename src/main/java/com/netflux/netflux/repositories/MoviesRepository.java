package com.netflux.netflux.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.netflux.netflux.domain.Movie;

public interface MoviesRepository  extends ReactiveMongoRepository<Movie,String>{

}
