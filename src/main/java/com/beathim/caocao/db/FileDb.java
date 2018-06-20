package com.beathim.caocao.db;

import java.io.*;

public class FileDb {

    private static final String FILENAME = "dkmm.txt";
    private static Writer out;

    public static void init(){
        try {
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILENAME), "UTF-8"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void close(){
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void writeLine(String s){
        try {
            out.write(s);
            out.write("\r\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
