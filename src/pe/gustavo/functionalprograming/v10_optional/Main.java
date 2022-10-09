package pe.gustavo.functionalprograming.v10_optional;

import java.util.Comparator;

// NOTE: THE USE OF METHOD REFERENCES IS RECOMMENDED WHENEVER POSSIBLE.
//       AlSO, THE ORDER OF PARAMETERS WILL BE RESPECTED
//   (value1, value2) -> Integer.sum(value1, value2)
//   Integer::sum
public class Main {

    //Another aspect to keep in mind is that a lambda expression can access the "final" variables and
    //"static" variables defined in the scope in which the lambda expression is used.
    static final java.util.Random random = new java.util.Random(); // First Method

    public static void main(String[] args) {
        Main main = new Main();

        Flow.supplier(10,
                main::randomInt // specified instance
        ).filter(
                Numberutils::isPrime // represents the static method
        ).sort(
                Integer::compareTo
        ).transform(
                Numberutils::squaring // represents the static method
        ).transform(
                Description::new
        ).act(
                System.out::println // Reference by variable
        ).transform(
                Description::getValue
        ).max(Comparator.naturalOrder())
                // never use .get()
                // other common methods is .orElse(), .orElseGet() .isPresent(), .orElseThrow()
                .ifPresentOrElse(
                value -> System.out.println("El máximo es:" + value),
                () -> System.out.println("No hay máximo"));

    }

    private int randomInt() {
        return random.nextInt(10);
    }

}