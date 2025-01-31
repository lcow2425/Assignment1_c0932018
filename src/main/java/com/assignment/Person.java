package main.java.com.assignment;
import java.util.Objects;
import java.util.Optional;

public class Person {
    private String name;
    private Integer age;
    private Optional<Dog> dog;

    // Constructor that initializes name and age only
    public Person(String name, Integer age) {
        this(name, age, null);
    }

    // Constructor that initializes all attributes
    public Person(String name, Integer age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = Optional.ofNullable(dog);
    }

    // Method to check if the person has an old dog (age >= 10)
    public boolean hasOldDog() {
        return dog.map(d -> d.getAge() >= 10).orElse(false);
    }

    // Method to change the dog's name if the person owns a dog
    public void changeDogsName(String newName) {
        dog.ifPresentOrElse(
            d -> d.setName(newName),
            () -> { throw new RuntimeException(this.name + " does not own a dog!"); }
        );
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Optional<Dog> getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = Optional.ofNullable(dog);
    }

    // Override equals and hashCode for proper object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(dog, person.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dog);
    }
}