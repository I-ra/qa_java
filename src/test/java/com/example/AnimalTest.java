package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AnimalTest {
    static Stream<Arguments> getFoodTestDataPositive() {
        return Stream.of(
                arguments("Хищник", List.of("Животные", "Птицы", "Рыба")),
                arguments("Травоядное", List.of("Трава", "Различные растения"))
        );
    }
    static Stream<Arguments> getFoodTestDataNegative() {
        return Stream.of(
                arguments("Что-то среднее", Exception.class)
        );
    }
    @ParameterizedTest
    @DisplayName("Проверка позитивных сценариев метода getFood класса Animal")
    @MethodSource("getFoodTestDataPositive")
    public void animalGetFoodTestPositive(String animalKind, List listFood) throws Exception {
        assertEquals(listFood, new Animal().getFood(animalKind));
    }

    @ParameterizedTest
    @DisplayName("Проверка негативного сценария метода getFood класса Animal, вызов ошибки")
    @MethodSource("getFoodTestDataNegative")
    public void animalGetFoodTestNegative(String animalKind, Class<? extends Exception> exception) {
        assertThrows(exception, () -> new Animal().getFood(animalKind));
    }

    @DisplayName("Проверка позитивного сценария метода getFamily класса Animal")
    @Test
    public void animalGetFamily() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                new Animal().getFamily());
    }

}
