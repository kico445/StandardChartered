package cn.com.standardchartered.kico445.impl;

import cn.com.standardchartered.kico445.dto.LengthDTO;
import cn.com.standardchartered.kico445.dto.LengthExpressionDTO;
import cn.com.standardchartered.kico445.uitls.LengthLog;

/***
 * 长度对象接口实现类
 * @author kico445 2013-08-04 
 */
public class LengthImpl implements Length{
	
	@Override
	public LengthDTO unitConvert(LengthDTO srcLengthDto, String dstUnit) {
		LengthDTO convertDto = srcLengthDto; //转换失败传自身值，不作转换
		try {
			convertDto = srcLengthDto.unitConvert(dstUnit);
		} catch (Exception e) {
			LengthLog.error("单位转换失败： 源长度对象-"+srcLengthDto.toString());
			e.printStackTrace();
		}
		return convertDto;
	}

	@Override
	public LengthDTO simpleCalculate(LengthExpressionDTO lengthExpressionDto) {
		LengthDTO resultDto = null;
		try {
			resultDto = lengthExpressionDto.simpleCalculate();
		} catch (Exception e) {
			LengthLog.error("长度单位表达式计算错误，请帮忙确认表达式是否正确，谢谢 ");
			e.printStackTrace();
		}
		return resultDto;
	}
	
	

}
