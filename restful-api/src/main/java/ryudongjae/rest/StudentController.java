package ryudongjae.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;
    @PostMapping(value = "/students")
    public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto student){
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }
    @GetMapping(value = "/students")
    public List<Student> getStudent(){
        List<Student> student = studentRepository.findAll();
        return student;
    }
    @GetMapping(value = "/students/{id}")
    public EntityModel<Student> getStudentById(@PathVariable Long id){
        Student student = studentRepository.findById(id).orElseThrow();

        EntityModel<Student> model = new EntityModel<>(student);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getStudent());
        model.add(linkTo(StudentController.class).withRel("getStudentById"));

        return model;

    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(value = "/students/{id}")
    public void updateStudent(StudentDto student ,@PathVariable  Long id){
        studentService.updateStudent(student,id);
    }
}
