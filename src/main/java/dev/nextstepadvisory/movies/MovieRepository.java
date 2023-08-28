package dev.nextstepadvisory.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {     // Repository classes is the Java class which is connected to the databases (a.k.a data access layer). it refers to Movie class (the database classes) and ObjectId field, the PM of the 'Movie' table.
    // from the singleMovie search, we do not want to expose ObjectId so we need to do the search by imdbId itself so you have to do the following lines
    // the reference field should be unique or else the code will return the multiple observations.
    Optional<Movie> findMovieByImdbId(String imdbId);
}
