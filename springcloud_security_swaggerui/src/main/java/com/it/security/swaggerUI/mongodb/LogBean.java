package com.it.security.swaggerUI.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Document(collection = "mongodbLog")
@Data
public class LogBean {
    //主键id
    @Id
    private String id;
    //被掉方法所属类名
    private String className;
    //被调用的方法名
    private String methodName;
    //被调方法的请求报文
    private String requestBody;
    //被调方法的响应报文
    private String responseBody;
    //调用时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    //被调用方法的请求路径
    private String url;
    //请求类型（GET、POST。。）
    private String requestType;
}
