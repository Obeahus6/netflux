package com.netflux.netflux.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.netflux.netflux.domain.Movie;
import com.netflux.netflux.repositories.MoviesRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner  {
    private final MoviesRepository movieRepository;

    @Override
    public void run( String... args) throws Exception{
        movieRepository.deleteAll()
        .thenMany(
            Flux.just("Back to the Future","Star Treck","Hanibal","Lord of the Fluxes","True Story")
            .map(title->Movie.builder().title(title).build())
        .flatMap(movieRepository::save))
        .subscribe(null,null,()->{
            movieRepository.findAll().subscribe(System.out::println);
        });
    }

}
