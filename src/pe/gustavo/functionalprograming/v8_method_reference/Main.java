package pe.gustavo.functionalprograming.v8_method_reference;

// NOTE: THE USE OF METHOD REFERENCES IS RECOMMENDED WHENEVER POSSIBLE.
//       AlSO, THE ORDER OF PARAMETERS WILL BE RESPECTED
//   (value1, value2) -> Integer.sum(value1, value2)
//   Integer::sum
public class Main {

    //Another aspect to keep in mind is that a lambda expression can access the "final" variables and
    //"static" variables defined in the scope in which the lambda expression is used.
    static final java.util.Random random = new java.util.Random(); // First Method

    public void main(String[] args) {
        Main main = new Main();
        final java.util.Random random2 = new java.util.Random(); // Second Method

        //      ¿We want to do? - CHAIN CALLS
        // supplier().filter().transform().print().additional().act().reduce();

//        // 1. Create list of integers
        int totalChained =
                Flow.supplier(10,
                                //"random" use of the Scope of a lambda expression
//                                () -> main.randomInt()
                                this::randomInt // specified instance
//                        or main::randomInt
                        )
                        // 2. Keep only the prime
                        .filter(
//                                value -> isPrime(value)
//                                value -> Numberutils.isPrime(value)
                                Numberutils::isPrime // represents the static method
                        )
                        // 3. Obtain the square of each number
                        .transform(
                                // value -> squaring(value)
                                Numberutils::squaring // represents the static method
                        )
                        // 4. Show each square on the screen and return list.
                        .act(
//                                value -> System.out.println("value = " + value)
//                                out -> Object(PrintStream) declared inside the System class with variable name "out"
                                System.out::println // Reference by variable

                        )
                        // 5. Obtain the sum of the squares
                        .reduce(0,
//                                (value1, value2) -> Integer.sum(value1, value2)
                                Integer::sum //represents the static method
                        );

        System.out.println("totalChained = " + totalChained);
    }

    private int randomInt() {
        return random.nextInt(10);
    }

}