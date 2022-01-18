package ryudongjae.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Builder
    public Student(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void update(StudentDto studentDto) {
        this.name = studentDto.getName();
        this.age = studentDto.getAge();
        this.gender = studentDto.getGender();
    }
}
