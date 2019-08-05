package com.itdr.testdemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

public class DemoTest1 {

   @Test
    public void test1() throws Exception {


       ComboPooledDataSource co = new ComboPooledDataSource();


       Connection connection = co.getConnection();


       String s = "select * from users";

       PreparedStatement preparedStatement = connection.prepareStatement(s);

       ResultSet resultSet = preparedStatement.executeQuery();

       while (resultSet.next()){
           System.out.println(resultSet.getString(2));
       }
   }

   @Test
   public void test2(){
      String s = "/list.do";

      //将字符串中的“.”转换为“/”
      String s1 = s.replace(".","/");

      //以“/”分割返回一个字符串数组
      String[] split = s1.split("/");
      System.out.println(split[1]);
   }

}
