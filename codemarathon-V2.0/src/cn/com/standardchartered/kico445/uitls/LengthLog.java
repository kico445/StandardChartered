package cn.com.standardchartered.kico445.uitls;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class LengthLog {

	private static String baseLogPath = LengthLog.class.getResource("/").toString().replace("file:/", "");

	public LengthLog() {
	}
	
	/**
	 * ��¼����������������� output.txt
	 * @param strMsg
	 */
	public static void output(String strMsg) {
		tranLog(strMsg,"outputFileName");
	}
	
	/**
	 * ��¼������־����������� log.log
	 * @param strMsg
	 */
	public static void log(String strMsg) {
		tranLog(strMsg,"logFileName");
	}
	
	/**
	 * ��¼������־�����������error.log
	 * @param strMsg
	 */
	public static void error(String strMsg) {
		tranLog(strMsg,"errorFileName");
	}
	
	/**
	 * ��¼���������ָ���ļ�
	 * @param strMsg
	 * @param logFileName
	 */
	private static void tranLog(String strMsg,String logFileName) {
		FileWriter writer = null;
		String timeStamp = "";
		try {

			String fileName = LengthConfigUtils.getProperty(logFileName);
			String fullFileName = baseLogPath + fileName ;
			writer = new FileWriter(fullFileName, true);
			timeStamp = getTimeStamp();
			if("outputFileName".equals(logFileName)){
				timeStamp = "";
			}
			writer.write(timeStamp + strMsg + "\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				writer.flush();
			} catch (IOException e) {
				System.out.println(timeStamp+" ������ݼ�¼���ļ��������� ");
				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println(timeStamp+" �ļ��������ر�ʱ�������� ");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ȡ��ǰʱ��� ������ʱ���룬������־��¼
	 * @return
	 */
	public static String getTimeStamp(){
		String timeStamp = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		timeStamp = "["+simpleDateFormat.format(new java.util.Date())+"] : ";
		return timeStamp;
	}

}
