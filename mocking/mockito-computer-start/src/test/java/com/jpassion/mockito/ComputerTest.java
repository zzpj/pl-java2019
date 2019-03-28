package com.jpassion.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ComputerTest {

    private Adder adder;
    private Subtractor sub;
    private Computer sut;

    @BeforeEach
    public void setUp() {
        adder = mock(Adder.class);
        sub = mock(Subtractor.class);
        sut = new Computer(adder, sub);
    }

    @Test
    public void shouldReturnSquareOfSumOfPositiveNumbers() {
        when(adder.add(1, 2)).thenReturn(3);
        when(sub.subtract(3, 1)).thenReturn(2);

        assertEquals(sut.computeSquareAfterAddition(1,2),9);
    }

    @Test
    public void shouldReturnSquareOfDifferenceOfPositiveNumbers() {
        when(adder.add(1, 2)).thenReturn(3);
        when(sub.subtract(3, 1)).thenReturn(2);

        assertEquals(sut.computeSquareAfterSubtraction(3,1),4);
    }

    @Test
    public void shouldThrowExceptionOnSumIfNumberIsNegative() {
        int x = -1;
        int y = 4;
        when(adder.add(x, y)).thenThrow(new RuntimeException(String.format("negative number not allowed: %d %d", x, y)));

        assertThrows(RuntimeException.class, () -> sut.computeSquareAfterAddition(x, y));
    }

    @Test
    public void shouldThrowExceptionOnDifferenceIfNumberIsNegative() {
        int x = 15;
        int y = -2;
        when(sub.subtract(x, y)).thenThrow(new RuntimeException(String.format("negative number not allowed: %d %d", x, y)));

        assertThrows(RuntimeException.class, () -> sut.computeSquareAfterSubtraction(x, y));
    }
}