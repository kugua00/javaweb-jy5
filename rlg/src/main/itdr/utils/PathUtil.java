package main.itdr.utils;

public class PathUtil {

    /**
     * 截取地址字符串
     * @param path
     * @return
     */

    public static String getPath(String path){
        //将字符串中的“.”转换为“/”     replace 代替  替换
        String s1 = path.replace(".","/");

        //以“/”分割返回一个字符串数组
        String[] split = s1.split("/");


        return split[1];

    }
}
