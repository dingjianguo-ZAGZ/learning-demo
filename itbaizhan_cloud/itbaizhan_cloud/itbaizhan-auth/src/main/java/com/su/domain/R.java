package com.su.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class R {
    private String code;
    private String message;
    private Object data;
    public static R fail(String message){
        R r = new R();
        r.setCode("500");
        r.setMessage(message);
        return r;
    }
    public static R ok(Object data){
        R r = new R();
        r.setCode("200");
        r.setMessage("success");
        r.setData(data);
        return r;
    }
}
