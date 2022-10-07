package pe.gustavo.functionalprograming.v6_lambdas.interfaces;

@FunctionalInterface
public interface Predicate<T> {

    Boolean test(T value);
}
