package dev.nextstepadvisory.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    // connect to the Repository layer, which is inferior
    @Autowired
    private ReviewRepository reviewRepository;



    // create a template to form up the new dynamic query and do the job inside db without using repository
    @Autowired
    private MongoTemplate mongoTemplate;

    // first, the code will looking for imdbId. Then create the new Review and associate review to the found movie.
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        // review posting mechanism (matching MovieId, then update the review)
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
