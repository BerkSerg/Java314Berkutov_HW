package hw26_streams;

import hw26_streams.classes.Product;
import hw26_streams.enums.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 3.	Группировка и подсчет:
 * o	Создайте список объектов Product с полями name, category и price.
 * o	Используя Stream, сгруппируйте продукты по категории.
 * o	Для каждой категории подсчитайте количество продуктов и их суммарную стоимость.
 */

public class Task3 {
    private final static ArrayList<Product> storage = new ArrayList<>();

    public static void main(String[] args) {
        initStorage();

        Map<Category, List<Product>> storageByCategory = storage.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        storageByCategory.forEach((category, products) -> {
            System.out.println("\nКатегория продуктов: " + category);
            System.out.println("Количество наименований: " + products.size());
            System.out.println("Стоимость: " + products.stream().map(Product::getPrice).reduce(0d, Double::sum));
        });
    }

    private static void initStorage() {
        storage.add(new Product("Бананы", Category.FRUITS, 140));
        storage.add(new Product("Апельсины", Category.FRUITS, 170));
        storage.add(new Product("Яблоки", Category.FRUITS, 100));
        storage.add(new Product("Груши", Category.FRUITS, 270));

        storage.add(new Product("Картофель", Category.VEGETABLES, 50));
        storage.add(new Product("Кабачки", Category.VEGETABLES, 220));
        storage.add(new Product("Лук", Category.VEGETABLES, 30));
        storage.add(new Product("Огурцы", Category.VEGETABLES, 200));
        storage.add(new Product("Капуста", Category.VEGETABLES, 65));
        storage.add(new Product("Морковь", Category.VEGETABLES, 45));

        storage.add(new Product("Молоко", Category.DAIRY, 80));
        storage.add(new Product("Кефир", Category.DAIRY, 60));
        storage.add(new Product("Творог", Category.DAIRY, 450));
        storage.add(new Product("Масло", Category.DAIRY, 130));
        storage.add(new Product("Сыр", Category.DAIRY, 800));

    }
}
