package pe.gustavo.functionalprograming.v3_superfunctions_classes;

import pe.gustavo.functionalprograming.v3_superfunctions_classes.interfaces.*;

import java.util.List;

// With Anonymous Classes - Java 7(and earlier)
public class Main {
    public static void main(String[] args) {

        //      ¿We want to do?
        // 1. Create list of integers
        List<Integer> numbers = SuperFunctions.supplier(10, new Supplier() {
            java.util.Random random = new java.util.Random();

            @Override
            public Integer get() {
                return random.nextInt(10);
            }
        });
//        List<Integer> numbers = SuperFunctions.supplier(10, new NaturalNumbers());
        System.out.println("numbers = " + numbers);

        // 2. Keep only the pairs
//        List<Integer> filtered = SuperFunctions.filter(numbers, new OnlyOdd());
        List<Integer> filtered = SuperFunctions.filter(numbers, new Predicate() {
            @Override
            public Boolean test(Integer value) {
                return value % 2 == 0;
            }
        });
        System.out.println("filtered = " + filtered);

        // 3. Obtain the square of each number
//        List<Integer> transformed = SuperFunctions.transform(filtered, new Squaring());
        List<Integer> transformed = SuperFunctions.transform(filtered, new Function() {
            @Override
            public Integer apply(Integer value) {
                return value * value;
            }
        });
        System.out.println("transformed = " + transformed);

        // 4a. Show each square on the screen and return list.
        Consumer printer = new Consumer() {
            @Override
            public void accept(Integer value) {
                System.out.println("value = " + value);
            }
        };
//        List<Integer> shown = SuperFunctions.act(transformed, new Printer());
        List<Integer> shown = SuperFunctions.act(transformed, printer);

        // 4b. Show each square on the screen and return nothing
//        SuperFunctions.act(transformed, new Printer());
        SuperFunctions.consume(transformed, printer);

        // 5. Obtain the sum of the squares
        // Identity for addition is 0, 1 for multiplication
        // int total = SuperFunctions.reduce(transformed, 0, new Adder());
        int total = SuperFunctions.reduce(transformed, 0, new BinaryFunction() {
            @Override
            public Integer apply(Integer value1, Integer value2) {
                return value1 + value2;
            }
        });
        System.out.println("total = " + total);
    }
}