package neo4j.io.abovo.demo_neo4j.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectRequest {
    private String subjectName;
    private Long marks;
}
