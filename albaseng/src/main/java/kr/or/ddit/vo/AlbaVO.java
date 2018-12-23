package kr.or.ddit.vo;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlbaVO {
	
	private String alba_code;
	@NotBlank
	private String alba_name;
	@NotBlank
	private Long alba_age;
	@NotBlank
	private String alba_tel;
	@NotBlank
	private String alba_address;
	@NotBlank
	private String alba_grade;
	@NotBlank
	private String alba_gender;
	private String alba_career;
	
	
}
