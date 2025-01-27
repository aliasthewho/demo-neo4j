package neo4j.io.abovo.demo_neo4j.repository;

import neo4j.io.abovo.demo_neo4j.entity.Student;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface StudentRepository extends Neo4jRepository<Student, UUID> {
}
