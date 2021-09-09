package ru.geekbrains.data;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

    /**
     * 1. Реализовать frontend при помощи angularjs ++
     * 2. Вывести список товаров ++
     * 3. Добавить форму для добавления товара ++
     * 4. Добавить форму для фильтрации и сортировки ++
     * 5. Рядом с каждым товаром в таблице попробуйте сделать кнопку “Удалить”, при нажатии на которую товар ++
     * должен быть удален и базы и Кнопку изменить при нажатии на которую изменяется товар. --
     * Опционально - Сделайте пагинацию ++
     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
