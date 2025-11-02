package org.carpenoctemcloud.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckTask {
    Logger logger = LoggerFactory.getLogger(HealthCheckTask.class);

    @Scheduled(cron = "1/3 * * * * *")
    public void healthCheck() {
        logger.info("Scheduling is still alive!");
    }
}
