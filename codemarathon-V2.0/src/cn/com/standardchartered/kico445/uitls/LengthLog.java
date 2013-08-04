package cn.com.standardchartered.kico445.uitls;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class LengthLog {

	private static String baseLogPath = LengthLog.class.getResource("/").toString().replace("file:/", "");

	public LengthLog() {
	}
	
	/**
	 * 记录输出结果，定向输出至 output.txt
	 * @param strMsg
	 */
	public static void output(String strMsg) {
		tranLog(strMsg,"outputFileName");
	}
	
	/**
	 * 记录运行日志，定向输出至 log.log
	 * @param strMsg
	 */
	public static void log(String strMsg) {
		tranLog(strMsg,"logFileName");
	}
	
	/**
	 * 记录错误日志，定向输出至error.log
	 * @param strMsg
	 */
	public static void error(String strMsg) {
		tranLog(strMsg,"errorFileName");
	}
	
	/**
	 * 记录输出内容至指定文件
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
				System.out.println(timeStamp+" 输出内容记录到文件出现问题 ");
				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println(timeStamp+" 文件输入流关闭时出现问题 ");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 获取当前时间戳 年月日时分秒，方便日志记录
	 * @return
	 */
	public static String getTimeStamp(){
		String timeStamp = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		timeStamp = "["+simpleDateFormat.format(new java.util.Date())+"] : ";
		return timeStamp;
	}

}
