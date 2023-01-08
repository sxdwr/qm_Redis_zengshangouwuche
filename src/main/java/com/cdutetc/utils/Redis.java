package com.cdutetc.utils;

import com.cdutetc.pojo.Brand;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Redis {
    private Jedis redis;
    public Redis(){
        this.redis = new Jedis("localhost",6379);
    }

    public void Insert(Brand brand){
        String id = String.valueOf(brand.getID());
        redis.sadd("id",id);

        redis.hset(id,"imageURL",brand.getImageURL());
        redis.hset(id,"title", brand.getTitle());
        redis.hset(id,"oPrice", String.valueOf(brand.getoPrice()));
        redis.hset(id,"disPrice", String.valueOf(brand.getDisPrice()));
        redis.hset(id,"amount", String.valueOf(brand.getAmount()));
    }

    public Brand QueryById(Integer id){
        Map<String, String> mp = redis.hgetAll(String.valueOf(id));
        Brand brand = new Brand();
        brand.setID(id);
        brand.setImageURL(mp.get("imageURL"));
        brand.setTitle(mp.get("title"));
        brand.setoPrice(Double.valueOf(mp.get("oPrice")));
        brand.setDisPrice(Double.valueOf(mp.get("disPrice")));
        brand.setAmount(Integer.valueOf(mp.get("amount")));
        return brand;
    }
    public ArrayList QueryAll(){
        Set<String> ids = redis.smembers("id");
        ArrayList<Brand> brands = new ArrayList<>();
        for (String id : ids) {
            brands.add(this.QueryById(Integer.valueOf(id)));
        }
        return brands;
    }

    public void Delete(Integer id){
        redis.del(String.valueOf(id));
        redis.srem("id", String.valueOf(id));
    }
    public void Update(Brand brand){
        String id = String.valueOf(brand.getID());
//        redis.hset(id,"title", brand.getTitle());
//        redis.hset(id,"imageURL",brand.getImageURL());
//        redis.hset(id,"oPrice", String.valueOf(brand.getoPrice()));
//        redis.hset(id,"disPrice", String.valueOf(brand.getDisPrice()));
        redis.hset(id,"amount", String.valueOf(brand.getAmount()));
    }
}
