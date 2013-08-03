package cn.com.standardchartered.kico445.uitls;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthUnitDataUtils {
	private static List<String> txtUnitDictionary = null;
	private static List<String> txtExpressions = null;
	private static List<String> txtLengths = null; 
	private static Map<String,String> units2Unit = null; 
	
	public static Map<String,String> getunits2Unit() {
		if(units2Unit==null){
			units2Unit = new HashMap<String,String>();
			units2Unit.put("miles", "mile");
			units2Unit.put("inches", "inche");
		}
		return units2Unit;
	}
	
	public static List<String> getUnitDictionary() {
		if(txtUnitDictionary==null){
			loadUnitData();
		}
		return txtUnitDictionary;
	}
	
	public static List<String> getTxtExpressions() {
		if(txtExpressions==null){
			loadUnitData();
		}
		return txtExpressions;
	}
	
	public static List<String> getTxtLengths() {
		if(txtLengths==null){
			loadUnitData();
		}
		return txtLengths;
	}

	private static void loadUnitData(){
		String inputFileName = "input.txt";
		String strUnitData = "";
		BufferedReader unitDataReader = null;
		try {
			unitDataReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(inputFileName)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				unitDataReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean beLengthTxt(String txtLength){
		
		return true;
	}
	
	public static boolean beLengthExpressionTxt(String txtExpression){
		
		return true;
	}
	
	public static boolean beUnitDictionaryTxt(String txtDictionaryTxt){
		
		return true;
	}
	
	/**
	 * 获取表达式中第一个运算符的位置
	 * @param addFlagIndex
	 * @param subFlagIndex
	 * @return
	 */
	public static int getFirstOptIndex(String txtExpression){
		int firstOptIndex = -1;
		
		int addFlagIndex = txtExpression.indexOf("+");
		int subFlagIndex = txtExpression.indexOf("-");
		//加减号都没有，这种情况运算符取完了（表达式已作初步校验 排除没有运算符情况）
		if(addFlagIndex<0 && subFlagIndex<0){
			firstOptIndex = 0;
		}else{
			if(addFlagIndex > subFlagIndex ){
				if(subFlagIndex>0){//addFlagIndex > subFlagIndex subFlagIndex > 0 即表达式中有加号 有减号 ，减号序号小，取减号序号
					firstOptIndex = subFlagIndex;
				}else{// addFlagIndex > subFlagIndex subFlagIndex < 0   即表达式中有加号 无减号 ，取加号序号
					firstOptIndex = addFlagIndex;
				}
			}else {
				if(addFlagIndex>0){//addFlagIndex < subFlagIndex addFlagIndex > 0 即表达式中有加号 有减号 ，加号序号小，取加号序号
					firstOptIndex = addFlagIndex;
				}else{// addFlagIndex < subFlagIndex addFlagIndex < 0   即表达式中无加号 有减号 ，取减号序号
					firstOptIndex = subFlagIndex;
				}
			}
			
		}
		
		return firstOptIndex;
		
	}


}
