package com.github.specht.batch.playground.batch.process.person;

import com.github.specht.batch.playground.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.springframework.batch.core.BatchStatus.COMPLETED;

@Component
public class PersonJobNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(PersonJobNotificationListener.class);

    @Autowired
    private PersonRepository repository;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (COMPLETED.equals(jobExecution.getStatus())) {
            log.info("!!! JOB FINISHED! Time to verify the results");
            repository.findAll().forEach( p ->
                    log.info(String.format("Found <%s> in the database.", p.toString())));
        }
    }
}
