package serialization;

import java.io.*;

/**
 * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализуйте этот объект в файл.
 * Десериализуйте объект обратно в программу из файла. Выведите все поля объекта,
 * включая GPA, и обсудите почему значение GPA не было сохранено/восстановлено.
 * <p>
 *  При десериализации значение gpa = 0.0,
 *  так как это поле помечено модификатором transient - такие поля не сериализуются.
 *  Transient-поля игнорируются механизмом сериализации для экономии памяти,
 *  так как их значения могут быть пересчитаны.
 *
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        student.setName("John");
        student.setAge(20);
        student.setGpa(4.5);

        FileOutputStream fos = new FileOutputStream("student.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);

        FileInputStream fis = new FileInputStream("student.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        student = (Student) ois.readObject();

        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getGpa());
    }
}
