package ryudongjae.rest;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StudentDto {

    private String name;
    private int age;
    private Gender gender;

    @Builder
    public StudentDto(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student toEntity() {
        return Student.builder()
                .name(this.name)
                .age(this.age)
                .gender(this.gender)
                .build();
    }
}
