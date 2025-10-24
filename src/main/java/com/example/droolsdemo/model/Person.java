package example.droolsdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private boolean adult;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.adult = false;  // default value
    }

    @Override
    public String toString() {
        return name + " (" + age + "): " + (adult ? "已成年" : "未成年");
    }
}