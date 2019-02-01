package com.zhump.blog.common.result;

public enum Status {

    SUCCESS("1","SUCCESS"),
    ERROR("0","ERROR"),
    params("404","invalid argument"),
    NAME_ERROR("100010","账号错误"),
    PASSWORD_ERROR("100011","密码错误");

    private String code;


    private String mes;

    Status(String code, String mes) {
        this.code = code;
        this.mes = mes;
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
}
