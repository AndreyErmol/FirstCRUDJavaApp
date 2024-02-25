package spring.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Person {
    private int id;

    @NotNull
    @Size(min = 2, max = 15)
    private String personName;
    @Min(value = 0)
    private int age;
    @NotNull(message = "Email should not be empty")
    @Email
    private String email;

    public Person(int id, String personName, int age, String email) {
        this.id = id;
        this.personName = personName;
        this.age = age;
        this.email = email;
    }

    public Person() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String name) {
        this.personName = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
