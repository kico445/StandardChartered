package cn.com.standardchartered.kico445.test;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import cn.com.standardchartered.kico445.dto.LengthUnitDictionary;

public class LengthUnitDataUtilsTest {
	
	@Test
	public void test(){
		
		Map<String,Double> unitDictionary ;
		unitDictionary = LengthUnitDictionary.getUnitRateDictionary();
		Set<String> keys = unitDictionary.keySet();
		System.out.println(" keys : "+keys.toString());
		for(String key:keys){
			System.out.println(" key: "+key+"  changes by m  :"+unitDictionary.get(key));
		}
		System.out.println(" mile"+unitDictionary.get("mile"));
		System.out.println("13232  3434  ".trim());
	}

}
