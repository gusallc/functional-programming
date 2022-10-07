package pe.gustavo.functionalprograming.v2_superfunctions_classes.classes;

import pe.gustavo.functionalprograming.v2_superfunctions_classes.interfaces.Consumer;

public class Printer implements Consumer {
    @Override
    public void accept(Integer value) {
        System.out.println("Printer value = " + value);
    }
}
