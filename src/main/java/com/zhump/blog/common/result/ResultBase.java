package com.zhump.blog.common.result;

import lombok.Data;


public class ResultBase {

    private String code;

    private String mes;

    private Object data;

    public ResultBase(String code, String mes, Object data) {
        this.code = code;
        this.mes = mes;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
