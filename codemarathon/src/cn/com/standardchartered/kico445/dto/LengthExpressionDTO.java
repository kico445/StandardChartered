package cn.com.standardchartered.kico445.dto;

import java.util.ArrayList;
import java.util.List;

import cn.com.standardchartered.kico445.uitls.LengthUnitDataUtils;

public class LengthExpressionDTO {
	private List<LengthDTO> lengthUnitStack = new ArrayList<LengthDTO>();
	private List<String> optStatck = new ArrayList<String>();
	
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
	
	public void parseTxt2Expression(String txtExpression){
		int firstOptIndex = 0;
		LengthDTO lenghtDto = null;
		String opt = "";
		if(LengthUnitDataUtils.beLengthExpressionTxt(txtExpression)){
			while (!"".equals(txtExpression)){
				lenghtDto = null;
				firstOptIndex = LengthUnitDataUtils.getFirstOptIndex(txtExpression);
				if(firstOptIndex>0){
					lenghtDto = new LengthDTO();
					lenghtDto.parseTxt2DTO(txtExpression.substring(0,firstOptIndex).trim());
					System.out.println("====  txt : "+txtExpression);
					lengthUnitStack.add(lenghtDto.unitConvert("m"));
					opt = txtExpression.substring(firstOptIndex,firstOptIndex+1);
					optStatck.add(opt);
					txtExpression = txtExpression.substring(firstOptIndex+1).trim();
					System.out.println("====  txt : "+txtExpression);
				}else if (firstOptIndex==0){
					lenghtDto = new LengthDTO();
					lenghtDto.parseTxt2DTO(txtExpression.substring(0).trim());
					System.out.println("====  txt : "+txtExpression);
					lengthUnitStack.add(lenghtDto.unitConvert("m"));
					txtExpression = "";
				}
			}
			
		}
	}
	
	public LengthDTO calculate(){
		
		return new LengthDTO();
	}


	public void show(){
		System.out.println("==================LengthExpressionDTO.show()====================");
		System.out.println("==================lengthUnitStack : ");
		for(int i=0;i<this.getLengthUnitStack().size();i++){
			System.out.println("  -->  "+i+" : "+this.getLengthUnitStack().get(i));
		}
		System.out.println("==================optStack : ");
		for(int i=0;i<this.getOptStatck().size();i++){
			System.out.println("  -->  "+i+" : "+this.getOptStatck().get(i));
		}
		System.out.println("==================LengthExpressionDTO.show()====================");
	}



	
}
