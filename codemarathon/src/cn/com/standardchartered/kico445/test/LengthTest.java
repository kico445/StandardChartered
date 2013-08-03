package cn.com.standardchartered.kico445.test;

import org.junit.Test;
import cn.com.standardchartered.kico445.dto.LengthDTO;

public class LengthTest {
	
	@Test
	public void testUnitConvert(){
		LengthDTO dto = new LengthDTO();
		dto.setData(1.0);
		dto.setUnit("inch");
		dto.unitConvert("yard");
		System.out.println("result : "+dto.toString());
		
	}

	@Test
	//简单支持转换为非标志单位
	public void testParseTxt2DTO(){
		LengthDTO dto = new LengthDTO();
		dto.parseTxt2DTO("1 furlong");
		System.out.println("result : "+dto.toString());
		
		dto.unitConvert("fath");
		System.out.println("result : "+dto.toString());
		
	}
	


}
