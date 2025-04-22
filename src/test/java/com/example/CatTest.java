package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline feline;

    @InjectMocks
    private Cat cat;
    @DisplayName("Проверка позитивного сценария метода getSound класса Cat")
    @Test
    void catGetSoundTest() {
        assertEquals("Мяу", cat.getSound());
    }
    @DisplayName("Проверка позитивного сценария метода getFood класса Cat")
    @Test
    public void catGetFoodTest() throws Exception {
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}