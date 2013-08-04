package cn.com.standardchartered.kico445.dto;

import java.math.BigDecimal;

import cn.com.standardchartered.kico445.uitls.LengthConst;
import cn.com.standardchartered.kico445.uitls.LengthDataUtils;
/***
 * ���ȵ�λ����ʵ����
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
	 * ��֧��ת��Ϊ�Ǳ�־��λ���Ա�׼��λ������ת��
	 * ���Ŀ�굥λ�쳣����ת����û��ά�������׼��λ�Ļ������
	 * @param dstUnit ת����Ŀ�굥λ 
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
	 * �����ļ����ı�ת���ɳ��ȶ���
	 * ������󲻷��ϳ��ȵ�λ�淶��ת�����ɹ��������λΪM ����ֵΪ 0
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
	 * ����toString����
	 * �����ʾʱ��������λС��������ʱ������λС������
	 */
	@Override
	public String toString() {
		return this.data.setScale(2,BigDecimal.ROUND_HALF_UP) + " " + this.unit;
	}
	
	

}
