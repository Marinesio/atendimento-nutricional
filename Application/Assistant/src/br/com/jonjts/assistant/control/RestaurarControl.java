/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jonas
 */
public class RestaurarControl {

    public final String pathMysql = "\"C:\\Program Files\\MySQL\\MySQL Server 5.6";

    public void doRestore(String mySqlPath, String passworld, String destiny) throws IOException {
        mySqlPath += "\\bin\\mysql.exe\"";

        StringBuilder builder = new StringBuilder();
        builder.append(mySqlPath);
        builder.append(" -v -v -v --host=localhost --user=root ");
        builder.append("--password=").append(passworld);
        builder.append(" --port=3306 --protocol=tcp --force");
        builder.append(" assistant < ").append(destiny);

        File f = new File("restore.bat");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(builder.toString().getBytes());
        fos.close();
        Process run = Runtime.getRuntime().exec("cmd /C start restore.bat ");

    }
}
