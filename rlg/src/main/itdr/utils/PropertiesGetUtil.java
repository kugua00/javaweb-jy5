package main.itdr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesGetUtil {

    public static String getValue(String key){

        //io流获取配置文件内容
        Properties ps = new Properties();
        InputStream in = PropertiesGetUtil.
                class.getClassLoader().getResourceAsStream("const.properties");

        try {
            ps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过键获取值
        String value = ps.getProperty(key);

        return value;
    }


}
