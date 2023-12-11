package lesson2.animalReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal[] animals = {
                new Dog("Бобик", 5, "Лабрадор"),
                new Cat("Мурка", 3, 7)
        };

        for (Animal animal : animals) {
            System.out.println(animal);

            Method method = animal.getClass().getMethod("makeSound");
            if (method != null) {
                method.invoke(animal);
            }
        }
    }
}
