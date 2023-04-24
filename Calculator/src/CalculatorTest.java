import junit.framework.TestCase;
// 아래 방법은 Junit 3 방법
public class CalculatorTest extends TestCase {

	Calculator cal;
	
	@Override
	protected void setUp() throws Exception {
		cal = new Calculator();
		System.out.println("setup!");
	}
	
	public void testAdd() {
//		Calculator cal = new Calculator();
		System.out.println("test Add");
		int result= cal.add(2,1);
		assertEquals(3, result); 
		// result 가 3일 경우, 이 테스트를 통과함
	}

	// 위 메소드를 계속 만들기 힘드니
	// 이클립스 기본제공 템플릿 기능을 활용해서 실행하기
	// test3 라고 적고 ctrl + enter
	
	public void testSub() throws Exception {
		System.out.println("test sub!");
//		Calculator cal = new Calculator();
		int result = cal.sub(2, 1);
		assertEquals(1, result);
	}
	
	// 상당히 많은 중복 발생
	
	public void testMul() throws Exception {
		System.out.println("test mul");
		int result = cal.mul(2, 3);
		assertEquals(6, result);
	}
	
	// Calculator 인스턴스를 계속 생성해야하는 불편함 존재
	
	// -> setUp 메서드 활용 아래의 내용을 추가해줌
	/* 
		Calculator cal;
		
		@Override
		protected void setUp() throws Exception {
			cal = new Calculator();
		}
	 */
	
	// 그리고 Calculator cal = new Calculator(); 없앨 수 있게됨
	
	// 종료하는 작업이 필요할 때 tearDown
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("tead Down");
		super.tearDown();
	}
	
	/* 
		setup!
		test Add
		tead Down
		setup!
		test mul
		tead Down
		setup!
		test sub!
		tead Down
	 */
	// setup - test - tearDown 순으로 진행됨
	
	// Junit 으로 테스트하려면 메서드의 시작은 항상 소문자 test로 시작해야한다.
	// 특정 메서드만 테스트하려면 마우스올리고 [ctrl F11]
	
}
