package pe.gustavo.functionalprograming.v2_superfunctions_classes;

import pe.gustavo.functionalprograming.v2_superfunctions_classes.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class SuperFunctions {
    /*
         Note : In Java 7(and earlier) functional programming did not exist.
         Java before version 8 can simulate this to a certain extent with anonymous classes, but it doesn't technically have first-class functions.
         x = createList() -> a function could not be stored in a variable.

         A language that considers procedures to be "first-class" allows functions to be passed around just like any other value.
         in other words, means you can pass function anywhere as if it's a variable.

            Example in
            JavaScript:

            function makeAdder(addend) {
                return function(x) {
                    return addend + x;
                }
                ;
            }
     */

    public static List<Integer> filter(List<Integer> values, Predicate predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer value : values) {
            // the advantage of this code is that it is totally generic, since the ".test" could evaluate anything at runtime (it is conditioned on the Predicate interface).
            if (predicate.test(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public static List<Integer> supplier(int size, Supplier supplier) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(supplier.get());
        }
        return result;
    }

    public static List<Integer> transform(List<Integer> values, Function function) {
        List<Integer> result = new ArrayList<>();
        for (Integer value : values) {
            result.add(function.apply(value));
        }
        return result;
    }

    public static List<Integer> act(List<Integer> values, Consumer consumer) {
        for (Integer value : values) {
            consumer.accept(value);
        }
        return values;
    }

    public static void consume(List<Integer> values, Consumer consumer) {
        for (Integer value : values) {
            consumer.accept(value);
        }
    }

    public static Integer reduce(List<Integer> values, Integer identity, BinaryFunction binaryFunction) {
        int total = identity;
        for (Integer value : values) {
            total = binaryFunction.apply(total, value);
        }
        return total;
    }

}
