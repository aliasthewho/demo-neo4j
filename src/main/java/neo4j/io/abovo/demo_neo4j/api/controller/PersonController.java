package neo4j.io.abovo.demo_neo4j.api.controller;

import neo4j.io.abovo.demo_neo4j.api.dto.BookDTO;
import neo4j.io.abovo.demo_neo4j.api.dto.PersonDTO;
import neo4j.io.abovo.demo_neo4j.domain.entity.BookNode;
import neo4j.io.abovo.demo_neo4j.domain.entity.PersonNode;
import neo4j.io.abovo.demo_neo4j.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonNode> createPerson(@RequestBody PersonNode person) {
        PersonNode savedPerson = personService.createPerson(person);
        return ResponseEntity.ok(savedPerson);
    }

    @PostMapping("/{personId}/friends/{friendId}")
    public ResponseEntity<?> addFriend(
            @PathVariable UUID personId,
            @PathVariable UUID friendId) {

        personService.addFriend(personId, friendId);
        return ResponseEntity.ok("Friend added successfully");
    }

    @GetMapping("/{personId}/mutual-friends/{friendId}")
    public ResponseEntity<List<PersonDTO>> getMutualFriends(
            @PathVariable UUID personId,
            @PathVariable UUID friendId) {

        List<PersonNode> mutualFriends = personService.findMutualFriends(personId, friendId);
        List<PersonDTO> mutualFriendsDTO = mutualFriends.stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(mutualFriendsDTO);
    }

    @GetMapping("/{personId}/recommend-books")
    public ResponseEntity<List<BookDTO>> recommendBooks(@PathVariable UUID personId) {
        List<BookNode> books = personService.recommendBooks(personId);
        List<BookDTO> booksDTO = books.stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(booksDTO);
    }

    private PersonDTO convertToDTO(PersonNode person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setAge(person.getAge());
        dto.setFriends(person.getFriends().stream().map(f->f.getFriend().getId()).toList());
        dto.setLikedBooks(person.getLikes().stream().map(l -> l.getBook().getId()).toList());
        return dto;
    }

    private BookDTO convertToDTO(BookNode book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        return dto;
    }
}
