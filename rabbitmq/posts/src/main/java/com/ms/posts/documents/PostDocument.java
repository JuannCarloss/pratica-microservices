package com.ms.posts.documents;

import com.ms.posts.dtos.PostDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "post")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostDocument {

    @Id
    private String id;
    private String username;
    private String title;
    private String body;
    private LocalDate postDate;

    public PostDocument (PostDTO data){
        this.username = data.username();
        this.title = data.title();
        this.body = data.body();
        this.postDate = LocalDate.now();
    }

}
