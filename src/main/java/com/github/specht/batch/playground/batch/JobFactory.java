package com.github.specht.batch.playground.batch;

import com.github.specht.batch.playground.batch.process.person.PersonJobNotificationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobFactory {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private PersonJobNotificationListener listener;

    @Autowired
    private Step step1;

    public void startUserJob() throws Exception {
        final Job personJob = jobBuilderFactory.get("personJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();

        jobLauncher.run(personJob, new JobParameters());
    }

}
