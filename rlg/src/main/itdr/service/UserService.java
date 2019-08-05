package main.itdr.service;

import main.itdr.common.Const;
import main.itdr.common.ResponseCode;
import main.itdr.dao.UserDao;
import main.itdr.pojo.Users;

import java.util.List;

public class UserService {
    //调用数据层
    private UserDao ud = new UserDao();

    public ResponseCode selectAll(String pageSize, String pageNum) {
       //做非空判断  为null或者为空字符串都没有意义
        if (pageSize == null && pageSize.equals("")){
            pageSize = "10";
        }
        if (pageNum == null && pageNum.equals("")){
            pageNum = "1";
        }



        //查询
        List<Users> li = ud.selectAll(pageSize,pageNum);

        //如果集合元素是空呢？
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setDate(li);
        return rs;
    }

    /**
     * 用户登录
     * @param pageName
     * @param pagePassword
     * @return
     */
    public ResponseCode selectOne(String pageName, String pagePassword) {

        ResponseCode rs = new ResponseCode();


        //做非空判断 为null或者为空字符串都没有意义
        if (pageName == null || pageName.equals("")||pagePassword == null || pagePassword.equals("")){
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }

        //查找是否有这样一个用户
        Users u = ud.selectOne(pageName,pagePassword);

        //判断用户是否存在
        if (u ==null){
            rs.setStatus(1);
            rs.setMag("账号或者密码错误");
            return rs;
        }

        //判断用户权限
        if (u.getType()!= 1){
            rs.setStatus(2);
            rs.setMag("没有操作权限");
            return rs;
        }

        //登录成功
        rs.setStatus(0);
        rs.setDate(u);

        return rs;
    }


    /**
     * 用户禁用
     * @param uids
     * @return
     */
    public ResponseCode selectOne(String uids) {

        ResponseCode rs = new ResponseCode();


        //做非空判断 为null或者为空字符串都没有意义
        if (uids == null || uids.equals("")){
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }

        //字符串转数值
        Integer uid = null;

        //避免字符串是字母  不能转换int类型 所以手动处理
        try {
            uid = Integer.parseInt(uids);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }


        //查找是否有这样一个用户
        Users u = ud.selectOne(uid);




        //判断用户是否存在
        if (u == null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }

        //判断用户禁用情况
        if (u.getType() == 1){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;
        }

        //禁用用户
        int row = ud.updateByUid(uid);


        //判断用户禁用成功失败
        if (row <= 0){
            rs.setStatus(106);
            rs.setMag("禁用失败");
            return rs;
        }

        rs.setStatus(0);
        rs.setDate(row);

        return rs;
    }
}
