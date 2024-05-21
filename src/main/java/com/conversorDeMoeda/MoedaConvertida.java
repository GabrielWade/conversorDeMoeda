package com.conversorDeMoeda;

public class MoedaConvertida {
    private String target_code;
    private double conversion_result;

    public MoedaConvertida() {
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return "MoedaConvertida= " +
                target_code +
                ", Valor= " + conversion_result
                ;
    }
}
