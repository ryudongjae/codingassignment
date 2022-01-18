package ryudongjae.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public void saveStudent(StudentDto studentDto){
        studentRepository.save(studentDto.toEntity());
    }
    @Transactional(readOnly = true)
    public Student getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        return student;
    }
    @Transactional(readOnly = true)
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @Transactional
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(StudentDto student,Long id){
        Student student1 = studentRepository.findById(id).orElseThrow();
        student1.update(student);
    }
}
