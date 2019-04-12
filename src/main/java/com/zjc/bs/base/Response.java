package com.zjc.bs.base;

import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private String code;
    private String msg;
    private T result;

    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> success(T data) {
        val response = new Response<T>();
        response.setMsg("success");
        response.setCode("200");
        response.setResult(data);
        return response;
    }

    public static <T> Response<T> success(T data,String msg) {
        val response = new Response<T>();
        response.setMsg(msg);
        response.setCode("200");
        response.setResult(data);
        return response;
    }


    public static <T> Response<T> failure(String msg) {
        val response = new Response<T>();
        response.setMsg(msg);
        response.setCode("555");
        response.setResult(null);
        return response;
    }

    public static <T> Response<T> failure(T data) {
        val response = new Response<T>();
        response.setMsg("发生错误");
        response.setCode("500");
        response.setResult(data);
        return response;
    }

    public static <T> Response<T> failure(String msg,T data) {
        val response = new Response<T>();
        response.setMsg(msg);
        response.setCode("555");
        response.setResult(data);
        return response;
    }

    public boolean isSuccess() {
        return "200".equals(this.getCode());
    }

}