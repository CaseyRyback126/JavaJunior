package lesson2.animalReflection;

public class Dog extends Animal {
    String breed;

    Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void makeSound() {
        System.out.println(name + " гавкает");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "порода = '" + breed + '\'' +
                ", имя = '" + name + '\'' +
                ", возраст = " + age +
                '}';
    }
}
