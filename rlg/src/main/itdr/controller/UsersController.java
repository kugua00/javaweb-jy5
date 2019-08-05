package main.itdr.controller;

import main.itdr.common.ResponseCode;
import main.itdr.pojo.Users;
import main.itdr.service.UserService;
import main.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage/user/*") //目录匹配               //list.do  登录
public class UsersController extends HttpServlet {

    //调用业务层处理业务
    private UserService uc = new UserService();




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 /*       //解决请求乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应乱码
        response.setContentType("text/html;charset=UTF-8");
*/


        //怎么获取请求路径信息
        // getPathInfo获取到路径
        String pathInfo = request.getPathInfo();
        //使用PathUtil的方法截取字符串
        String path = PathUtil.getPath(pathInfo);


        //创建同一返回对象
        ResponseCode rs = null;

        //判断一下是什么请求
        switch (path){
            case"list":
                rs = listDo(request);
                break;
            case"login":
                rs = loginDo(request);
                break;
            case "disableuser":
                rs = disableuserDo(request);
                break;
        }





 /*     //获取页条数（参数）
        String pageSize = request.getParameter("pageSize");
        //获取页码  （参数）
        String pageNum = request.getParameter("pageNum");


        //调用业务层处理业务
        UserService uc = new UserService();
        //获取所有的对象
        rs = uc.selectAll(pageSize,pageNum);

*/



 /*       //把user对象信息输出在页面
        for (int i =0;i<rs.getDate().size();i++){
            Users users = li.get(i);
            response.getWriter().write(li.toString() + "</br>");
        }
*/
        // 返回响应数据
        response.getWriter().write(rs.toString());

    }
    //禁用用户的请求
    private ResponseCode disableuserDo(HttpServletRequest request) {
        //获取参数
        String uid = request.getParameter("uid");


        //调用业务层处理业务
        ResponseCode rs = uc.selectOne(uid);

        return rs;


    }


    /**
     * 获取所有用户列表的请求
     * @return
     */
    private ResponseCode listDo(HttpServletRequest request){
        //new 一个ResponseCode对象
        ResponseCode rs = new ResponseCode();


        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        if (user == null){
            rs.setStatus(3);
            rs.setMag("请登录后操作");
            return rs;
        }
        if (user.getType() !=1){
            rs.setStatus(3);
            rs.setMag("没有操作权限！");
            return rs;
        }


        //获取页条数（参数）
        String pageSize = request.getParameter("pageSize");
        //获取页码  （参数）
        String pageNum = request.getParameter("pageNum");

        //获取所有的对象
        rs = uc.selectAll(pageSize,pageNum);


        //获取所有的对象
        return rs;

    }


    /**
     * 用户登录的请求
     */
    private ResponseCode loginDo(HttpServletRequest request){

        //获取账号（参数）
        String username = request.getParameter("username");
        //获取密码  （参数）
        String password = request.getParameter("password");


        //调用业务层处理业务
         ResponseCode rs = uc.selectOne(username,password);


        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("user",rs.getDate());


        return rs;


    }

}
