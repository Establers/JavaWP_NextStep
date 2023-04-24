import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest2 {

//	private Calculator cal = new Calculator();
	
	private Calculator cal;
	@Before
	public void setup() {
		cal = new Calculator();
		System.out.println("setup");
	}
	
	@Test
	public void add() {
		int result = cal.add(2, 1);
		assertEquals(3, result); // 과거는 sysout 을 했지만 
		System.out.println("add");
		// 기대하는 값 : 3
	}
	// Test Annotation을 Junit 라이브러리가 읽어서 동작
	
	@Test
	public void div() {
//		Calculator cal = new Calculator();
//		int result = cal.div(9, 3);
//		assertEquals(3, result);
		// 이런식으로 하면 단순한 테스트인데 두줄을 써야함
		
		assertEquals(3, cal.div(9, 3));
		System.out.println("div");
		// expected와 결과값이 다르면 Fail이 뜨는데
		// 실패 메시지를 보고 production code의 문제를 확인할 수 있겠다
		
	}
	
	// Calculator 중복을 제거하겠다.
	// Refactor -> Convert Local Variable to Field
	// 아니면 라인을 그대로 위로 클래스의 멤버필드로 빼서도 가능 
	// private Calculator cal = new Calculator(); (테스트간 독립성 보장 한계)
	
	// 하지만 Junit 은 이 방법을 권장하지 않음
	// @Before 로 설정해서 초기화하는 방법을 추천하고 있음
	
	// 테스트가 실행될 때, 초기화 작업이 한번만 실행이 되는데
	// 한번 실행 후, cal instance를 공유해서 써서 인스턴스의 상태를 바꾸게 되면
	// 다른 메서드에 영향을 미칠 수 있음 -> 테스트가 성공 했다가 실패하는 문제 발생
	// 서로 독립적인 실행을 보장을 하기 위해 @Before를 통해 테스트의 독립성을 보장하도록 지원함
	// 각각의 테스트 메서드가 실행될 때마다 setup 메서드가 실행되게해서 독립성을 보장하게 하는 것
	
	// @Before 가 있으면 @After도 있음
	// 후처리 작업
	
	@After
	public void tearDown() {
		System.out.println("after");
	}
	
	/*
		setup
		add
		after
		setup
		div
		after
	*/
	
	// 테스트 메서드가 실행될 때 마다, 초기화작업과 후처리 작업을 실행한다는 것
	// 각 테스트 간의 독립성을 보장
	
	// 테스트 결과 검증하고 싶을 때는 assertEquals 메서드를 통해 검증할 수 있다.
	
	
	
	
}
