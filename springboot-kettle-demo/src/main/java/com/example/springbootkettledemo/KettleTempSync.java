package com.example.springbootkettledemo;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class KettleTempSync {

    private static Logger logger= LoggerFactory.getLogger(KettleTempSync.class);

    @Value("${kettle.script.path1}")
    private String dirPath;


    @Value("${kettle.script.path2}")
    private String minuteSync;

    @Scheduled(cron = "0 */1 * * * *")
    public void kettleSync() {
        logger.info("==========开始定时任务===========");
        // 调用转换
        try {
            transfer(dirPath);
            transfer(minuteSync);
        } catch (KettleException e) {
            e.printStackTrace();
        }
        logger.info("===========结束定时任务==========");
    }

    public void transfer(String filename) throws KettleException {
        KettleEnvironment.init();
        TransMeta tm = new TransMeta(filename);
        Trans trans = new Trans(tm);
        // 空参调用
        trans.execute(null);
        trans.waitUntilFinished();
    }
}
