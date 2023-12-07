package ru.geekbrains.lesson1.task2.meanNumber;

import java.util.List;

public class Main {
    /**
     * Напишите программу, которая использует Stream API для обработки списка чисел.
     * Программа должна вывести на экран среднее значение всех четных чисел в списке.
     * 1. Создаём список чисел
     * 2. Преобразуем его в поток (stream)
     * 3. Фильтруем - оставляем только чётные числа
     * 4. Преобразуем в IntStream, чтобы подсчитать среднее значение.
     * 5. Вызываем average() для подсчёта среднего значения
     * 6. Выводим результат на экран
     */
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        double evenAvg = numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .average()
                .orElse(0);

        System.out.println(evenAvg);
    }

}
