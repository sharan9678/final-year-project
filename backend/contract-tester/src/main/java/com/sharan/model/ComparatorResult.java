package com.sharan.model;

public class ComparatorResult {

    private String contract1;
    private String contract2;
    private boolean isCompatible;
    private String result;

    public ComparatorResult() {
    }

    public ComparatorResult(String contract1, String contract2, boolean isCompatible, String result) {
        this.contract1 = contract1;
        this.contract2 = contract2;
        this.isCompatible = isCompatible;
        this.result = result;
    }

    public String getContract1() {
        return contract1;
    }

    public void setContract1(String contract1) {
        this.contract1 = contract1;
    }

    public String getContract2() {
        return contract2;
    }

    public void setContract2(String contract2) {
        this.contract2 = contract2;
    }

    public boolean isCompatible() {
        return isCompatible;
    }

    public void setCompatible(boolean compatible) {
        isCompatible = compatible;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
