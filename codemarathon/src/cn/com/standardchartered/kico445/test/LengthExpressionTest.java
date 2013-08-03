package cn.com.standardchartered.kico445.test;

import org.junit.Test;

import cn.com.standardchartered.kico445.dto.LengthExpressionDTO;
import cn.com.standardchartered.kico445.uitls.LengthUnitDataUtils;

public class LengthExpressionTest {

	@Test
	public void testParseTxt2Expression(){
		System.out.println("=== result �� "+"1234526".indexOf("2"));
		System.out.println("++++++ : "+"1234526".substring(1,7));
		System.out.println("++++++ : "+"1234526".substring("1234526".indexOf("2"),7));
		System.out.println("++++++ : "+"1234526".substring("1234526".indexOf("2")));
		
		System.out.println("------------------------------------");
		// �������⣺ foot feet ��ϵͳ�д���ת�����ˣ��ޱ��ʣ��ģ�������ת��������ʱ��Ҳ����ͬ��ϲ�
		LengthExpressionDTO exp = new LengthExpressionDTO();
		exp.parseTxt2Expression("1 furlong + 2.5 foot");
		exp.show();
		for(int i=0;i<LengthUnitDataUtils.getTxtExpressions().size();i++){
			exp.parseTxt2Expression(LengthUnitDataUtils.getTxtExpressions().get(i));
		}

		
		
		exp.show();
	}
	
}
