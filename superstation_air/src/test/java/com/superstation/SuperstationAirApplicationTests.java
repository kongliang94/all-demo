package com.superstation;

import com.superstation.entity.Air1m20191001B;
import com.superstation.mapper.Air1m20191001BMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperstationAirApplicationTests {

    @Autowired
    private Air1m20191001BMapper air1m20191001BMapper;

    @Test
    public void mytest() {
        Air1m20191001B air1m20191001B=new Air1m20191001B();
        String FORMAT_LONG = "yyyy-MM-dd HH:mm";
        int i=100;
        int j=12;

            while (j!=0) {
                int code=100+j;
                air1m20191001B.setDetectionItemCode(code+"");
                Random random=new Random();
                double f=200.0;
                air1m20191001B.setMonValue(random.nextDouble()*100+"");
                air1m20191001B.setStationCode("1001B");
                air1m20191001B.setTimePoint(new Date());
                //air1m20191001B.setGmtCreate();
                air1m20191001BMapper.insert(air1m20191001B);
                j--;
            }


    }

}
