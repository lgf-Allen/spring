package com.lgf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPlatform2
 */
@WebServlet("/ServletPlatform2")
public class ServletPlatform2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPlatform2() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        Map<String, String[]> map = request.getParameterMap();
//        for (String key : map.keySet()) {
//            System.out.println("name:"+key+"value:"+Arrays.toString(map.get(key)));
//        }
        PrintWriter pw= response.getWriter();
        pw.write("<!doctype html>");
        pw.write("<html>");
       
       
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if("admin".equals(userName) && "password".equals(password)){
            pw.write("<head></head>");
            pw.write("<body>");
            pw.write("<h1>"+userName+"登录成功</h1>");
          
        }else{
            pw.write("<head>");
            pw.write("<meta http-equiv='Refresh' content='5;url=404.html'>");
//            pw.write("<script>");
//            pw.write("window.location.href='404.html'");
//            pw.write("</script>");
            pw.write("</head>");
            pw.write("<body>");
            pw.write("<h1>登录失败</h1>");
        }
        pw.write("</body>");
        pw.write("</html>");
        pw.flush();
        pw.close();
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
