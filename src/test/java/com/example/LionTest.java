package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    static Stream<Arguments> doesHaveManeTestDataPositive() {
        return Stream.of(
                arguments("Самка", false),
                arguments("Самец", true)
        );
    }
    static Stream<Arguments> doesHaveManeTestDataNegative() {
        return Stream.of(
                arguments("Что-то среднее", Exception.class)
        );
    }
    @ParameterizedTest
    @DisplayName("Проверка позитивных сценариев метода doesHaveMane класса Lion")
    @MethodSource("doesHaveManeTestDataPositive")
    public void lionDoesHaveManTestPositive(String sex, boolean result) throws Exception {
        assertEquals(result, new Lion(feline, sex).doesHaveMane());
    }

    @ParameterizedTest
    @DisplayName("Проверка негативного сценария метода doesHaveMane класса Lion, вызов ошибки")
    @MethodSource("doesHaveManeTestDataNegative")
    public void lionDoesHaveManTestNegative(String sex, Class<? extends Exception> exception) {
        assertThrows(exception, () -> new Lion(feline, sex).doesHaveMane());
    }

    @DisplayName("Проверка, что при вызове метода getKittens у экземпляра класса Lion у feline вызывается метод getKittens")
    @Test
    public void lionGetKittensTestPositive() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion(feline, "Самец");
        assertEquals(3, lion.getKittens());
    }

}