package com.zhump.blog.common.result;

public class Result extends ResultBase {

    public Result(Status status, Object data) {
        super(status.getCode(),status.getMes(),data);
    }
}
