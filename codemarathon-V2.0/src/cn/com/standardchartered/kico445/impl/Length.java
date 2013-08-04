package cn.com.standardchartered.kico445.impl;

import cn.com.standardchartered.kico445.dto.LengthDTO;
import cn.com.standardchartered.kico445.dto.LengthExpressionDTO;
/***
 * ���ȶ���ӿ�  ����ӿ���Щǣǿ�����油�ӵ�
 * @author kico445 2013-08-04 
 */
public interface Length {
	
	/**
	 * ���ȵ�λת��
	 * @param srcLengthUnitDto Դ���ȵ�λ����
	 * @param dstUnit	Ŀ�곤�ȵ�λֵ
	 * @return
	 */
	public LengthDTO unitConvert(LengthDTO srcLengthUnitDto,String dstUnit);
	
	/**
	 * ���ȵ�λ������ʽ����
	 * @param lengthExpressionDto ���ȵ�λ������ʽ
	 * @return
	 */
	public LengthDTO simpleCalculate(LengthExpressionDTO lengthExpressionDto);
}
