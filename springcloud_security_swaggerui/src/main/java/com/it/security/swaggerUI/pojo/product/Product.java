package com.it.security.swaggerUI.pojo.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity//表示当前类是一个实体类
@Table(name = "product")//对应数据库表的名称
public class Product {

    //商品主键id
    @Id
    @Column
    private Integer id;
    //商品名称
    @Column
    private String name;
    //商品类型
    @Column
    private String type;
    //商品颜色
    @Column
    private String colour;
    //商品创建时间
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
