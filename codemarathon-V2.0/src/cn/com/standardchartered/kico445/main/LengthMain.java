package cn.com.standardchartered.kico445.main;


import java.util.ArrayList;
import java.util.List;

import cn.com.standardchartered.kico445.dto.LengthDTO;
import cn.com.standardchartered.kico445.dto.LengthExpressionDTO;
import cn.com.standardchartered.kico445.impl.Length;
import cn.com.standardchartered.kico445.impl.LengthImpl;
import cn.com.standardchartered.kico445.uitls.LengthConfigUtils;
import cn.com.standardchartered.kico445.uitls.LengthConst;
import cn.com.standardchartered.kico445.uitls.LengthDataUtils;
import cn.com.standardchartered.kico445.uitls.LengthLog;

public class LengthMain {
	
	public static void main(String[] args) {
		LengthDTO lengthDto = null;
		LengthExpressionDTO lengthExpressionDto = null;
		Length lengthUnit = new LengthImpl();
		List<String> txtExpressions = new ArrayList<String>();
		List<String> txtLengths = new ArrayList<String>();
		try {
			txtExpressions = LengthDataUtils.getTxtExpressions();
			txtLengths = LengthDataUtils.getTxtLengths();
		} catch (Exception e) {
			LengthLog.error("���ȶ�����ʽ�ַ��������ȶ����ַ��� ��ȡʧ�ܣ����æȷ��input.txt�Ƿ�����ĿbinĿ¼�£�лл");
			LengthLog.output("���ȶ�����ʽ�ַ��������ȶ����ַ��� ��ȡʧ�ܣ����æȷ��input.txt�Ƿ�����ĿbinĿ¼�£�лл");
			e.printStackTrace();
			return;
		}
		 
		
		LengthLog.output(LengthConfigUtils.getProperty("email"));
		LengthLog.output(LengthConst.UNIT_BLANK_LINE);
		
		for(int i=0;i<txtLengths.size();i++){
			lengthDto = new LengthDTO();
			lengthDto.parseTxt2DTO(txtLengths.get(i));
			LengthLog.output(lengthUnit.unitConvert(lengthDto, LengthConst.UNIT_METER_SIMPLE).toString());
		}
		for(int i=0;i<txtExpressions.size();i++){
			lengthExpressionDto = new LengthExpressionDTO();
			try {
				lengthExpressionDto.parseTxt2Expression(txtExpressions.get(i));
			} catch (Exception e) {
				LengthLog.error("���ȶ�����ʽ�ַ���ת���ɳ��ȱ��ʽ����ʧ�ܣ����ʽ�ַ�����"+txtExpressions.get(i)+" �����æȷ�ϸ��ַ�����ʽ�Ƿ���ȷ��лл");
				e.printStackTrace();
			}
			LengthLog.output(lengthUnit.simpleCalculate(lengthExpressionDto).toString());
		}
	}

}
