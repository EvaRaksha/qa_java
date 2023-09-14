package com.example.test;

import com.example.Feline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals("Животные", feline.eatMeat().get(0));
        assertEquals("Птицы", feline.eatMeat().get(1));
        assertEquals("Рыба", feline.eatMeat().get(2));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
        assertEquals(3, feline.getKittens(3));
    }

}