package com.boot_demo1.keys;

import java.io.Serializable;

public class ProductKey implements Serializable {

    private Long number;
    private Long code;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
