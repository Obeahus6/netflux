package com.netflux.netflux.contrllers;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflux.netflux.domain.Movie;
import com.netflux.netflux.domain.MovieEvent;
import com.netflux.netflux.services.MovieService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    
   
    @GetMapping("/{id}")
Mono<Movie> getMovieById(@PathVariable String id){
    return movieService.getMovieById(id);
}

@GetMapping
Flux<Movie> getAllMovie(){
    return movieService.getAllMovies();
}

@GetMapping(value="/{id}/events",produces= MediaType.TEXT_EVENT_STREAM_VALUE)
Flux<MovieEvent> streamMoviEvents(@PathVariable String id){
    return movieService.streamMovieEvens(id);
}
}
