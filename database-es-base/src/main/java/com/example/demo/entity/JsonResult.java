package com.example.demo.entity;

import java.util.Objects;

public class JsonResult<T> {
    String scrollId;
    Boolean success;
    T msg;
    public JsonResult(){}
    public JsonResult(boolean b, T message) {
        this.success = b;
        this.msg = message;
    }

    public JsonResult(String scrollId, boolean b, T message) {
        this.scrollId = scrollId;
        this.success = b;
        this.msg = message;
    }

    public JsonResult(boolean b) {
        this.success = b;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JsonResult that = (JsonResult) o;
        return Objects.equals(success, that.success) && Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, msg);
    }

    public String getScrollId() {
        return scrollId;
    }

    public void setScrollId(String scrollId) {
        this.scrollId = scrollId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
