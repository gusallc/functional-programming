package pe.gustavo.functionalprograming.v2_superfunctions_classes.classes;

import pe.gustavo.functionalprograming.v2_superfunctions_classes.interfaces.BinaryFunction;

public class Adder implements BinaryFunction {
    @Override
    public Integer apply(Integer value1, Integer value2) {
        return value1 + value2;
    }
}
