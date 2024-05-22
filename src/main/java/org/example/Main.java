package org.example;

public class Main {
    public static void main(String[] args) {
        int[] numbers = NumberProcessor.readNumbersFromFile("input.txt");
        int min = NumberProcessor.min(numbers);
        System.out.println("Минимальное: " + min);
        int max = NumberProcessor.max(numbers);
        System.out.println("Максимальное: " + max);
        int sum = NumberProcessor.sum(numbers);
        System.out.println("Сумма: " + sum);
        int mult = NumberProcessor.mult(numbers);
        System.out.println("Произведение: " + mult);
    }
}
