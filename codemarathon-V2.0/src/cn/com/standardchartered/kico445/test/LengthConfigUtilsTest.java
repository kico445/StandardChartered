package cn.com.standardchartered.kico445.test;

import org.junit.Test;

import cn.com.standardchartered.kico445.uitls.LengthConfigUtils;

public class LengthConfigUtilsTest {

	@Test
	public void testUnitConvert(){
		System.out.println("====  inputFileName : "+LengthConfigUtils.getProperty("inputFileName"));
		System.out.println("====  kico : "+LengthConfigUtils.getProperty("kico"));
		
	}
}
