package pe.gustavo.functionalprograming.v4_superfunctions_classes;

import pe.gustavo.functionalprograming.v4_superfunctions_classes.interfaces.*;

import java.util.List;

// Generics
public class Main {
    public static void main(String[] args) {

        //      ¿We want to do?
        // 1. Create list of integers
        /* It is not necessary to explicitly indicate tha data type of the argument ""Supplier<Integer>() "" ,
         since it can be inferred from List<Integer>(<T>) - (of the data type where the response will be stored) */
        List<Integer>/*<T>*/ numbers = SuperFunctions.supplier(10, new Supplier<>() {
            final java.util.Random random = new java.util.Random();

            @Override
            public Integer get() {
                return random.nextInt(10);
            }
        });
//        List<Integer> numbers = SuperFunctions.supplier(10, new NaturalNumbers());
        System.out.println("numbers = " + numbers);

        // 2. Keep only the pairs
//        List<Integer> filtered = SuperFunctions.filter(numbers, new OnlyOdd());
        List<Integer> filtered = SuperFunctions.filter(numbers, new Predicate<>() {
            @Override
            public Boolean test(Integer value) {
                return value % 2 == 0;
            }
        });
        System.out.println("filtered = " + filtered);

        // 3a. Obtain the square of each number
//        List<Integer> transformed = SuperFunctions.transform(filtered, new Squaring());
        // CAN BE INFERRED FROM THE DATA TYPE OF "T" and "R"
        List<Integer>/*<R>*/ transformed = SuperFunctions.transform(filtered/*<T>*/, new UnaryOperator<>() {
            @Override
            public Integer apply(Integer value) {
                return value * value;
            }
        });
        System.out.println("transformed = " + transformed);
        // 3b. Obtain the square of each number in String
        List<String>/*<R>*/ transformedIntoString = SuperFunctions.transform(transformed/*<T>*/, new Function<Integer, String>() {
            @Override
            public String apply(Integer value) {
                return "List in String value: " + value;
            }
        });
        System.out.println(transformedIntoString);

        // 4a. Show each square on the screen and return list.
        // here, the data type cannot be inferred
        /* THE DATA TYPE CANNOT BE INFERRED HERE, SINCE "T" DOES NOT EXIST, NEITHER AS A PARAMETER NOR AS A DECLARATION.*/
        Consumer printer = new Consumer<Integer>() {
            /*It can be inferred as long as the data type is specified in the declaration, e.g.
            Consumer<Integer(<T>) > printer = new Consumer(){};
            */
            @Override
            public void accept(Integer value) {
                System.out.println("value = " + value);
            }
        };
//        List<Integer> shown = SuperFunctions.act(transformed, printer);

        // 4b. Show each square on the screen and return nothing
//        SuperFunctions.act(transformed, new Printer());
        SuperFunctions.consume(transformed, printer);

        // 5. Obtain the sum of the squares
        // Identity for addition is 0, 1 for multiplication
        // int total = SuperFunctions.reduce(transformed, 0, new Adder());
        // CAN BE INFERRED FROM THE DATA TYPE OF T
        int total = SuperFunctions.reduce(transformed/*<T>*/, 0, new BinaryOperator<>() {
            @Override
            public Integer apply(Integer value1, Integer value2) {
                return value1 + value2;
            }
        });
        System.out.println("total = " + total);
    }
}