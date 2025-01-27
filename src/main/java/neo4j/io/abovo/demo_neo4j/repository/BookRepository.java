package neo4j.io.abovo.demo_neo4j.repository;

import neo4j.io.abovo.demo_neo4j.domain.entity.BookNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface BookRepository extends Neo4jRepository<BookNode, UUID> {
    BookNode findByTitle(String title);
}
