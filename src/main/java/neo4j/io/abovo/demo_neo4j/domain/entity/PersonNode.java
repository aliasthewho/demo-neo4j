package neo4j.io.abovo.demo_neo4j.domain.entity;

import lombok.Getter;
import lombok.Setter;
import neo4j.io.abovo.demo_neo4j.domain.relationship.Friendship;
import neo4j.io.abovo.demo_neo4j.domain.relationship.Likes;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Node(labels = {"Person"})
public class PersonNode {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private int age;

    @Relationship(type = "FRIEND", direction = Relationship.Direction.OUTGOING)
    private List<Friendship> friends;

    @Relationship(type = "LIKES", direction = Relationship.Direction.OUTGOING)
    private List<Likes> likes;
}
