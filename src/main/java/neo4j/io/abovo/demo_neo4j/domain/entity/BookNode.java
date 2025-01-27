package neo4j.io.abovo.demo_neo4j.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Node(labels = {"Book"})
public class BookNode {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String author;
    private Integer year;
    private String genre;

    @Relationship(type = "LIKES", direction = Relationship.Direction.INCOMING)
    private List<PersonNode> likedBy;
}
