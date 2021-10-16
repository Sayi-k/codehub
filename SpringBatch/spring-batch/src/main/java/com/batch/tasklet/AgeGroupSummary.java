package com.batch.tasklet;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import com.batch.dto.EmployeeDTO;

@Component
public class AgeGroupSummary implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		try (Stream<String> empStream = Files.lines(Paths.get("src/main/resources/employees.csv"))) {
			List<EmployeeDTO> empList = empStream.map(line -> line.split(",")).map(AgeGroupSummary::employeeMapper)
					.collect(Collectors.toList());

			Map<Integer, Long> ageGropuMap = empList.stream()
					.collect(Collectors.groupingBy(EmployeeDTO::getAge, Collectors.counting()));
			
			System.out.println(ageGropuMap);

		}

		return RepeatStatus.FINISHED;
	}

	private static EmployeeDTO employeeMapper(String[] record) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(record[0]);
		employeeDTO.setFirstName(record[1]);
		employeeDTO.setLastName(record[2]);
		employeeDTO.setEmail(record[3]);
		employeeDTO.setAge(Integer.parseInt(record[4]));
		return employeeDTO;
	}
}
