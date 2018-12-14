package kr.or.ddit.dao;

public class SampleOracleDAO implements ISampleDAO{
	public String selectSampleData(String pk){
		return String.format("%s를 받아서 %s 데이터를 조회함.", pk , getClass().getSimpleName());
	}
}
