package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Alias("VpdsVO")
public class VPdsVO implements Serializable{
		
	public VPdsVO(FileItem item) {
		super();
		this.item = item;
		setVpds_size(item.getSize());
		setVpds_fancysize(FileUtils.byteCountToDisplaySize(item.getSize()));
		setVpds_filename(item.getName());
		setVpds_mime(item.getContentType());
		setVpds_savename(UUID.randomUUID().toString());
	}
	
	private Long vpds_no;
	private Long vt_no;
	private String vpds_filename;
	private String vpds_savename;
	private String vpds_mime;
	private Long vpds_size;
	private String vpds_fancysize;
	private FileItem item;
	
}
