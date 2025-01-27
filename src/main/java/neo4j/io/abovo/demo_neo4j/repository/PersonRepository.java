package neo4j.io.abovo.demo_neo4j.repository;

import neo4j.io.abovo.demo_neo4j.domain.entity.BookNode;
import neo4j.io.abovo.demo_neo4j.domain.entity.PersonNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends Neo4jRepository<PersonNode, UUID> {
    PersonNode findByName(String name);

    @Query("""
            MATCH (p1:Person)-[:FRIEND]->(mutual:Person)<-[:FRIEND]-(p2:Person)
            WHERE p1.id = $personId AND p2.id = $friendId
            RETURN mutual
            """)
    List<PersonNode> findMutualFriends(UUID personId, UUID friendId);

    @Query("""
            MATCH (p:Person)-[:FRIEND]->(f:Person)-[:LIKES]->(b:Book)
            WHERE p.id = $personId AND NOT (p)-[:LIKES]->(b)
            RETURN DISTINCT b
            """)
    List<BookNode> recommendBooks(UUID personId);
}
