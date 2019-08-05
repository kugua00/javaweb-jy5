package main.itdr.pojo;

public class Users {
    //用户id
    private Integer id;
    //用户账号
    private String  uname;
    //用户密码
    private String psd;
    //用户电话
    private String tel;
    //用户身份
    private Integer type = 0;
    //是否被禁用
    private Integer stats = 0;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", psd='" + psd + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                ", stats=" + stats +
                '}';
    }
}
