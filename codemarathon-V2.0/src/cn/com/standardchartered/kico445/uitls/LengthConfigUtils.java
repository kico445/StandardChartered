package cn.com.standardchartered.kico445.uitls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class LengthConfigUtils {
	
	
	/**
	 * ���������ļ��е�����ֵ
	 * @param propertyName
	 * @return
	 */
	public static String getProperty(String propertyName) {
	    String property = "";
	    Properties props = new Properties();
        InputStream inStream = null;
	    if (null != propertyName){
	        try {
	            inStream = LengthConfigUtils.class.getResourceAsStream("/lengthUnitConfig.properties");
	            props.load(inStream);
	            property = props.getProperty(propertyName);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (inStream != null) {
	                    inStream.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return property;
	}
	
	/**
	 * ���س��ȵ�λ������ӳ��
	 * @param units4Unit
	 */
	public static void loadUnits4unit(Map<String,String> units4Unit){
		String[] arrUnits4unit = getProperty("units4Unit").split("#");
		for(int i=0;i<arrUnits4unit.length;i++){
			units4Unit.put(arrUnits4unit[i].split("-")[0], arrUnits4unit[i].split("-")[1]);
		}
	}

}
