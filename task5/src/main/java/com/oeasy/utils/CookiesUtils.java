package com.oeasy.utils;

import org.apache.commons.net.util.Base64;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public class CookiesUtils {
	public static void encrypt(){
		
	}
	public static Long decrypt(String token) throws Exception{
		byte[] tk1 = Base64.decodeBase64(token);
        byte[] tk2 = DESUtil.decrypt(tk1, "12345678");
        String tk = new String(tk2);
        System.out.println(" 解密后的 token-->" + tk);
        String id = "";
        String createTime = "";
        for (int i = 0; i < tk.length(); i++) {
        	/*检索特定索引下字符的 String 实例的方法.charAt() 
        	方法返回指定索引位置的 char 值。索引范围为 0~length()-1*/
            char c = tk.charAt(i);
            if (c == '=') {
                for (int j = i + 1; j < tk.length(); j++) {
                    createTime = createTime + tk.charAt(j);
                }
                break;
            }
            id = id + c;
        }
        return Long.parseLong(id);
	}
}
