package com.beathim.caocao.dump;

import com.beathim.caocao.db.FileDb;
import com.beathim.caocao.dump.packorder.Pack;
import com.beathim.caocao.util.TextFileUtil;

import java.util.List;

public class Launch {



    public static void main(String[] args) throws Exception {
        FileDb.init();
        /*
        SET SERVEROUTPUT ON;
        exec MCFLY_CLONE_SO(100);
         */

        List<String> idList = TextFileUtil.readLineByLineFromClassPath("packinut.txt");
        for (String id: idList) {
            Pack pack = new Pack(id);
            FileDb.writeLine(pack.getSql());
        }

        FileDb.close();
    }
}
