package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @DisplayName("Проверка getKittens с параметром")
    @Test
    public void getKittens10Returns10() {
        assertEquals(10, feline.getKittens(10));
        Mockito.verify(feline, Mockito.times(1)).getKittens(10);
    }
    @DisplayName("Проверка getKittens без параметра")
    @Test
    void getKittensReturns1() {
        assertEquals(1, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @DisplayName("Проверка метода getFamily")
    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }
    @DisplayName("Проверка метода eatMeat")
    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

}
