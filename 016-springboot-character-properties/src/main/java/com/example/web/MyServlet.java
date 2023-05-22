package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //没指定utf-8，默认编码text/html;charset=ISO-8859-1，因此输出中文会乱码
        out.println("************=============");
        out.println("properties尝试输出中文");
        out.flush();
        out.close();
    }
}
