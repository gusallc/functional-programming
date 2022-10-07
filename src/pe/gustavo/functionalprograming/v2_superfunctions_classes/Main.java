package pe.gustavo.functionalprograming.v2_superfunctions_classes;

import pe.gustavo.functionalprograming.v2_superfunctions_classes.classes.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //      ¿We want to do?
        // 1. Create list of integers
        List<Integer> numbers = SuperFunctions.supplier(10, new Random());
//        List<Integer> numbers = SuperFunctions.supplier(10, new NaturalNumbers());
        System.out.println("numbers = " + numbers);
        // 2. Keep only the pairs
//        List<Integer> filtered = SuperFunctions.filter(numbers, new OnlyOdd());
        List<Integer> filtered = SuperFunctions.filter(numbers, new OnlyPairs());
        System.out.println("filtered = " + filtered);
        // 3. Obtain the square of each number
//        List<Integer> transformed = SuperFunctions.transform(filtered, new Squaring());
        List<Integer> transformed = SuperFunctions.transform(filtered, new Cube());
        System.out.println("transformed = " + transformed);
        // 4a. Show each square on the screen and return list.
//        List<Integer> shown = SuperFunctions.act(transformed, new Printer());
        // 4b. Show each square on the screen and return nothing
        SuperFunctions.consume(transformed, new Printer());
        // 5. Obtain the sum of the squares
        // Identity for addition is 0
        // int total = SuperFunctions.reduce(transformed, 0, new Adder());
        //
        int total = SuperFunctions.reduce(transformed, 1, new Multiplier());
        System.out.println("total = " + total);
    }
}