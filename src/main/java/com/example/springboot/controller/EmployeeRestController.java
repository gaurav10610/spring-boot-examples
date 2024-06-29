package com.example.springboot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.domain.context.ApiRequestContext;
import com.example.springboot.domain.request.EmployeeRequest;
import com.example.springboot.domain.response.EmployeeDto;
import com.example.springboot.domain.response.EmployeeListDto;
import com.example.springboot.domain.response.SuccessResponseDto;
import com.example.springboot.service.AsyncEmployeeService;
import com.example.springboot.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping(value = "spring-boot", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Employees Management", description = "CRUD operation of employee records")
public class EmployeeRestController {

	private final EmployeeService mainService;

	private final AsyncEmployeeService asyncEmployeeService;

	@Operation(description = "fetch all employee records", summary = "fetch all employee records")
	@ApiResponses(value = { @ApiResponse(
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(oneOf = { EmployeeListDto.class })),
			description = "list of employee records", responseCode = "200") })
	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeListDto getAllEmployees() {
		return mainService.getAllEmployees();
	}

	@Operation(description = "update employee record using id", summary = "update employee record using id")
	@ApiResponses(value = { @ApiResponse(
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(oneOf = { EmployeeDto.class })),
			description = "update employee record", responseCode = "200") })
	@PostMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeDto updateEmployee(
			@Parameter(description = "id of the employee record to update") @PathVariable(name = "id") Integer id,
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "employee details to be updated",
					content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(
							oneOf = EmployeeRequest.class))) @Valid @RequestBody EmployeeRequest request) {
		return mainService.updateEmployee(id, request);
	}

	@Operation(description = "generate employee records asynchronously",
			summary = "generate employee records asynchronously")
	@ApiResponses(value = { @ApiResponse(
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
					schema = @Schema(oneOf = { SuccessResponseDto.class })),
			description = "success response", responseCode = "200") })
	@GetMapping(value = "/employees/generate", produces = MediaType.APPLICATION_JSON_VALUE)
	public SuccessResponseDto generateEmployeeRecords() {
		asyncEmployeeService.generateEmployeeRecords();
		return SuccessResponseDto.builder()
			.isSuccess(true)
			.country(ApiRequestContext.getEmployeeConfig().getCountry())
			.build();
	}

}
