package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
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

	private String vt_content;
	private String vt_writer;
	private String vt_pass;
	private String vt_ip;
	private String vt_date;
	private FileItem item;
}
