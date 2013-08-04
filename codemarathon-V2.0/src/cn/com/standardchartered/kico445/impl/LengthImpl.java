package cn.com.standardchartered.kico445.impl;

import cn.com.standardchartered.kico445.dto.LengthDTO;
import cn.com.standardchartered.kico445.dto.LengthExpressionDTO;
import cn.com.standardchartered.kico445.uitls.LengthLog;

/***
 * ���ȶ���ӿ�ʵ����
 * @author kico445 2013-08-04 
 */
public class LengthImpl implements Length{
	
	@Override
	public LengthDTO unitConvert(LengthDTO srcLengthDto, String dstUnit) {
		LengthDTO convertDto = srcLengthDto; //ת��ʧ�ܴ�����ֵ������ת��
		try {
			convertDto = srcLengthDto.unitConvert(dstUnit);
		} catch (Exception e) {
			LengthLog.error("��λת��ʧ�ܣ� Դ���ȶ���-"+srcLengthDto.toString());
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
			LengthLog.error("���ȵ�λ���ʽ����������æȷ�ϱ��ʽ�Ƿ���ȷ��лл ");
			e.printStackTrace();
		}
		return resultDto;
	}
	
	

}
