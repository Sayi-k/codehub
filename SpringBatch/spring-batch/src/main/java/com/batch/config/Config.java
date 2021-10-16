package com.batch.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.batch.dto.EmployeeDTO;
import com.batch.entity.Employee;
import com.batch.mapper.EmployeeFileRowMapper;
import com.batch.processor.EmployeeProcessor;
import com.batch.tasklet.AgeGroupSummary;
import com.batch.writer.EmployeeDBWriter;

@Configuration
public class Config {

	private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private EmployeeProcessor employeeProcessor;
    private EmployeeDBWriter employeeDBWriter;
    
    @Autowired
    AgeGroupSummary ageGroupSummary;

    @Autowired
    public Config(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, EmployeeProcessor employeeProcessor, EmployeeDBWriter employeeDBWriter){
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.employeeProcessor = employeeProcessor;
        this.employeeDBWriter = employeeDBWriter;
    }
    
    @Bean()
    public Job job() throws Exception {
        return this.jobBuilderFactory.get("JOB")
                .start(step())
                .build();
    }
    
    @Bean
    public Step step() throws Exception {
        return this.stepBuilderFactory.get("STEP")
                .<EmployeeDTO, Employee>chunk(5)
                .reader(employeeReader())
                .processor(employeeProcessor)
                .writer(employeeDBWriter)
                .build();
    }
    
    @Bean
    @StepScope
    Resource inputFileResource(@Value("#{jobParameters[fileName]}") final String fileName) throws Exception {
        return new ClassPathResource(fileName);
    }
    
    @Bean
    @StepScope
    public FlatFileItemReader<EmployeeDTO> employeeReader() throws Exception {
        FlatFileItemReader<EmployeeDTO> reader = new FlatFileItemReader<>();
        reader.setResource(inputFileResource(null));
        reader.setLineMapper(new DefaultLineMapper<EmployeeDTO>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("employeeId", "firstName", "lastName", "email", "age");
                setDelimiter(",");
            }});
            setFieldSetMapper(new EmployeeFileRowMapper());
        }});
        return reader;
    }
    
    @Bean()
    public Job job1() throws Exception {
        return this.jobBuilderFactory.get("JOB1")
                .start(step1())
                .build();
    }
    
    @Bean
    public Step step1() throws Exception {
        return this.stepBuilderFactory.get("STEP1")
        		.tasklet(ageGroupSummary)
                .build();
    }
}
