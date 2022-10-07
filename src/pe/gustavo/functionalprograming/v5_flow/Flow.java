package pe.gustavo.functionalprograming.v5_flow;

import pe.gustavo.functionalprograming.v5_flow.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Flow<T> {
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

    private final List<T> values;

    public Flow(List<T> values) {
        this.values = values;
    }

    public static <T> Flow<T> supplier(int size, Supplier<T> supplier) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(supplier.get());
        }
        return new Flow<>(result);
    }

    public Flow<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T value : values) {
            // the advantage of this code is that it is totally generic, since the ".test" could evaluate anything at runtime (it is conditioned on the Predicate interface).
            if (predicate.test(value)) {
                result.add(value);
            }
        }
        return new Flow<>(result);
    }

    public <R> Flow<R> transform(Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T value : values) {
            result.add(function.apply(value));
        }
        return new Flow<>(result);
    }

    public Flow<T> act(Consumer<T> consumer) {
        for (T value : values) {
            consumer.accept(value);
        }
        return new Flow<>(values);
    }

    // Terminal Operation, as it will not be possible to hook up with other calls (does not return a flow)
    public void consume(Consumer<T> consumer) {
        for (T value : values) {
            consumer.accept(value);
        }
    }

    // Terminal Operation, does not return a flow
    public T reduce(T identity, BinaryOperator<T> binaryFunction) {
        T total = identity;
        for (T value : values) {
            total = binaryFunction.apply(total, value);
        }
        return total;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
