package pe.gustavo.functionalprograming.v6_lambdas.interfaces;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T value);
}
