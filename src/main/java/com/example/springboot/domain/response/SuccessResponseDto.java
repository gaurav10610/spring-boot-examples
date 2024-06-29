package com.example.springboot.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessResponseDto {

	private Boolean isSuccess;

	private String country;

}
