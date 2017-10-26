/**
 * 
 */
package com.lgf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author first
 *
 */
public class ServletTest extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -8592718481025053480L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String[] interest = new String[]{};
        interest = request.getParameterValues("interest");
        String level = request.getParameter("level");
        String comment = request.getParameter("comment");
        PrintWriter pw= response.getWriter();
        System.out.println(name);
        pw.write("<!doctype html>");
        pw.write("<html>");
        pw.write("<head></head>");
        pw.write("<body>");
        pw.write("<h1>"+name+"</h1>");
        pw.write("<h1>"+gender+"</h1>");
        pw.write("<h1>"+Arrays.toString(interest)+"</h1>");
        pw.write("<h1>"+level+"</h1>");
        pw.write("<h1>"+comment+"</h1>");
        pw.write("</body>");
        pw.write("</html>");
        pw.flush();
        pw.close();

        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
