// this class will be the API controller
package dev.nextstepadvisory.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


// amongst the multiple layers of spring framework, this is the API layers of the application.
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;      // wire this API layer to the MovieService classes, which is inferior classes
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {                                     // get request from the users
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);    // running the allMovies() method then return HTTP status to the user
    }

    //access the single movie by id
    @GetMapping("/{imdbId}")    // this will be the subsidiary address of the parent mapping (/api/v1/movies) so it's need to /id by the end of parent mapping.
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
