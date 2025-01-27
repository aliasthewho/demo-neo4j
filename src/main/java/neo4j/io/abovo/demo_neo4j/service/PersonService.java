package neo4j.io.abovo.demo_neo4j.service;

import jakarta.transaction.Transactional;
import neo4j.io.abovo.demo_neo4j.domain.entity.BookNode;
import neo4j.io.abovo.demo_neo4j.domain.entity.PersonNode;
import neo4j.io.abovo.demo_neo4j.domain.relationship.Friendship;
import neo4j.io.abovo.demo_neo4j.repository.BookRepository;
import neo4j.io.abovo.demo_neo4j.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final BookRepository bookRepository;

    public PersonService(PersonRepository personRepository, BookRepository bookRepository) {
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
    }

    public PersonNode createPerson(PersonNode personNode) {
        return personRepository.save(personNode);
    }

    public PersonNode findByName(String name) {
        return personRepository.findByName(name);
    }

    public PersonNode findById(UUID id) {
        return personRepository.findById(id).orElse(null);
    }

    @Transactional
    public void addFriend(UUID personId, UUID friendId) {
        PersonNode person = personRepository.findById(personId)
                .orElseThrow(()->new RuntimeException("Person not found"));
        PersonNode friend = personRepository.findById(friendId)
                .orElseThrow(()->new RuntimeException("Friend not found"));

        boolean alreadyFriends = person.getFriends().stream()
                .anyMatch(f -> f.getId().equals(friendId));

        if (alreadyFriends) {
            throw new RuntimeException("Already friends");
        }

        // Add the frindship relationship
        Friendship friendship = new Friendship();
        friendship.setFriend(friend);
        person.getFriends().add(friendship);

        personRepository.save(person);

        // add reverse frindship
        Friendship reverseFriendship = new Friendship();
        reverseFriendship.setFriend(person);
        friend.getFriends().add(reverseFriendship);
        personRepository.save(friend);
    }

    public List<PersonNode> findMutualFriends(UUID personId, UUID friendId) {
        return personRepository.findMutualFriends(personId, friendId);
    }

    public List<BookNode> recommendBooks(UUID personId) {
        return personRepository.recommendBooks(personId);
    }
}
