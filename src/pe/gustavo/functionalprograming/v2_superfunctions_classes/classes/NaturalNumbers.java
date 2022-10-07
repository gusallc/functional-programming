package pe.gustavo.functionalprograming.v2_superfunctions_classes.classes;

import pe.gustavo.functionalprograming.v2_superfunctions_classes.interfaces.Supplier;

public class NaturalNumbers implements Supplier {

    private static int next;

    @Override
    public Integer get() {
        return next++;
    }
}
