package kr.or.ddit.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Alias("vReplyVO")
public class VisitReplyVO implements Serializable{
	private Long rep_no;
	private Long vt_no;
	private String rep_writer;
	private String rep_ip;
	private String rep_pass;
	private String rep_content;
	private String rep_date;
}
