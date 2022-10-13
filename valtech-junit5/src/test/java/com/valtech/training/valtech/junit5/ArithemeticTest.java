package com.valtech.training.valtech.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;



public class ArithemeticTest {
	
	private Arithemetic arithemetic;
	private static int zero;
	
	
    @Nested
    public class DivisionTest {
        private Arithemetic arithmetic;
        
        @Test
        public void testDivByZero(){
           arithmetic= new ArithemeticImpl();
           assertThrows(ArithmeticException.class,() -> { arithmetic.div(2,zero);});
        }
    }
	
	
	@Nested
	@DisplayName("This is for Testing Sub Method of the Arithmetic")
	public  class SubTest{
		private Arithemetic arithemetic;
		
		
		
		@ParameterizedTest
		@CsvSource({
			"Subtracting 2 postive No's, 2,3,-1",
			"Subtracting 2 Negative No's, -2,-3,1",
			"Subtracting 1 postive No's, -2,3,-5"
			
		})
		public void testSub(String name, int a,int b,int res){
			arithemetic = new ArithemeticImpl();
			assertEquals(res, arithemetic.sub(a, b));
			
			
		}
		
		
		
		
		
	}
	
	
	@DisplayName("{index} {0} {1} + {2} = {3}")
	@ParameterizedTest
	@CsvSource({
		"Adding 2 postive No's, 2,3,5",
		"Adding 2 Negative No's, -2,-3,-1",
		"Adding 1 postive No's, 2,3,5"
		
	})
	public void testAdd(String name, int a,int b,int res){
		
		
	}
	
	
	public static Stream<Arguments> argumentsForAdd(){
		
		return Stream.of(Arguments.of(2,3,5),Arguments.of(1,3,4));
	}
	

	@DisplayName(value = "{index}) Testing for add with {0} and {1} should be equals to {2} ")
	@ParameterizedTest
	@MethodSource("argumentsForAdd")
	public void testAdd(int a,int b,int res){
		//assertEquals(5, arithemetic.add(2, 3));
		//assertEquals(5, arithemetic.add(3, 2));
		
		
		
	}
	
	@ParameterizedTest
	@ValueSource(ints={2,3,4,-1,-2})
	@DisplayName(value = "{index}) Testing for add with {0} and 0")
	public void testAddZero(int a){
		assertEquals(a,arithemetic.add(a, zero) );
		//assertEquals(5,arithemetic.add(3, 2) );
		
		
		
	}
	
	
	
    @Test
    @DisplayName("Generic Test Cases for Add ...")
    public void testAdd(){
        assertEquals(5, arithemetic.add(2, 3));
        assertEquals(5, arithemetic.add(3, 2));
    }
	
	
	
	
	
	
	@BeforeAll
	public static void executemeFirst(){
		
		System.out.println("Before all - executed First......");
		zero=0;
		
		
	} 
	
	
	
	
	@BeforeEach
	public void Runbefore() {
		
		arithemetic = new  ArithemeticImpl();
		System.out.println("Run before...");
			
	}
	
	@AfterEach
	public void afterTest() {
		
	arithemetic = new  ArithemeticImpl();
		System.out.println("After each Method");
			
	}
	
	@Test
	public void testHii() {
		/*assertTrue(true);*/
		System.out.println("hiii...");
			
	}
	
	
	@Test
	public void testHello() {
		//assertTrue(true);
		System.out.println("Hello...");
			
	}
	
	

}
