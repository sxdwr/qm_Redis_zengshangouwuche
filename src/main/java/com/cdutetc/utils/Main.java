package com.cdutetc.utils;

import com.cdutetc.pojo.Brand;

public class Main {
    public static void main(String[] args) {
        Redis redis = new Redis();
        Brand brand = new Brand();
        brand.setID(1);
        brand.setImageURL("./images/5.jpg");
        brand.setTitle("礼物价格Mistine小黄帽防晒乳SPF50泰版面部冬季学生隔离男女适用");
        brand.setoPrice(87.00);
        brand.setDisPrice(65.00);
        brand.setAmount(1);
        redis.Insert(brand);

        brand.setID(2);
        brand.setImageURL("./images/4.jpg");
        brand.setTitle("国行罗技g102二代游戏鼠标有线rgb背光lol吃鸡专用luoj电竞宏编程");
        brand.setoPrice(107.00);
        brand.setDisPrice(95.00);
        brand.setAmount(1);
        redis.Insert(brand);

        brand.setID(3);
        brand.setImageURL("./images/3.jpg");
        brand.setTitle("味乐士泡椒柠檬香酸辣无骨鸭爪去骨筋鸭掌筋鸭肉熟食开袋即食零食");
        brand.setoPrice(37.00);
        brand.setDisPrice(25.00);
        brand.setAmount(1);
        redis.Insert(brand);

        brand.setID(4);
        brand.setImageURL("./images/2.jpg");
        brand.setTitle("德食风干烤脖30根即食手撕黑鸭香辣糖醋味鸡脖非鸭脖子一整根零食");
        brand.setoPrice(36.00);
        brand.setDisPrice(31.00);
        brand.setAmount(1);
        redis.Insert(brand);

        System.out.println(redis.QueryAll());
    }
}
