package neo4j.io.abovo.demo_neo4j.util;

import neo4j.io.abovo.demo_neo4j.domain.entity.BookNode;
import neo4j.io.abovo.demo_neo4j.domain.entity.PersonNode;
import neo4j.io.abovo.demo_neo4j.domain.relationship.Friendship;
import neo4j.io.abovo.demo_neo4j.domain.relationship.Likes;
import neo4j.io.abovo.demo_neo4j.repository.BookRepository;
import neo4j.io.abovo.demo_neo4j.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("dev")
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(PersonRepository personRepository, BookRepository bookRepository) {
        return args -> {
            // Create Books
            BookNode book1 = new BookNode();
            book1.setTitle("1984");
            book1.setAuthor("George Orwell");
            book1.setGenre("Dystopian");

            BookNode book2 = new BookNode();
            book2.setTitle("Pride and Prejudice");
            book2.setAuthor("Jane Austen");
            book2.setGenre("Romance");

            BookNode book3 = new BookNode();
            book3.setTitle("The Hobbit");
            book3.setAuthor("J.R.R. Tolkien");
            book3.setGenre("Fantasy");

            bookRepository.saveAll(List.of(book1, book2, book3));

            // Create Persons
            PersonNode alice = new PersonNode();
            alice.setName("Alice");
            alice.setAge(40);

            PersonNode bob = new PersonNode();
            bob.setName("Bob");
            bob.setAge(42);

            PersonNode charlie = new PersonNode();
            charlie.setName("Charlie");
            charlie.setAge(20);

            PersonNode diana = new PersonNode();
            diana.setName("Diana");
            diana.setAge(18);

            PersonNode eve = new PersonNode();
            eve.setName("Eve");
            eve.setAge(35);

            PersonNode frank = new PersonNode();
            frank.setName("Frank");
            frank.setAge(50);

            personRepository.saveAll(List.of(alice, bob, charlie, diana, eve, frank));

            // Add Friendships (Bidirectional)
            Friendship aliceToBob = new Friendship();
            aliceToBob.setFriend(bob);

            Friendship aliceToCharlie = new Friendship();
            aliceToCharlie.setFriend(charlie);

            alice.setFriends(List.of(aliceToBob, aliceToCharlie));

            Friendship bobToAlice = new Friendship();
            bobToAlice.setFriend(alice);

            Friendship bobToEve = new Friendship();
            bobToEve.setFriend(eve);

            bob.setFriends(List.of(bobToAlice, bobToEve));

            Friendship charlieToAlice = new Friendship();
            charlieToAlice.setFriend(alice);

            Friendship charlieToDiana = new Friendship();
            charlieToDiana.setFriend(diana);

            charlie.setFriends(List.of(charlieToAlice, charlieToDiana));

            Friendship eveToBob = new Friendship();
            eveToBob.setFriend(bob);

            Friendship eveToFrank = new Friendship();
            eveToFrank.setFriend(frank);

            eve.setFriends(List.of(eveToBob, eveToFrank));

            personRepository.saveAll(List.of(alice, bob, charlie, diana, eve, frank));

            // Add Likes Relationships
            Likes aliceLikesBook1 = new Likes();
            aliceLikesBook1.setBook(book1);

            Likes aliceLikesBook2 = new Likes();
            aliceLikesBook2.setBook(book2);

            alice.setLikes(List.of(aliceLikesBook1, aliceLikesBook2));

            Likes bobLikesBook2 = new Likes();
            bobLikesBook2.setBook(book2);

            Likes bobLikesBook3 = new Likes();
            bobLikesBook3.setBook(book3);

            bob.setLikes(List.of(bobLikesBook2, bobLikesBook3));

            Likes charlieLikesBook1 = new Likes();
            charlieLikesBook1.setBook(book1);

            charlie.setLikes(List.of(charlieLikesBook1));

            Likes dianaLikesBook3 = new Likes();
            dianaLikesBook3.setBook(book3);

            diana.setLikes(List.of(dianaLikesBook3));

            Likes eveLikesBook1 = new Likes();
            eveLikesBook1.setBook(book1);

            Likes eveLikesBook3 = new Likes();
            eveLikesBook3.setBook(book3);

            eve.setLikes(List.of(eveLikesBook1, eveLikesBook3));

            Likes frankLikesBook2 = new Likes();
            frankLikesBook2.setBook(book2);

            frank.setLikes(List.of(frankLikesBook2));

            // Save all relationships
            personRepository.saveAll(List.of(alice, bob, charlie, diana, eve, frank));
        };
    }
}
