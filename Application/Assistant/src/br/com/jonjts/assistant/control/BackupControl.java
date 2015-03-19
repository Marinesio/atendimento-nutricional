/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class BackupControl {

    public final String pathMysql = "\"C:\\Program Files\\MySQL\\MySQL Server 5.6";

    public void doBackup(String mySqlPath, String passworld, String destiny) throws IOException {
        Runtime bck = Runtime.getRuntime();
        mySqlPath += "\\bin\\mysqldump.exe\"";
        destiny += "/backup.ast";

        StringBuilder builder = new StringBuilder();
        builder.append(mySqlPath);
        builder.append(" -v -v -v --host=localhost --user=root ");
        builder.append("--password=").append(passworld);
        builder.append(" --port=3306 --protocol=tcp --force --allow-keywords ");
        builder.append("--compress  --add-drop-table --default-character-set=utf8 --hex-blob ");
        builder.append("--result-file=").append(destiny);
        builder.append(" --databases assistant");
        bck.exec(builder.toString());
    }
}
