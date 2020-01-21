package com.icook._00_init;

public class test {
	private static String hexString = "0123456789ABCDEF"; //此處不可隨意改動
	public static String encode(String str) {
		   // 根據預設編碼獲取位元組陣列
		   byte[] bytes = str.getBytes();
		   StringBuilder sb = new StringBuilder(bytes.length * 2);
		   // 將位元組陣列中每個位元組拆解成2位16進位制整數
		   for (int i = 0; i < bytes.length; i++) {
		    sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
		    sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
		   }
		   return sb.toString();
		}
	public static void main(String[] args) {
		String theString = "雞肉";
		String HexString = encode(theString);
		String queryVariable="";
        for(int i=0;i<HexString.length();i+=2) {
        	queryVariable += "%"+HexString.substring(i,i+2);
        	System.out.println(queryVariable);
        }
	}

}
