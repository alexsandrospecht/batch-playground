package com.github.specht.batch.playground.controller;

import com.github.specht.batch.playground.batch.JobFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/batch")
public class BatchController {

    @Autowired
    private JobFactory jobFactory;

    @ApiOperation(value = "Schedule a new job, this job will consume sample-data.csv")
    @PostMapping
    public ResponseEntity scheduleJob() throws Exception {
        jobFactory.startUserJob();

        return ResponseEntity.status(CREATED).build();
    }

    @ApiIgnore
    @GetMapping
    public ResponseEntity swaggerIgnoreTest() {
        return ResponseEntity.ok().build();
    }

}
