package junit_;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	private MyMath myMath = new MyMath();

	@Test
	void calculateSum_ThreeMemberArray() {		
		assertEquals(6, myMath.calculateSum(new int[] { 1, 2, 3 }));
	}
	
	@Test
	void calculateSum_ZeroMemberArray() {
		assertEquals(0, myMath.calculateSum(new int[] {}));
	}
}
