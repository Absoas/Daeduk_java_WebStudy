package kr.or.ddit.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import kr.or.ddit.validator.rules.constraints.Length;
import kr.or.ddit.validator.rules.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Alias("visitorVO")
public class VisitorVO implements Serializable{
	private Long vt_no;
	@NotBlank(message="내용 필수")
	private String vt_content;

	@NotBlank(message="작성자 필수")
	private String vt_writer;

	@NotBlank(message="비번 필수")
	@Length(min=4, max=8)
	private String vt_pass;
	
	@NotBlank(message="아이피 이상")
	private String vt_ip;
	private String vt_date;
}
