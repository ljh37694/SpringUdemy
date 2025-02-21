package junit_;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyAssertTest {
	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEach");
	}
	
	@BeforeAll
	public static void beforeALl() {
		System.out.println("beforeAll");
	}
	
	@Test
	public void Test1() {
		System.out.println("test1");
	}
	
	@Test
	public void Test2() {
		System.out.println("test2");
	}
	
	@Test
	public void Test3() {
		System.out.println("test3");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("afterEach");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("afterAll");
	}
}
