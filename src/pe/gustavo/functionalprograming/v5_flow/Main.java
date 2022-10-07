package pe.gustavo.functionalprograming.v5_flow;

import pe.gustavo.functionalprograming.v5_flow.interfaces.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //      ¿We want to do? - CHAIN CALLS
        // supplier().filter().transform().print().additional().act().reduce();

        int totalChained =
                // First method
//                Flow.supplier(10, new Supplier<Integer>() {
//            final java.util.Random random = new java.util.Random();
//
//            @Override
//            public Integer get() {
//                return random.nextInt(10);
//            }
//        }).filter........

                // Second method
                new Flow<>(List.of(1, 2, 3, 4, 5, 6, 7, 8))

                        .filter(new Predicate<>() {
                            @Override
                            public Boolean test(Integer value) {
                                return value % 2 == 0;
                            }
                        }).transform(new UnaryOperator<>() {
                            @Override
                            public Integer apply(Integer value) {
                                return value * value;
                            }
                        }).act(new Consumer<Integer>() {
                                   @Override
                                   public void accept(Integer value) {
                                       System.out.println("value = " + value);
                                   }
                               }

                        ).reduce(0, new BinaryOperator<>() {
                            @Override
                            public Integer apply(Integer value1, Integer value2) {
                                return value1 + value2;
                            }
                        });

        System.out.println("totalChained = " + totalChained);


//        First Mehtod

//        // 1. Create list of integers
//        /* It is not necessary to explicitly indicate tha data type of the argument ""Supplier<Integer>() "" ,
//         since it can be inferred from List<Integer>(<T>) - (of the data type where the response will be stored) */
//        Flow<Integer>/*<T>*/ numbers = Flow.supplier(10, new Supplier<>() {
//            final java.util.Random random = new java.util.Random();
//
//            @Override
//            public Integer get() {
//                return random.nextInt(10);
//            }
//        });
////        List<Integer> numbers = SuperFunctions.supplier(10, new NaturalNumbers());
//        System.out.println("numbers = " + numbers);
//
//        // 2. Keep only the pairs
////        List<Integer> filtered = SuperFunctions.filter(numbers, new OnlyOdd());
//        Flow<Integer> filtered = numbers.filter(new Predicate<>() {
//            @Override
//            public Boolean test(Integer value) {
//                return value % 2 == 0;
//            }
//        });
//        System.out.println("filtered = " + filtered);
//
//        // 3a. Obtain the square of each number
////        List<Integer> transformed = SuperFunctions.transform(filtered, new Squaring());
//        // CAN BE INFERRED FROM THE DATA TYPE OF "T" and "R"
//        Flow<Integer>/*<R>*/ transformed = filtered/*<T>*/.transform(new UnaryOperator<>() {
//            @Override
//            public Integer apply(Integer value) {
//                return value * value;
//            }
//        });
//        System.out.println("transformed = " + transformed);
//        // 3b. Obtain the square of each number in String
//        Flow<String>/*<R>*/ transformedIntoString = transformed/*<T>*/.transform(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer value) {
//                return "List in String value: " + value;
//            }
//        });
//        System.out.println(transformedIntoString);
//
//        // 4a. Show each square on the screen and return list.
//        // here, the data type cannot be inferred
//        /* THE DATA TYPE CANNOT BE INFERRED HERE, SINCE "T" DOES NOT EXIST, NEITHER AS A PARAMETER NOR AS A DECLARATION.*/
//        Consumer printer = new Consumer<Integer>() {
//            /*It can be inferred as long as the data type is specified in the declaration, e.g.
//            Consumer<Integer(<T>) > printer = new Consumer(){};
//            */
//            @Override
//            public void accept(Integer value) {
//                System.out.println("value = " + value);
//            }
//        };
//        Flow<Integer> shown = transformed.act(printer);
//
//        // 4b. Show each square on the screen and return nothing
////        SuperFunctions.act(transformed, new Printer());
//        transformed/*<T>*/.consume(printer);
//
//        // 5. Obtain the sum of the squares
//        // Identity for addition is 0, 1 for multiplication
//        // int total = SuperFunctions.reduce(transformed, 0, new Adder());
//        // CAN BE INFERRED FROM THE DATA TYPE OF T
//        int total = shown/*<T>*/.reduce(0, new BinaryOperator<>() {
//            @Override
//            public Integer apply(Integer value1, Integer value2) {
//                return value1 + value2;
//            }
//        });
//        System.out.println("total = " + total);
//    }
    }
}