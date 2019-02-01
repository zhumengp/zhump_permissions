package com.zhump.blog.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResultLevelVO implements Serializable {

    private Long parent_id;

    private String p_name;

    private List<SecLink> secLinks = new ArrayList<>();

    public static class SecLink {

        private Long c_id;

        private String c_name;

        public Long getC_id() {
            return c_id;
        }

        public void setC_id(Long c_id) {
            this.c_id = c_id;
        }

        public String getC_name() {
            return c_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }
    }

}
