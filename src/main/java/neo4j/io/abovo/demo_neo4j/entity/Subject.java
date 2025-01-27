package neo4j.io.abovo.demo_neo4j.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.UUID;

@Getter
@Setter
@Node(labels = {"Subject"})
public class Subject {
    @Id
    @GeneratedValue
    private UUID id;
    @Property(name = "subject_name")
    private String subjectName;
}
