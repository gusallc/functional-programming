package pe.gustavo.functionalprograming.v6_lambdas.interfaces;

// function specialization
// unify the input and output value type
@FunctionalInterface
public interface BinaryOperator<T> extends BinaryFunction<T, T, T> {
}
