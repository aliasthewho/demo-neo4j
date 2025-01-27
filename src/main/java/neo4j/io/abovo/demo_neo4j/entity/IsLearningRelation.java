package neo4j.io.abovo.demo_neo4j.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Getter
@Setter
@RelationshipProperties
public class IsLearningRelation {
    @Id
    @GeneratedValue
    private String id;
    private Long marks;
    @TargetNode
    private Subject subject;
}
