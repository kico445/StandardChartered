package cn.com.standardchartered.kico445.test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import cn.com.standardchartered.kico445.dto.LengthUnitDictionary;

public class LengthDataUtilsTest {
	
	@Test
	public void test() throws Exception{
		
		Map<String,BigDecimal> unitDictionary ;
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
