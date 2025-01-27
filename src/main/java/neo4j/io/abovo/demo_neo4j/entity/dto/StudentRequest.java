package neo4j.io.abovo.demo_neo4j.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentRequest {
    private String name;
    private String country;
    private Integer birthYear;
    private DepartmentRequest department;
    private List<SubjectRequest> subjects;
}
