package com.it.springcloud.eurekaClient.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Product implements Serializable {
    //商品主键id
    private Integer id;
    private String name;
    //商品类型
    private String type;
    //商品颜色
    private String colour;
    //商品创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Product() {
    }
}
