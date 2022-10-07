package pe.gustavo.functionalprograming.v6_lambdas;

// Lambdas - Java 8+
public class Main {

    //Another aspect to keep in mind is that a lambda expression can access the "final" variables and
    //"static" variables defined in the scope in which the lambda expression is used.
    static final java.util.Random random = new java.util.Random(); // First Method

    public static void main(String[] args) {
        final java.util.Random random2 = new java.util.Random(); // Second Method

        //      ¿We want to do? - CHAIN CALLS
        // supplier().filter().transform().print().additional().act().reduce();

//        // 1. Create list of integers
        int totalChained =
                // First method
                Flow.supplier(10,
                        /*new Supplier<Integer>() {
                                    final java.util.Random random = new java.util.Random();

                                    @Override
                                    public Integer get() {
                                        return random.nextInt(10);
                                    }
                                }*/
                                //"random" use of the Scope of a lambda expression
                                () -> random.nextInt(10)
                        )
                        // Second method
//                new Flow<>(List.of(1, 2, 3, 4, 5, 6, 7, 8))

                        // 2. Keep only the pairs
                        .filter(
                               /* new Predicate<>() {
                            @Override
                            public Boolean test(Integer value) {
                                return value % 2 == 0;
                            }
                        } */
                                value -> value % 2 == 0
                        )
                        // 3. Obtain the square of each number
                        .transform(
                               /* new UnaryOperator<>() {
                            @Override
                            public Integer apply(Integer value) {
                                return value * value;
                            }}*/
                                value -> value * value
                        )
                        // 4. Show each square on the screen and return list.
                        .act(
                               /* new Consumer<Integer>() {
                                 @Override
                                 public void accept(Integer value) {
                                     System.out.println("value = " + value);
                                 }
                             }*/
                                value -> System.out.println("value = " + value)

                        )
                        // 5. Obtain the sum of the squares
                        .reduce(0,
                                /*new BinaryOperator<>() {
                            @Override
                            public Integer apply(Integer value1, Integer value2) {
                                return value1 + value2;
                            }}*/
                                (value1, value2) -> value1 + value2
                        );

        System.out.println("totalChained = " + totalChained);
    }
}