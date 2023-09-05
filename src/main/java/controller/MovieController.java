package controller;

import dto.MovieActorReq;
import dto.MovieActorResponse;
import dto.MovieResponse;
import entity.Actor;
import entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MovieService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll() {
        List<MovieResponse> movieResponses = new ArrayList<>();
        List<Movie> movies =  movieService.findAll();
        for (Movie movie: movies) {
            movieResponses.add( new MovieResponse(movie.getRating(), movie.getName(), movie.getId(), movie.getReleaseDate()));
        }
        return movieResponses;
    }
    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id) {
        Movie foundMovie = movieService.findById(id);
        return new MovieResponse(foundMovie.getRating(), foundMovie.getName(), foundMovie.getId(), foundMovie.getReleaseDate());
    }

    @PostMapping("/")
    public Movie save(@RequestBody MovieActorReq movieActorReq) {
        Movie movie = movieActorReq.getMovie();
        Actor actor = movieActorReq.getActor();
        movie.getActors().add(actor);
        Movie savedMovie= movieService.save(movie);
        return new MovieActorResponse(movie, actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate()).getMovie();
    }
}
