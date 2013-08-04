package cn.com.standardchartered.kico445.test;

import java.math.BigDecimal;

import org.junit.Test;
import cn.com.standardchartered.kico445.dto.LengthDTO;

public class LengthTest {
	
	@Test
	public void testUnitConvert() throws Exception{
		LengthDTO dto = new LengthDTO();
		dto.setData(new BigDecimal(1.0));
		dto.setUnit("inch");
		dto.unitConvert("yard");
		System.out.println("result : "+dto.toString());
		
	}

	@Test
	//简单支持转换为非标志单位
	public void testParseTxt2DTO() throws Exception{
		LengthDTO dto = new LengthDTO();
		dto.parseTxt2DTO("127.93 feet");
		System.out.println("result : "+dto.toString());
		
		//dto.unitConvert("fath");
		dto.unitConvert("m");
		System.out.println("result : "+dto.toString());
		
	}
	


}
