package neo4j.io.abovo.demo_neo4j.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Node(labels = {"Student"})
public class Student {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String country;
    @Property(name = "birth_year")
    private Integer birthYear;
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private Department department;
    @Relationship(type = "IS_LEARNING", direction = Relationship.Direction.OUTGOING)
    private List<IsLearningRelation> isLearningRelation;
}
