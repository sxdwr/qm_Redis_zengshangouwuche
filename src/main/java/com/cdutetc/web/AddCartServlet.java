package com.cdutetc.web;

import com.cdutetc.pojo.Brand;
import com.cdutetc.utils.Redis;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String imageURL = request.getParameter("imageURL");
        String title = request.getParameter("title");
        String oPrice = request.getParameter("oPrice");
        String disPrice = request.getParameter("disPrice");
        String amount = request.getParameter("amount");
        Redis redis = new Redis();
        Brand brand = new Brand();
        brand.setID(Integer.valueOf(id));
        brand.setImageURL(imageURL);
        brand.setoPrice(Double.valueOf(oPrice));
        brand.setTitle(title);
        brand.setDisPrice(Double.valueOf(disPrice));
        brand.setAmount(Integer.valueOf(amount));
//        System.out.println(brand);
        redis.Insert(brand);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
