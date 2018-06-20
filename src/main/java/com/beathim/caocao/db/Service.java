package com.beathim.caocao.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Service {

    private static Service INSTANCE;
    private ApplicationContext context;
    private DataRepo dataRepo;

    private Service(){
        context = new AnnotationConfigApplicationContext(Config.class);
        dataRepo = context.getBean(DataRepo.class);
    }

    public DataRepo getRepo(){
        return dataRepo;
    }

    public static Service instance(){
        if (INSTANCE == null){
            INSTANCE = new Service();
        }
        return INSTANCE;
    }

    public static DataRepo repo(){
        return instance().getRepo();
    }
}
