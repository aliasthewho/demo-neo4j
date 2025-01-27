package neo4j.io.abovo.demo_neo4j.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PersonDTO {
    private UUID id;
    private String name;
    private int age;
    private List<UUID> friends;
    private List<UUID> likedBooks;
}
