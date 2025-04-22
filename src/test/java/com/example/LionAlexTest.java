package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionAlexTest {
    @Mock
    Feline feline;
    @DisplayName("Проверка метода getFriends")
    @Test
    public void lionAlexGetFriends() throws Exception {
        assertEquals(List.of("Марти", "Глория", "Мелман"), new LionAlex(feline).getFriends());
    }

    @DisplayName("Проверка метода getPlaceOfLiving")
    @Test
    public void lionAlexGetPlaceOfLiving() throws Exception {
        assertEquals("Нью-Йоркский зоопарк", new LionAlex(feline).getPlaceOfLiving());
    }

    @DisplayName("Проверка метода getKittens")
    @Test
    public void lionAlexGetKittens() throws Exception {
        assertEquals(0, new LionAlex(feline).getKittens());
    }
}
