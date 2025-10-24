package example.droolsdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private boolean adult;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.adult = false;  // default value
        this.sex = sex;
        log.info("Created new person: {} with age {}", name, age);
    }

    @Override
    public String toString() {
        return name + " (" + age + "): " + (adult ? "已成年" : "未成年");
    }
}