package cn.com.standardchartered.kico445.dto;

import cn.com.standardchartered.kico445.uitls.LengthUnitDataUtils;

public class LengthDTO {

	private Double data = 0.0;
	private String unit = "m";

	public LengthDTO() {
		super();
	}
	
	public LengthDTO(Double data , String unit){
		this.data = data;
		this.unit = unit;
	}
	
	public Double getData() {
		return data;
	}

	public void setData(Double data) {
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
	 */
	public LengthDTO unitConvert(String dstUnit) {
		if(!LengthUnitDictionary.getUnitRateDictionary().keySet().contains(dstUnit)||!LengthUnitDictionary.getUnitRateDictionary().keySet().contains(this.unit)){
			return this;
		}
		if("m".equals(dstUnit)){
			this.data = this.data * LengthUnitDictionary.getUnitRateDictionary().get(this.unit);
			this.unit = dstUnit;
			
		}else{
			this.data = this.data * (LengthUnitDictionary.getUnitRateDictionary().get(this.unit) / LengthUnitDictionary.getUnitRateDictionary().get(dstUnit));
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
		if(LengthUnitDataUtils.beLengthTxt(txtLength)){
			this.data = Double.parseDouble(txtLength.trim().split(" ")[0]);
			this.unit = txtLength.trim().split(" ")[1];
		}else{
			this.data=0.0;
			this.unit="m";
		}
		
		return this;
	}
	
	@Override
	public String toString() {

		return this.data + " " + this.unit;
	}
	
	

}
