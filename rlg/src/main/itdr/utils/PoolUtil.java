package main.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolUtil {
    //创建连接池
    public static ComboPooledDataSource co = new ComboPooledDataSource();

    //获取连接池的方法
    public static ComboPooledDataSource getCo(){
        return co;
    }
}
