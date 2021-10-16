package com.batch.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.batch.runner.JobRunner;

@Component
public class JobScheduler {

	@Autowired
	private JobRunner jobRunner;
	
	@Scheduled(cron = "0/5 * * * * *")
	public void schedule() {
		jobRunner.runBatchJob();
	}
	
	@Scheduled(cron = "0/10 * * * * *")
	public void scheduleAnother() {
		jobRunner.runBatchJobAnother();
	}
}
