package pe.gustavo.functionalprograming.v2_superfunctions_classes.classes;

import pe.gustavo.functionalprograming.v2_superfunctions_classes.interfaces.Predicate;

public class OnlyOdd implements Predicate {

    @Override
    public Boolean test(Integer value) {
        return value % 2 != 0;
    }
}
