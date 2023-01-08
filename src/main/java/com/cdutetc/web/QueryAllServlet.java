package com.cdutetc.web;

import com.alibaba.fastjson.JSON;
import com.cdutetc.utils.Redis;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/queryAllServlet")
public class QueryAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Redis redis = new Redis();
        ArrayList arrayList = redis.QueryAll();

        String data = JSON.toJSONString(arrayList);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(data);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
