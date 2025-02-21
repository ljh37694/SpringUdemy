package junit_;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	@Test
	void test() {
		MyMath myMath = new MyMath();
		
		int[] numbers = { 1, 2, 3 };
		
		int result = myMath.calculateSum(numbers);
		
		int expectedResult = 6;
		
		assertEquals(result, expectedResult);
		
		
		System.out.println(result);
	}
}
