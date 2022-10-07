package pe.gustavo.functionalprograming.v2_superfunctions_classes.classes;

import pe.gustavo.functionalprograming.v2_superfunctions_classes.interfaces.Supplier;

public class Random implements Supplier {

    java.util.Random random = new java.util.Random();

    @Override
    public Integer get() {
        return random.nextInt(10);
    }
}
