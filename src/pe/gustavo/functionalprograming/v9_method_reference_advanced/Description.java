package pe.gustavo.functionalprograming.v9_method_reference_advanced;

public class Description {

    private final Integer value;

    public Integer getValue() {
        return value;
    }

    public Description(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}