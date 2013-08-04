package cn.com.standardchartered.kico445.uitls;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthDataUtils {
	
	private static List<String> txtUnitDictionary = null; //ת������
	private static List<String> txtExpressions = null;//���ȶ�����ʽ�ַ���
	private static List<String> txtLengths = null; //���ȶ����ַ���
	private static Map<String,String> units4Unit = null; //��λ������ӳ��
	
	/**
	 * ��λ������ӳ�����
	 * @return
	 */
	public static Map<String,String> getunits4Unit() {
		if(units4Unit==null){
			units4Unit = new HashMap<String,String>();
			LengthConfigUtils.loadUnits4unit(units4Unit);
		}
		return units4Unit;
	}
	
	/**
	 * ��ȡ��λת������
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getUnitDictionary() throws Exception {
		if(txtUnitDictionary==null){
			loadUnitData();
		}
		return txtUnitDictionary;
	}
	
	/**
	 * ��ȡ���ȱ��ʽ�ַ���
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getTxtExpressions() throws Exception {
		if(txtExpressions==null){
			loadUnitData();
		}
		return txtExpressions;
	}
	
	/**
	 * ��ȡ���ȶ����ַ���
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getTxtLengths() throws Exception {
		if(txtLengths==null){
			loadUnitData();
		}
		return txtLengths;
	}

	/**
	 * ��input.txt�ļ��м�������
	 * �򵥶����벿�ֽ������� �����ļ����ݸ�ʽ����
	 * @throws Exception 
	 */
	private static void loadUnitData() throws Exception{
		String inputFileName = LengthConfigUtils.getProperty("inputFileName");
		String strUnitData = "";
		BufferedReader unitDataReader = null;
		try {
			unitDataReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(inputFileName)));
		} catch (Exception e) {
			LengthLog.error(" ���������ļ� �� "+inputFileName+" ���ִ���");
			e.printStackTrace();
			throw e;
		}
		
		try {
			txtUnitDictionary = new ArrayList<String>();
			txtExpressions = new ArrayList<String>();
			txtLengths = new ArrayList<String>();
			while ((strUnitData=unitDataReader.readLine())!=null){
				
				if(strUnitData.indexOf("=")>0){
					txtUnitDictionary.add(strUnitData.trim());
				}else if (strUnitData.indexOf("+")>0||strUnitData.indexOf("-")>0){
					txtExpressions.add(strUnitData.trim());
				}else if("".equals(strUnitData.trim())){
					
				}else {
					txtLengths.add(strUnitData.trim());
				}

			}
		} catch (IOException e) {
			LengthLog.error("�������ļ��м�����Ϣ���� ��");
			e.printStackTrace();
			throw e;
		}finally{
			try {
				unitDataReader.close();
			} catch (IOException e) {
				LengthLog.error("�ر������ļ���ȡ���ӳ��� ��");
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * ���ȶ����ַ�����ʽУ��
	 * @param txtLength
	 * @return
	 */
	public static boolean beLengthTxt(String txtLength){
		//
		
		return true;
	}
	
	/**
	 * ���ȶ�����ʽ�ַ�����ʽУ��
	 * @param txtExpression
	 * @return
	 */
	public static boolean beLengthExpressionTxt(String txtExpression){
		
		return true;
	}
	
	/**
	 * ���ȵ�λת���ʹ�ʽ�ַ�����ʽУ��
	 * @param txtDictionaryTxt
	 * @return
	 */
	public static boolean beUnitDictionaryTxt(String txtDictionaryTxt){
		
		return true;
	}
	
	/**
	 * ��ȡ���ʽ�е�һ���������λ��
	 * @param addFlagIndex
	 * @param subFlagIndex
	 * @return
	 */
	public static int getFirstOptIndex(String txtExpression){
		int firstOptIndex = -1;
		
		int addFlagIndex = txtExpression.indexOf("+");
		int subFlagIndex = txtExpression.indexOf("-");
		//�Ӽ��Ŷ�û�У�������������ȡ���ˣ����ʽ��������У�� �ų�û������������
		if(addFlagIndex<0 && subFlagIndex<0){
			firstOptIndex = 0;
		}else{
			if(addFlagIndex > subFlagIndex ){
				if(subFlagIndex>0){//addFlagIndex > subFlagIndex subFlagIndex > 0 �����ʽ���мӺ� �м��� ���������С��ȡ�������
					firstOptIndex = subFlagIndex;
				}else{// addFlagIndex > subFlagIndex subFlagIndex < 0   �����ʽ���мӺ� �޼��� ��ȡ�Ӻ����
					firstOptIndex = addFlagIndex;
				}
			}else {
				if(addFlagIndex>0){//addFlagIndex < subFlagIndex addFlagIndex > 0 �����ʽ���мӺ� �м��� ���Ӻ����С��ȡ�Ӻ����
					firstOptIndex = addFlagIndex;
				}else{// addFlagIndex < subFlagIndex addFlagIndex < 0   �����ʽ���޼Ӻ� �м��� ��ȡ�������
					firstOptIndex = subFlagIndex;
				}
			}
			
		}
		
		return firstOptIndex;
		
	}


}
