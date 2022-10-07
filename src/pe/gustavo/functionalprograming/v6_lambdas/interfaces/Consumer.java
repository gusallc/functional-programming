package pe.gustavo.functionalprograming.v6_lambdas.interfaces;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T value);
}
