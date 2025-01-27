package neo4j.io.abovo.demo_neo4j.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.UUID;

@Getter
@Setter
@Node(labels = {"Department"})
public class Department {
    @Id
    @GeneratedValue
    private UUID id;

    @Property(name = "dep_name")
    private String depName;
}
