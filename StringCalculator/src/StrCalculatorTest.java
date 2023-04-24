import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StrCalculatorTest {

	private StrCalculator strCalculator;
	
	@Before
	public void setUp() {
		strCalculator = new StrCalculator();
	}
	
	@Test
	public void add_숫자한개() throws Exception {
		assertEquals(3, strCalculator.add("3"));
	}
	
	@Test
	public void add_숫자두개와쉼표() throws Exception {
		assertEquals(5, strCalculator.add("3,2"));
	}

	@Test
	public void add_숫자3개와콜론() throws Exception {
		assertEquals(10, strCalculator.add("3:2:5"));
	}
	
	@Test
	public void add_숫자3개와쉼표콜론() throws Exception {
		assertEquals(10, strCalculator.add("3,2:5"));
	}
	
	@Test
	public void split구분테스트() {
		assertArrayEquals(new String[] {"1"}, "1".split(",|:"));
		// 숫자하나만 있어도 정상
		assertArrayEquals(new String[] {"1", "2"}, "1,2".split(",|:"));
	}
	
	@Test
	public void 커스텀구분자테스트() {
		assertEquals(10, strCalculator.add("//;\n2;3;5"));
		assertEquals(10, strCalculator.add("//z\n2z3z5"));
	}
	
	@Test(expected = RuntimeException.class)
	public void add_음수() throws Exception {
		strCalculator.add("-1,2,5");
	}
	
}
