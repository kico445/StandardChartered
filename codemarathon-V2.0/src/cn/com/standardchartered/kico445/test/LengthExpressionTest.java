package cn.com.standardchartered.kico445.test;

import org.junit.Test;

import cn.com.standardchartered.kico445.dto.LengthExpressionDTO;
import cn.com.standardchartered.kico445.uitls.LengthDataUtils;

public class LengthExpressionTest {

	@Test
	public void testParseTxt2Expression() throws Exception{
		System.out.println("=== result �� "+"1234526".indexOf("2"));
		System.out.println("++++++ : "+"1234526".substring(1,7));
		System.out.println("++++++ : "+"1234526".substring("1234526".indexOf("2"),7));
		System.out.println("++++++ : "+"1234526".substring("1234526".indexOf("2")));
		
		System.out.println("------------------------------------");
		// �������⣺ foot feet ��ϵͳ�д���ת�����ˣ��ޱ��ʣ��ģ�������ת��������ʱ��Ҳ����ͬ��ϲ�
		LengthExpressionDTO exp = new LengthExpressionDTO();
		exp.parseTxt2Expression("1 furlong + 2.5 foot");
		show(exp);
		for(int i=0;i<LengthDataUtils.getTxtExpressions().size();i++){
			exp.parseTxt2Expression(LengthDataUtils.getTxtExpressions().get(i));
		}
		show(exp);
	}
	
	@Test
	public void testCalculate() throws Exception{
//		System.out.println("=== result �� "+"1234526".indexOf("2"));
//		System.out.println("++++++ : "+"1234526".substring(1,7));
//		System.out.println("++++++ : "+"1234526".substring("1234526".indexOf("2"),7));
//		System.out.println("++++++ : "+"1234526".substring("1234526".indexOf("2")));
		
		System.out.println("------------------------------------");
		// �������⣺ foot feet ��ϵͳ�д���ת�����ˣ��ޱ��ʣ��ģ�������ת��������ʱ��Ҳ����ͬ��ϲ�
		LengthExpressionDTO exp = new LengthExpressionDTO();
		exp.parseTxt2Expression("1 furlong + 2.5 foot");
		show(exp);
		exp.simpleCalculate();
		System.out.println(" result : "+exp.getExpressionResult());
		for(int i=0;i<LengthDataUtils.getTxtExpressions().size();i++){
			exp.parseTxt2Expression(LengthDataUtils.getTxtExpressions().get(i));
		}
		show(exp);
	}
	
	@Test
	public void testCalculateSingle() throws Exception{

		// �������⣺ foot feet ��ϵͳ�д���ת�����ˣ��ޱ��ʣ��ģ�������ת��������ʱ��Ҳ����ͬ��ϲ�
		//�����������ȵ�λ����ӳ��
		
		/**
		  	3.02 miles + 17.5 yards - 0 fath*12.5
			4860.21888 + 16.002 - 22.86 = 4853.36088
			-16.01 m
		 */
		LengthExpressionDTO exp = new LengthExpressionDTO();
		exp.parseTxt2Expression("0.9 miles - 18 inches");
		
		//show(exp);
		exp.simpleCalculate();
		System.out.println(" result : "+exp.getExpressionResult());
	}
	
	private void show(LengthExpressionDTO exp){

			System.out.println("==================LengthExpressionDTO.show()====================");
			System.out.println("==================lengthUnitStack : ");
			for(int i=0;i<exp.getLengthUnitStack().size();i++){
				System.out.println("  -->  "+i+" : "+exp.getLengthUnitStack().get(i));
			}
			System.out.println("==================optStack : ");
			for(int i=0;i<exp.getOptStatck().size();i++){
				System.out.println("  -->  "+i+" : "+exp.getOptStatck().get(i));
			}
			System.out.println("==================LengthExpressionDTO.show()====================");
	}
	
}
