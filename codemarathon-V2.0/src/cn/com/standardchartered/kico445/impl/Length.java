package cn.com.standardchartered.kico445.impl;

import cn.com.standardchartered.kico445.dto.LengthDTO;
import cn.com.standardchartered.kico445.dto.LengthExpressionDTO;
/***
 * 长度对象接口  这个接口有些牵强呃后面补加的
 * @author kico445 2013-08-04 
 */
public interface Length {
	
	/**
	 * 长度单位转换
	 * @param srcLengthUnitDto 源长度单位对象
	 * @param dstUnit	目标长度单位值
	 * @return
	 */
	public LengthDTO unitConvert(LengthDTO srcLengthUnitDto,String dstUnit);
	
	/**
	 * 长度单位对象表达式计算
	 * @param lengthExpressionDto 长度单位对象表达式
	 * @return
	 */
	public LengthDTO simpleCalculate(LengthExpressionDTO lengthExpressionDto);
}
