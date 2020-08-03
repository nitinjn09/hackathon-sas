package com.example.projectmanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProjectManagerLogger
{
    public  void test() throws InterruptedException {
        int count  = 0;
        while (true)
        {
            log.trace("TRACE-"+count);
            log.info("INFO-"+count);
            log.debug("DEBUG-"+count);
            log.warn("WARN-"+count);
            log.error("ERROR-"+count);
            count++;
            long millis = 1000 * 60;
            Thread.sleep(millis);
        }
    }

}
