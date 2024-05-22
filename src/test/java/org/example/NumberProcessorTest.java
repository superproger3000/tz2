package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

class NumberProcessorTest {

    @Test
    void testMin() {
        int[] numbers = {1, 3, 5, 7, 9};
        assertEquals(1, NumberProcessor.min(numbers));
    }

    @Test
    void testMax() {
        int[] numbers = {1, 3, 5, 7, 9};
        assertEquals(9, NumberProcessor.max(numbers));
    }

    @Test
    void testSum() {
        int[] numbers = {1, 3, 5, 7, 9};
        assertEquals(25, NumberProcessor.sum(numbers));
    }

    @Test
    void testMult() {
        int[] numbers = {1, 3, 5, 7, 9};
        assertEquals(945, NumberProcessor.mult(numbers));
    }

    @Test
    void testMinInvalidFile() {
        int[] numbers = NumberProcessor.readNumbersFromFile("invalid.txt");
        assertEquals(0, numbers.length);
    }

    @Test
    void testMaxInvalidFile() {
        int[] numbers = NumberProcessor.readNumbersFromFile("invalid.txt");
        assertEquals(0, numbers.length);
    }

    @Test
    void testSumInvalidFile() {
        int[] numbers = NumberProcessor.readNumbersFromFile("invalid.txt");
        assertEquals(0, numbers.length);
    }

    @Test
    void testMultInvalidFile() {
        int[] numbers = NumberProcessor.readNumbersFromFile("invalid.txt");
        assertEquals(0, numbers.length);
    }

    @RepeatedTest(10)
    void testMinSpeed() {
        int size = 1000;
        int[] numbers = generateRandomArray(size);
        long startTime = System.currentTimeMillis();
        int min = NumberProcessor.min(numbers);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Время выполнения поиска min для массива чисел размера " + size + ": " + elapsedTime + " мс");
    }

    @RepeatedTest(10)
    void testMaxSpeed() {
        int size = 1000;
        int[] numbers = generateRandomArray(size);
        long startTime = System.currentTimeMillis();
        int max = NumberProcessor.max(numbers);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Время выполнения поиска max для массива чисел размера " + size + ": " + elapsedTime + " мс");
    }

    @RepeatedTest(10)
    void testSumSpeed() {
        int size = 1000;
        int[] numbers = generateRandomArray(size);
        long startTime = System.currentTimeMillis();
        int sum = NumberProcessor.sum(numbers);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Время выполнения sum для массива чисел размера " + size + ": " + elapsedTime + " мс");
    }

    @RepeatedTest(10)
    void testMultSpeed() {
        int size = 1000;
        int[] numbers = generateRandomArray(size);
        long startTime = System.currentTimeMillis();
        int mult = NumberProcessor.mult(numbers);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Время выполнения mult для массива чисел размера " + size + ": " + elapsedTime + " мс");
    }

    private int[] generateRandomArray(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(10000);
        }
        return numbers;
    }
}