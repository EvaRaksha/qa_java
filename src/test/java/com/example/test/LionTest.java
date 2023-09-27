package com.example.test;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline felineMock;

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion maleLion = new Lion("Самец", felineMock);
        Lion femaleLion = new Lion("Самка", felineMock);
        assertTrue(maleLion.doesHaveMane());
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSex() {
        new Lion("Недопустимое значение пола", felineMock);
    }

    @Test
    public void testGetKittens() {
        Lion lion = new Lion("Самка", felineMock);
        when(felineMock.getKittens()).thenReturn(3);
        int kittensCount = lion.getKittens();
        assertEquals(3, kittensCount);
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> food = lion.getFood();
        assertEquals(expectedFood, food);
    }
}