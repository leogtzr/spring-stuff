package com.batch.playing.batchplaying;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableBatchProcessing
@Configuration
public class BatchPlayingApplication {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job job(final Step ourBatchStep) throws Exception {
		return jobBuilderFactory.get("jobLeo")
				.incrementer(new RunIdIncrementer())
				.start(ourBatchStep)
				.build()
				;
	}

	@Bean
	public Step ourBatchStep() {
		return stepBuilderFactory.get("stepLeo")
				.tasklet((stepContribution, chunkContext) -> null)
				.build();
	}

	public static void main(final String[] args) {
		SpringApplication.run(BatchPlayingApplication.class, args);
	}

}

