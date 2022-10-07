package pe.gustavo.functionalprograming.v1_imperative;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //      ¿We want to do?
        // 1. Create list of integers
        List<Integer> numbers = createList();
        System.out.println("numbers = " + numbers);
        // 2. Keep only the pairs
        List<Integer> pairs = filterPairs(numbers);
        System.out.println("pairs = " + pairs);
        // 3. Squaring each number
        List<Integer> squares = squaring(pairs);
        System.out.println("squares = " + squares);
        // 4. Show each square on the screen
        List<Integer> shown = showList(squares);
        // 5. Obtain the sum of the squares
        int total = sumList(shown);
        System.out.println("total = " + total);
    }

    private static int sumList(final List<Integer> numbers) {
        int total = 0;
        for (Integer number : numbers) {
            total += number;
        }
        return total;
    }

    private static List<Integer> showList(final List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.println("showList number: " + number);
        }
        return numbers;
    }

    private static List<Integer> squaring(final List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            result.add(number * number);
        }
        return result;
    }

    private static List<Integer> filterPairs(final List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }

    private static List<Integer> createList() {
        // Inmutable - as of java 9
        return List.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
    }

}