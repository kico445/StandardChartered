package cn.com.standardchartered.kico445.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.standardchartered.kico445.uitls.LengthUnitDataUtils;

public class LengthUnitDictionary {
	private static Map<String,Double> unitRateDictionary = null;

	public static Map<String,Double> getUnitRateDictionary(){
		if(unitRateDictionary == null){
			parseTxt2DTO(LengthUnitDataUtils.getUnitDictionary());
		}
		return unitRateDictionary;
	}
	private static void parseTxt2DTO(List<String> list){
		String txtUnitDictionary = "";
		String unit = "";
		Double rate2m = 0.0;
		unitRateDictionary = new HashMap<String,Double>();
		unitRateDictionary.put("m", 1.0);
		for(int i=0;i<list.size();i++){
			txtUnitDictionary = list.get(i);
			if(LengthUnitDataUtils.beUnitDictionaryTxt((list.get(i)))){
				rate2m = Double.parseDouble(txtUnitDictionary.split(" = ")[1].trim().split(" ")[0]);
				unit = txtUnitDictionary.split(" = ")[0].trim().split(" ")[1];
				unitRateDictionary.put(unit, rate2m);
			}
		}
	}
}
