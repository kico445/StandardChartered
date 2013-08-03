package cn.com.standardchartered.kico445.test;

import org.junit.Test;

import cn.com.standardchartered.kico445.dto.LengthExpressionDTO;
import cn.com.standardchartered.kico445.uitls.LengthUnitDataUtils;

public class LengthExpressionTest {

	@Test
	public void testParseTxt2Expression(){
		System.out.println("=== result ： "+"1234526".indexOf("2"));
		System.out.println("++++++ : "+"1234526".substring(1,7));
		System.out.println("++++++ : "+"1234526".substring("1234526".indexOf("2"),7));
		System.out.println("++++++ : "+"1234526".substring("1234526".indexOf("2")));
		
		System.out.println("------------------------------------");
		// 测试问题： foot feet 当系统中存在转换不了（无比率）的，不进行转换，运算时，也不作同类合并
		LengthExpressionDTO exp = new LengthExpressionDTO();
		exp.parseTxt2Expression("1 furlong + 2.5 foot");
		exp.show();
		for(int i=0;i<LengthUnitDataUtils.getTxtExpressions().size();i++){
			exp.parseTxt2Expression(LengthUnitDataUtils.getTxtExpressions().get(i));
		}

		
		
		exp.show();
	}
	
}
