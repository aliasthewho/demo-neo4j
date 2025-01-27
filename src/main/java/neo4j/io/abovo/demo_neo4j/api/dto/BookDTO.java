package neo4j.io.abovo.demo_neo4j.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookDTO {
    private UUID id;
    private String title;
    private String author;
    private String genre;
}
