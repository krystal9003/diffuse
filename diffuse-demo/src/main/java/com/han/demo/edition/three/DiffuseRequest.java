package com.han.demo.edition.three;

import java.io.Serializable;

public class DiffuseRequest<T> implements Serializable {

    private String code;

    private T t;

    public void setCode(String code) {
        this.code = code;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getCode() {
        return code;
    }

    public T getT() {
        return t;
    }

    @Override
    public String toString() {
        return "DiffuseRequest{" +
                "code='" + code + '\'' +
                ", t=" + t +
                '}';
    }
}
