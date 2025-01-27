package neo4j.io.abovo.demo_neo4j.repository;

import neo4j.io.abovo.demo_neo4j.domain.entity.Department;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface DepartmentRepository extends Neo4jRepository<Department, UUID> {
}
