package lesson2.animalReflection;

public class Cat extends Animal {
    int livesLeft;

    Cat(String name, int age, int livesLeft) {
        super(name, age);
        this.livesLeft = livesLeft;
    }

    public void makeSound() {
        System.out.println(name + " мяукает");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "имя = '" + name + '\'' +
                ", осталось жизней = " + livesLeft +
                ", возраст = " + age +
                '}';
    }
}
