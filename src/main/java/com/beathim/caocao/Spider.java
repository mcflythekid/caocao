package com.beathim.caocao;

import com.beathim.caocao.db.Data;
import com.beathim.caocao.db.FileDb;
import com.beathim.caocao.db.Service;
import com.beathim.caocao.map.Map1;
import com.beathim.caocao.map.Map2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Spider implements Runnable {

    protected Data data;

    public Spider(Data data) {
        this.data = data;
    }

//    @Override
//    public void run() {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String x = restTemplate.getForObject(data.getExternalId(), String.class);
//            data.setData(x);
//            data.setStatus(0);
//            Service.repo().save(data);
//        } catch (Exception e){
//            data.setStatus(1);
//            Service.repo().save(data);
//        }
//    }





    @Override
    public void run() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map1 map1 = objectMapper.readValue(data.getData(), Map1.class);
            List<Map2> map2List = map1.getData();

            if (!data.getS01().equals("77121")) return;

//            Collections.sort(map2List, new Comparator<Map2>() {
//                @Override
//                public int compare(Map2 o1, Map2 o2) {
//                    return 0;
//                }
//            });

            for (Map2 map2 : map2List){
                String format = "%s\t%s\t%s\t%s\t%s";
                String x = String.format(format, map2.getUserName(), map2.getDbUserName(), map2.getProductRating(),
                        map2.getUserImage(), map2.getComment());
                FileDb.writeLine(x);
            }
            //data.setStatus(0);
            //Service.repo().save(data);
        } catch (Exception e){
            //data.setStatus(1);
            //Service.repo().save(data);
        }
    }
}
