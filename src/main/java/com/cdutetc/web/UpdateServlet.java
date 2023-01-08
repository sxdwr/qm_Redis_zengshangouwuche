package com.cdutetc.web;

import com.cdutetc.pojo.Brand;
import com.cdutetc.utils.Redis;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String amount = request.getParameter("amount");
        Redis redis = new Redis();
        Brand brand = new Brand();

        brand.setID(Integer.valueOf(id));
        brand.setAmount(Integer.valueOf(amount));

        redis.Update(brand);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
