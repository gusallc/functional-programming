package pe.gustavo.functionalprograming.v2_superfunctions_classes.classes;

import pe.gustavo.functionalprograming.v2_superfunctions_classes.interfaces.Function;

public class Cube implements Function {
    @Override
    public Integer apply(Integer value) {
        return value * value * value;
    }
}
