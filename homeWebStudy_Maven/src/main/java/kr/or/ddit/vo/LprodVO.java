package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class LprodVO implements Serializable{
	String lprod_id;
	String lprod_gu;
	String lprod_nm;
	
	public String getLprod_id() {
		return lprod_id;
	}
	public void setLprod_id(String lprod_id) {
		this.lprod_id = lprod_id;
	}
	public String getLprod_gu() {
		return lprod_gu;
	}
	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lprod_id == null) ? 0 : lprod_id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LprodVO other = (LprodVO) obj;
		if (lprod_id == null) {
			if (other.lprod_id != null)
				return false;
		} else if (!lprod_id.equals(other.lprod_id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "LprodVO [lprod_id=" + lprod_id + ", lprod_gu=" + lprod_gu + ", lprod_nm=" + lprod_nm + "]";
	}
	
}
