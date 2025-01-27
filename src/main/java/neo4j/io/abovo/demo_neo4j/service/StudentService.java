package neo4j.io.abovo.demo_neo4j.service;

import neo4j.io.abovo.demo_neo4j.domain.entity.Department;
import neo4j.io.abovo.demo_neo4j.domain.relationship.IsLearningRelation;
import neo4j.io.abovo.demo_neo4j.domain.entity.Student;
import neo4j.io.abovo.demo_neo4j.domain.entity.Subject;
import neo4j.io.abovo.demo_neo4j.api.dto.StudentRequest;
import neo4j.io.abovo.demo_neo4j.repository.DepartmentRepository;
import neo4j.io.abovo.demo_neo4j.repository.StudentRepository;
import neo4j.io.abovo.demo_neo4j.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;
    private DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.departmentRepository = departmentRepository;
    }

    public Student createStudent(StudentRequest studentRequest) {
        Department department = new Department();
        department.setDepName("Computer Science");
        departmentRepository.save(department);

        List<IsLearningRelation> isLearningRelationList = new ArrayList<>();

        if (studentRequest.getSubjects() != null) {
            studentRequest.getSubjects().forEach(subjectRequest -> {

                Subject subject = new Subject();
                subject.setSubjectName(subjectRequest.getSubjectName());
                subjectRepository.save(subject);

                IsLearningRelation isLearningRelation = new IsLearningRelation();
                isLearningRelation.setSubject(subject);
                isLearningRelation.setMarks(subjectRequest.getMarks());
                isLearningRelationList.add(isLearningRelation);
            });
        }

        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setCountry(studentRequest.getCountry());
        student.setBirthYear(studentRequest.getBirthYear());
        student.setDepartment(department);
        student.setIsLearningRelation(isLearningRelationList);
        studentRepository.save(student);

        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
