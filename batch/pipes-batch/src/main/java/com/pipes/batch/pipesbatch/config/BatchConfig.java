package com.pipes.batch.pipesbatch.config;

import com.pipes.batch.pipesbatch.domain.PayrollTo;
import com.pipes.batch.pipesbatch.listener.JobCompletionPayRollListener;
import com.pipes.batch.pipesbatch.transformation.PayRollItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    // Read the input data
    @Bean
    public FlatFileItemReader<PayrollTo> reader() {
        return new FlatFileItemReaderBuilder<PayrollTo>()
                .name("payrollItemReader")
                .resource(new ClassPathResource("payroll-data.csv"))
                .delimited()
                .names(
                        new String[]{
                                "identification", "currency", "ammount",
                                "accountType", "accountNumber", "description",
                                "firstLastName"}
                )
                .fieldSetMapper(
                        new BeanWrapperFieldSetMapper<PayrollTo>() {{
                            setTargetType(PayrollTo.class);
                        }})
                .build();
    }

    // Process data
    @Bean
    public PayRollItemProcessor processor() {
        return new PayRollItemProcessor();
    }

    // Write the produced data
    @Bean
    public JdbcBatchItemWriter<PayrollTo> writer(final DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PayrollTo>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(
                        "INSERT INTO PAYROLL (PERSON_IDENTIFICATION, CURRENCY, TX_AMMOUNT, ACCOUNT_TYPE, ACCOUNT_ID, TX_DESCRIPTION, FIRST_LAST_NAME) VALUES (:identification,:currency,:ammount,:accountType,:accountNumber, :description, :firstLastName)")
                .dataSource(dataSource)
                .build()
                ;
    }

    @Bean
    public Job importPayRollJob(final JobCompletionPayRollListener listener, final Step step1) {
        return jobBuilderFactory.get("importPayRollJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build()
                ;
    }

    @Bean
    public Step step1(final JdbcBatchItemWriter<PayrollTo> writer) {
        return stepBuilderFactory.get("step1")
                .<PayrollTo, PayrollTo>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build()
                ;
    }

}
