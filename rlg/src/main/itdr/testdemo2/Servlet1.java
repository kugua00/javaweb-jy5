package main.itdr.testdemo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet1" ,value = "/manage/user/")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestURI();    // 获取页面value值
        request.getPathInfo();      //直接获得最后的页面地址
        request.getRequestURL();    //获取页面完全地址
   //     request.getHeader();      //获取头  要传入对应的值
        request.getServletPath(); //获取Servlet的value
        request.getRequestedSessionId();   //获取SessionId
        request.getRemoteUser();
        request.getQueryString();
        request.getPathTranslated();  //获取在servlet在java的完全路径

        request.getAuthType();
        request.getMethod();           //获取方法名称  get   post
        request.getContextPath();
    //    request.setCharacterEncoding();    //设置编码集
     //   request.getSession();   // 获取Session
     //   request.setAttribute(, );  //设置域对象的值
     //   request.getParameter()范围的意思   //获取参数

    }
}
