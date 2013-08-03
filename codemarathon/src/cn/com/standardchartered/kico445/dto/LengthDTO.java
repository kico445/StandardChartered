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
	 * ��֧��ת��Ϊ�Ǳ�־��λ���Ա�׼��λ������ת��
	 * ���Ŀ�굥λ�쳣����ת����û��ά�������׼��λ�Ļ������
	 * @param dstUnit ת����Ŀ�굥λ 
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
	 * �����ļ����ı�ת���ɳ��ȶ���
	 * ������󲻷��ϳ��ȵ�λ�淶��ת�����ɹ��������λΪM ����ֵΪ 0
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
