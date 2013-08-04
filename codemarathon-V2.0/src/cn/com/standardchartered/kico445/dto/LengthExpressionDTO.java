package cn.com.standardchartered.kico445.dto;

import java.util.ArrayList;
import java.util.List;

import cn.com.standardchartered.kico445.uitls.LengthConst;
import cn.com.standardchartered.kico445.uitls.LengthDataUtils;
import cn.com.standardchartered.kico445.uitls.LengthLog;
/***
 * ���ȵ�λ������ʽʵ����
 * @author kico445 2013-08-03 
 */
public class LengthExpressionDTO {
	private List<LengthDTO> lengthUnitStack = new ArrayList<LengthDTO>();//���ȶ���
	private List<String> optStatck = new ArrayList<String>();
	private LengthDTO result = new LengthDTO();
	
	public LengthDTO getExpressionResult(){
		return this.result;
	}
	public List<LengthDTO> getLengthUnitStack() {
		return lengthUnitStack;
	}

	public void setLengthUnitStack(List<LengthDTO> lengthUnitStack) {
		this.lengthUnitStack = lengthUnitStack;
	}

	public List<String> getOptStatck() {
		return optStatck;
	}

	public void setOptStatck(List<String> optStatck) {
		this.optStatck = optStatck;
	}
	
	/**
	 * ���ַ���ת���ɳ��ȱ��ʽ
	 * @param txtExpression
	 * @throws Exception 
	 */
	public void parseTxt2Expression(String txtExpression) throws Exception{
		int firstOptIndex = 0;
		LengthDTO lenghtDto = null;
		String opt = "";
		if(LengthDataUtils.beLengthExpressionTxt(txtExpression)){
			LengthLog.log("������ʽ: "+txtExpression);
			while (!"".equals(txtExpression)){
				show();
				lenghtDto = null;
				firstOptIndex = LengthDataUtils.getFirstOptIndex(txtExpression);
				if(firstOptIndex>0){
					lenghtDto = new LengthDTO();
					lenghtDto.parseTxt2DTO(txtExpression.substring(0,firstOptIndex).trim());
					System.out.println("====  txt : "+txtExpression);
					lengthUnitStack.add(lenghtDto.unitConvert(LengthConst.UNIT_METER_SIMPLE));
					opt = txtExpression.substring(firstOptIndex,firstOptIndex+1);
					optStatck.add(opt);
					txtExpression = txtExpression.substring(firstOptIndex+1).trim();
					System.out.println("====  txt : "+txtExpression);
				}else if (firstOptIndex==0){
					lenghtDto = new LengthDTO();
					lenghtDto.parseTxt2DTO(txtExpression.substring(0).trim());
					System.out.println("====  txt : "+txtExpression);
					lengthUnitStack.add(lenghtDto.unitConvert(LengthConst.UNIT_METER_SIMPLE));
					txtExpression = "";
				}
			}
			
		}
	}
	
	/**
	 * �򵥳��ȶ�����ʽ�Ӽ�������,�����㣬�����ȼ�
	 * @return LengthDTO
	 * @throws Exception 
	 */
	public LengthDTO simpleCalculate() throws Exception{
		for(int i=0;i<this.optStatck.size();i++){
			System.out.println("step : "+ i );
			show();
			if(i==0){
				if("+".equals(this.optStatck.get(i).trim())){
					this.add(this.lengthUnitStack.get(0)).add(this.lengthUnitStack.get(1));
					this.lengthUnitStack.remove(0);
					this.lengthUnitStack.remove(0);
					System.out.println("=====  remove ========");
					show();
				}else if("-".equals(this.optStatck.get(i).trim())){
					this.add(this.lengthUnitStack.get(0)).sub(this.lengthUnitStack.get(1));
					this.lengthUnitStack.remove(0);
					this.lengthUnitStack.remove(0);
					System.out.println("=====  remove ========");
					show();
				}
			}else {
				if("+".equals(this.optStatck.get(i).trim())){
					this.add(this.lengthUnitStack.get(0));
					this.lengthUnitStack.remove(0);
					System.out.println("=====  remove ========");
					show();
				}else if("-".equals(this.optStatck.get(i).trim())){
					this.sub(this.lengthUnitStack.get(0));
					this.lengthUnitStack.remove(0);
					System.out.println("=====  remove ========");
					show();
				}
			}
			System.out.println("result : "+ this.getExpressionResult().toString() );
		}
		return this.result;
	}

	/**
	 * ���ʽ�򵥼ӷ�����
	 * ��׼��λ ��¼���ļ��е��ַ�����m ����meter�ݲ�ȷ�� �ұ��ʽ���Ƿ���meters���֣���ȷ��
	 * @param dto
	 * @return
	 * @throws Exception 
	 */
	public LengthExpressionDTO add(LengthDTO dto) throws Exception{
		if(!"m,meter".contains(dto.getUnit())){
			dto.unitConvert(LengthConst.UNIT_METER_SIMPLE);
		}
		result.setData(result.getData().add(dto.getData()));
		return this;
	}
	
	/**
	 * ���ʽ�򵥼���
	 * ��׼��λ ��¼���ļ��е��ַ�����m ����meter�ݲ�ȷ�� �ұ��ʽ���Ƿ���meters���֣���ȷ��
	 * @param dto
	 * @return
	 * @throws Exception 
	 */
	public LengthExpressionDTO sub(LengthDTO dto) throws Exception{
		if(!"m,meter".contains(dto.getUnit())){
			dto.unitConvert(LengthConst.UNIT_METER_SIMPLE);
		}
		result.setData(result.getData().subtract(dto.getData()));
		return this;
	}
	
	/**
	 * ���ʽ��Ϣ�鿴������ʱʹ�ã���δ��¼����־�ļ����迴��̨
	 */
	private void show(){

		System.out.println("==================LengthExpressionDTO.show() begin====================");
		System.out.println("lengthUnitStack : ");
		for(int i=0;i<this.getLengthUnitStack().size();i++){
			System.out.println("  -->  "+i+" : "+this.getLengthUnitStack().get(i));
		}
		System.out.println("optStack : ");
		for(int i=0;i<this.getOptStatck().size();i++){
			System.out.println("  -->  "+i+" : "+this.getOptStatck().get(i));
		}
		System.out.println("==================LengthExpressionDTO.show()  end ====================");
	}

	
}
