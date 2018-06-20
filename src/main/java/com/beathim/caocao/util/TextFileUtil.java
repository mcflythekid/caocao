package com.beathim.caocao.util;

import com.jcraft.jsch.IO;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class TextFileUtil {
    public static String readFromClassPath(String fileName){
        try {
            ClassLoader classLoader = TextFileUtil.class.getClassLoader();
            return IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (Exception e){
            return null;
        }
    }
    public static List<String> readLineByLineFromClassPath(String fileName) {
        ClassLoader classLoader = TextFileUtil.class.getClassLoader();
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(fileName)))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                data.add(currentLine);
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
