package main.itdr.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import main.itdr.pojo.Users;
import main.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

public class UserDao {

    /**
     * 查找所有用户
     * @param pageSize
     * @param pageNum
     * @return
     */
    public List<Users> selectAll(String pageSize, String pageNum) {
 /*       //创建连接池
        ComboPooledDataSource co = PoolUtil.getCo();

  */
        //使用db_Utils创建核心类
        QueryRunner qr = new QueryRunner(PoolUtil.getCo());
        //创建查询语句(分页 页码，数量)
        String sql = "select * from users limit ?,?";

        List<Users> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Users>(Users.class),pageNum,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }



    /**
     * 根据用户名和密码 查询用户
     * @param username
     * @param password
     * @return
     */
    public Users selectOne(String username, String password) {
 /*       //创建连接池
        ComboPooledDataSource co = PoolUtil.getCo();

  */
        //使用db_Utils创建核心类
        QueryRunner qr = new QueryRunner(PoolUtil.getCo());
        //创建查询语句(分页 页码，数量)
        String sql = "select * from users where uname =? and psd = ?";

        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }



    /**
     * 根据ID 查找一个用户
     * @param uid
     * @return
     */
    public Users selectOne(Integer uid ) {
        //使用db_Utils创建核心类
        QueryRunner qr = new QueryRunner(PoolUtil.getCo());
        //创建查询语句(分页 页码，数量)
        String sql = "select * from users where uid =?";

        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }



    /**
     * 根据ID 禁用一个用户
     * @param uid
     * @return
     */
    public int updateByUid(Integer uid ) {
        //使用db_Utils创建核心类
        QueryRunner qr = new QueryRunner(PoolUtil.getCo());
        //创建查询语句(分页 页码，数量)
        String sql = "update users set stats = 1 where id = ？";

        int row = 0;
        try {
            row = qr.update(sql,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return row;
    }
}
