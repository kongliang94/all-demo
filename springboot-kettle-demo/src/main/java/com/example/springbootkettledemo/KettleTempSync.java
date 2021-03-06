package com.example.springbootkettledemo;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KettleController {


    @Scheduled(cron = "0 */1 * * * *")
    public void kettleSync() {
        String project_path = getFilePath();
        String filename = "kettle/tskv-test-sync.ktr";
        filename = project_path + filename;
        // 调用转换
        try {
            transfer(filename);
        } catch (KettleException e) {
            e.printStackTrace();
        }
    }

    public void transfer(String filename) throws KettleException {
        KettleEnvironment.init();
        TransMeta tm = new TransMeta(filename);
        Trans trans = new Trans(tm);
        // 空参调用
        trans.execute(null);
        trans.waitUntilFinished();
    }

    // 获得文件绝对地址(项目绝对地址+我的文件相对项目的地址)
    private String getFilePath() {
        String absolute = this.getClass().getClassLoader().getResource("").getPath();
        if (absolute.startsWith("/")) {
            absolute = absolute.substring(1);
        }
        return absolute;

    }
}
