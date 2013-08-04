package cn.com.standardchartered.kico445.dto;

import java.math.BigDecimal;

import cn.com.standardchartered.kico445.uitls.LengthConst;
import cn.com.standardchartered.kico445.uitls.LengthDataUtils;
/***
 * 长度单位对象实体类
 * @author kico445 2013-08-03 
 *
 */
public class LengthDTO {

	private BigDecimal data = new BigDecimal(0.0);
	private String unit = LengthConst.UNIT_METER_SIMPLE;

	public LengthDTO() {
		super();
	}
	
	public LengthDTO(BigDecimal data , String unit){
		this.data = data;
		this.unit = unit;
	}
	
	public BigDecimal getData() {
		return data;
	}

	public void setData(BigDecimal data) {
		this.data = data;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 简单支持转换为非标志单位（以标准单位进行中转）
	 * 如果目标单位异常则不作转换：没有维护其与标准单位的换算比率
	 * @param dstUnit 转换到目标单位 
	 * @return
	 * @throws Exception 
	 */
	public LengthDTO unitConvert(String dstUnit) throws Exception {
		BigDecimal rate = null;
		if(!LengthUnitDictionary.getUnitRateDictionary().keySet().contains(dstUnit)||!LengthUnitDictionary.getUnitRateDictionary().keySet().contains(this.unit)){
			return this;
		}
		if(LengthConst.UNIT_METER_SIMPLE.equals(dstUnit)){
			rate = LengthUnitDictionary.getUnitRateDictionary().get(this.unit);
			this.data = this.data.multiply(rate);
			this.unit = dstUnit;
			
		}else{
			rate = LengthUnitDictionary.getUnitRateDictionary().get(this.unit).divide(LengthUnitDictionary.getUnitRateDictionary().get(dstUnit));
			this.data = this.data.multiply(rate);
			this.unit = dstUnit;
		}
		return this;
	}
	
	/**
	 * 输入文件中文本转换成长度对象
	 * 如果对象不符合长度单位规范，转换不成功，则对象单位为M 长度值为 0
	 * @param txtLength
	 * @return
	 */
	public LengthDTO parseTxt2DTO(String txtLength){
		if(LengthDataUtils.beLengthTxt(txtLength)){
			this.data = new BigDecimal(Double.parseDouble(txtLength.trim().split(" ")[0]));
			this.unit = txtLength.trim().split(" ")[1];
		}else{
			this.data=new BigDecimal(0.0);
			this.unit=LengthConst.UNIT_METER_SIMPLE;
		}
		
		return this;
	}
	
	/**
	 * 覆盖toString方法
	 * 结果显示时，保留两位小数，计算时不作两位小数限制
	 */
	@Override
	public String toString() {
		return this.data.setScale(2,BigDecimal.ROUND_HALF_UP) + " " + this.unit;
	}
	
	

}
