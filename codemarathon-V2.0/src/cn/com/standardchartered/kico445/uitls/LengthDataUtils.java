package cn.com.standardchartered.kico445.uitls;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthDataUtils {
	
	private static List<String> txtUnitDictionary = null; //转换比率
	private static List<String> txtExpressions = null;//长度对象表达式字符串
	private static List<String> txtLengths = null; //长度对象字符串
	private static Map<String,String> units4Unit = null; //单位单复数映射
	
	/**
	 * 单位单复数映射加载
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
	 * 获取单位转换比率
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
	 * 获取长度表达式字符串
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
	 * 获取长度对象字符串
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
	 * 从input.txt文件中加载内容
	 * 简单对输入部分进行区分 根据文件内容格式描述
	 * @throws Exception 
	 */
	private static void loadUnitData() throws Exception{
		String inputFileName = LengthConfigUtils.getProperty("inputFileName");
		String strUnitData = "";
		BufferedReader unitDataReader = null;
		try {
			unitDataReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(inputFileName)));
		} catch (Exception e) {
			LengthLog.error(" 加载数据文件 ： "+inputFileName+" 出现错误");
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
			LengthLog.error("从输入文件中加载信息出错 ！");
			e.printStackTrace();
			throw e;
		}finally{
			try {
				unitDataReader.close();
			} catch (IOException e) {
				LengthLog.error("关闭输入文件读取流加出错 ！");
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 长度对象字符串格式校验
	 * @param txtLength
	 * @return
	 */
	public static boolean beLengthTxt(String txtLength){
		//
		
		return true;
	}
	
	/**
	 * 长度对象表达式字符串格式校验
	 * @param txtExpression
	 * @return
	 */
	public static boolean beLengthExpressionTxt(String txtExpression){
		
		return true;
	}
	
	/**
	 * 长度单位转换率公式字符串格式校验
	 * @param txtDictionaryTxt
	 * @return
	 */
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
