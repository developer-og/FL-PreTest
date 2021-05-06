package app.user.model;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "user")
public class User {

    @Id
    private String _id;

    private String userId;

    private String password;

    public User(){}

    public void update(String password) {
        this.password = password;
    }

}
