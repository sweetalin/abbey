package com.ljl.study.test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/** 
* @author alin 
* @version 2017年6月10日
* 类说明 
*/
public class SendUrl {
	/** 
	 * 不行啊，测试不通
     */  
    public static void main(String[] args) throws Exception {  
        URL url = new URL("http://localhost:8080/task2/a/u/stu");  
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();  
        urlConn.setConnectTimeout(10*1000); // 单位是毫秒  
        urlConn.setRequestMethod("GET");  
        InputStream inStrm = urlConn.getInputStream(); // <=== 注意，实际发送请求的代码段就在这里，这句代码比 urlConn.connect() 好用，connect 压根不会发送请求出去，所以这句话一定要写  
        inStrm.close();  
        urlConn.disconnect();  
    }  
}
