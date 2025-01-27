package neo4j.io.abovo.demo_neo4j.api.controller;

import neo4j.io.abovo.demo_neo4j.api.dto.StudentRequest;
import neo4j.io.abovo.demo_neo4j.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class DemoController {
    private StudentService studentService;

    public DemoController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest) {
        studentService.createStudent(studentRequest);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}

// run spring boot with a profile dev
// mvn spring-boot:run -Dspring-boot.run.profiles=dev
