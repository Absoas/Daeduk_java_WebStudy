package kr.or.ddit.call;

/**
 * 메소드 호출 시 아규먼트(인자)를 전달하는 방법
 * 1) Call by Value		: 인자의 타입이 기본형 일때 
 * 						호출자쪽에서 전달할 값을 복사해서 인자를 넘기는 방식.
 * 2) Call by Reference : 인자의 타입이 객체 참조형일 때 
 * 
 */
public class MethodInvocationDesc {
	public static void main(String[] args) {
		int number = 1;
		callByValueTest(number);
		System.out.println(number);
	}
	
	private static int callByValueTest(int number) {
		for (int i = 0; i < 10; i++) {
			number = number+1;
		}
		return number;
	}
}
