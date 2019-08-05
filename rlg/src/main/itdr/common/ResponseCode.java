package main.itdr.common;

public class ResponseCode<T> {
    //状态码
    private Integer status;
    //数据
    private T date;
    //返回的错误信息
    private String mag;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    //成功的时候返回状态码和成功获取的数据
    //失败的时候返回状态码和失败的信息


    @Override
    public String toString() {
        return "ResponseCode{" +
                "status=" + status +
                ", date=" + date +
                ", mag='" + mag + '\'' +
                '}';
    }
}
