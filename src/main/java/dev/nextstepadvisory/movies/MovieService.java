package dev.nextstepadvisory.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {                     // so to speak, this is the where business logic will go.
    @Autowired
    private MovieRepository movieRepository;    // wire this class to the MovieRepository class, which is the inferior class.

    // fetch all data from the repository(database) layer, then return the data to the API layer.
    public List <Movie> allMovies() {
        return movieRepository.findAll();
    }

    // fetch single observation from the repository(database) layer using their id field.
    // We have to use 'Optional' keyword since it's a chance that input id could return the null values
    // instead of using ObjectId id and findById(id) in the search, we will search it by imdbId instead (please see full code in MovieRepository class)
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
