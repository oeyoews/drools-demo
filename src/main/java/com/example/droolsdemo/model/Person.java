package example.droolsdemo.model;

public class Person {
    private String name;
    private int age;
    private boolean adult;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isAdult() { return adult; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setAdult(boolean adult) { this.adult = adult; }

    @Override
    public String toString() {
        return name + " (" + age + "): " + (adult ? "Adult" : "Not adult");
    }
}