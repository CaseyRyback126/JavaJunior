package ru.geekbrains.lesson1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    //endregion

    /**
     * Балансировка корзины

    public void cardBalancing()
    {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food : foodstuffs)
        {
            if (!proteins && food.getProteins())
                proteins = true;
            else
            if (!fats && food.getFats())
                fats = true;
            else
            if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        for (var thing : market.getThings(clazz))
        {
            if (!proteins && thing.getProteins())
            {
                proteins = true;
                foodstuffs.add(thing);
            }
            else if (!fats && thing.getFats())
            {
                fats = true;
                foodstuffs.add(thing);
            }
            else if (!carbohydrates && thing.getCarbohydrates())
            {
                carbohydrates = true;
                foodstuffs.add(thing);
            }
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
    }*/

    public void cardBalancing() {

        List<Boolean> nutrients = Arrays.asList(false, false, false); // 0 - proteins, 1 - fats, 2 - carbohydrates

        nutrients.stream().anyMatch(nutrient ->
                foodstuffs.stream()
                        .anyMatch(food -> {
                            if (nutrients.get(0) && food.getProteins()) {
                                return true;
                            } else if (nutrients.get(1) && food.getFats()) {
                                return true;
                            } else return nutrients.get(2) && food.getCarbohydrates();
                        })
        );

        if (nutrients.get(0) && nutrients.get(1) && nutrients.get(2)) {
            System.out.println("Корзина уже сбалансирована по БЖУ");
            return;
        }

        market.getThings(clazz).stream()
                .anyMatch(thing -> {
                    if (!nutrients.get(0) && thing.getProteins()) {
                        nutrients.set(0,true);
                        foodstuffs.add(thing);
                    } else if (!nutrients.get(1) && thing.getFats()) {
                        nutrients.set(1,true);
                        foodstuffs.add(thing);
                    } else if (!nutrients.get(2) && thing.getCarbohydrates()) {
                        nutrients.set(2,true);
                        foodstuffs.add(thing);
                    }
                    return nutrients.get(0) && nutrients.get(1) && nutrients.get(2);
                });

        if (nutrients.get(0) && nutrients.get(1) && nutrients.get(2)) {
            System.out.println("Корзина сбалансирована по БЖУ");
        } else {
            System.out.println("Невозможно сбалансировать корзину по БЖУ");
        }
    }
    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs()
    {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));
    }

}
