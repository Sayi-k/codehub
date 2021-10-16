package com.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch.runner.JobRunner;

@RestController
@RequestMapping("/run")
public class JobController {

	 private JobRunner jobRunner;

	    @Autowired
	    public JobController(JobRunner jobRunner) {
	        this.jobRunner = jobRunner;
	    }
	    
	    @GetMapping("/job")
	    public String runJob() {
	        jobRunner.runBatchJob();
	        return String.format("Job Demo1 submitted successfully.");
	    }
}
