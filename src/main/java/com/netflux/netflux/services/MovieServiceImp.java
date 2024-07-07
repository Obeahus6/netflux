package com.netflux.netflux.services;

import java.time.Duration;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.netflux.netflux.domain.Movie;
import com.netflux.netflux.domain.MovieEvent;
import com.netflux.netflux.repositories.MoviesRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService{
    private final MoviesRepository moviesRepository;
    @Override
    public Mono<Movie> getMovieById(String id){
        return moviesRepository.findById(id);
    
    
    
    }


    @Override
    public Flux<Movie> getAllMovies(){
       
        return  moviesRepository.findAll();
    }
    @Override
    public Flux<MovieEvent> streamMovieEvens(String id){
       
        return Flux.<MovieEvent>generate(movieEventsSynchronousSink ->{
            movieEventsSynchronousSink.next(new MovieEvent(id, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }

}
