package neo4j.io.abovo.demo_neo4j.domain.relationship;

import lombok.Getter;
import lombok.Setter;
import neo4j.io.abovo.demo_neo4j.domain.entity.PersonNode;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Getter
@Setter
@RelationshipProperties
public class Friendship {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private PersonNode friend;

    private String since;


}
