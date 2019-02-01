package com.zhump.blog.model.vo;

import com.zhump.blog.model.Resources;
import lombok.Data;

import java.util.List;

@Data
public class ResourcesVO extends Resources {

   private List<ResourcesVO> children;
}
