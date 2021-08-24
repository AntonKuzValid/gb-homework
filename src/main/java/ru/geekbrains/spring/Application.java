package ru.geekbrains.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

    /**
     * 1. Добавить поле Производитель - Реализовать свой валидатор который проверяет компанию в каком то списке (через аннотацию @Company)
     * 2. Product code = Название продукта - Произовдитель (яблоко - Григорьевы сады) десериализовалось в 2 отдельных поля name и company
     * 3. Реализовать REST-controller , который предотсавляет возможности урпаавления товаром (сортировка, фильтры, удаление, добавление, обновление)
     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
