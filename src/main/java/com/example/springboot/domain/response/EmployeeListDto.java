package com.example.springboot.domain.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeListDto {

	private List<EmployeeDto> list;

}
