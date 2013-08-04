package cn.com.standardchartered.kico445.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.standardchartered.kico445.uitls.LengthConst;
import cn.com.standardchartered.kico445.uitls.LengthDataUtils;
/***
 * 长度单位转换 比率字典
 * @author kico445 2013-08-04 
 */
public class LengthUnitDictionary {
	private static Map<String,BigDecimal> unitRateDictionary = null;

	public static Map<String,BigDecimal> getUnitRateDictionary() throws Exception{
		if(unitRateDictionary == null){
			parseTxt2DTO(LengthDataUtils.getUnitDictionary());
		}
		return unitRateDictionary;
	}
	
	/**
	 * 将长度单位转换比率 加载
	 * @param list
	 */
	private static void parseTxt2DTO(List<String> list){
		String txtUnitDictionary = "";
		String unit = "";
		Double rate2m = 0.0;
		unitRateDictionary = new HashMap<String,BigDecimal>();
		unitRateDictionary.put(LengthConst.UNIT_METER_SIMPLE, new BigDecimal(1.0));
		unitRateDictionary.put(LengthConst.UNIT_METER_FULL, new BigDecimal(1.0));//输入文件中 标准单位是m 还是 meter 描述与input文件不是很明确
		for(int i=0;i<list.size();i++){
			txtUnitDictionary = list.get(i);
			if(LengthDataUtils.beUnitDictionaryTxt((list.get(i)))){
				rate2m = Double.parseDouble(txtUnitDictionary.split(" = ")[1].trim().split(" ")[0]);
				unit = txtUnitDictionary.split(" = ")[0].trim().split(" ")[1];
				unitRateDictionary.put(unit, new BigDecimal(rate2m));
				unitRateDictionary.put(LengthDataUtils.getunits4Unit().get(unit), new BigDecimal(rate2m));
			}
		}
	}
}
