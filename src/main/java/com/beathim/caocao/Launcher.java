package com.beathim.caocao;

import com.beathim.caocao.db.Data;
import com.beathim.caocao.db.FileDb;
import com.beathim.caocao.db.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {

    private Integer poolSize;

    public void start(){
        FileDb.init();
        System.out.println("Start...");
        ExecutorService service = Executors.newFixedThreadPool(poolSize);
        List<Data> dataList = Service.repo().findAllByStatusLessThan(0);

        Collections.sort(dataList, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.getExternalId().compareTo(o2.getExternalId());
            }
        });

        for(Data data : dataList){
            service.execute(new Spider(data));
        }
        service.shutdown();
        while (!service.isTerminated()) {
        }
        System.out.println("Finish...");
        FileDb.close();
    }

    public Launcher( Integer poolSize) {
        this.poolSize = poolSize;
    }
}
