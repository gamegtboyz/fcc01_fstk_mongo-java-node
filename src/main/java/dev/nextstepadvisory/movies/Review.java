package dev.nextstepadvisory.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;

    // since IDs is auto-generated so it couldn't be passed to the class. So, we have to generated the custom constructor that takes only the body.
    public Review(String body) {
        this.body = body;
    }
}