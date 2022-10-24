package com.whale.challenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseDto {

	@Schema(description = "조회 데이터")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Object data; // 결과값

	@Schema(description = "성공/실패 여부 코드", example = "1")
	public String code; // 오류 여부

	@Schema(description = "Response 메시지", example = "success")
	public String message; // 메시지

	public String[] column;

	public ResponseDto(Object data, String message) { // 생성자 (조회 성공 처리)
		this.data = data;
		this.code = "1";
		this.message = message;
	}

	public ResponseDto(Object data, String code, String message) {
		this.data = data;
		this.code = code;
		this.message = message;
	}

	public ResponseDto(Object data, String[] column, String message) { // 생성자 (조회 성공 처리)
		this.data = data;
		this.column = column;
		this.code = "1";
		this.message = message;
	}

	public ResponseDto(String code, String message) { // 생성자 (오류 처리)
		this.data = null;
		this.code = code;
		this.message = message;
	}

	public ResponseDto(String message) { // 생성자 (데이터 삭제 성공 처리)
		this.data = null;
		this.code = "1";
		this.message = message;
	}

	public ResponseEntity<ResponseDto> wrap() { // ResponseEntity로 wrapping하는 메소드

		ResponseEntity<ResponseDto> res = new ResponseEntity<>(HttpStatus.OK);
		res = ResponseEntity.ok(this);

		return res;

	}

}
