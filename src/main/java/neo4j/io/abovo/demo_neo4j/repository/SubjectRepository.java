package neo4j.io.abovo.demo_neo4j.repository;

import neo4j.io.abovo.demo_neo4j.domain.entity.Subject;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface SubjectRepository extends Neo4jRepository<Subject, UUID> {
}
