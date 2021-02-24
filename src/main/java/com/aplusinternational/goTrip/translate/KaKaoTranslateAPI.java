package com.aplusinternational.goTrip.translate;

import java.net.URLEncoder;

public class KaKaoTranslateAPI {
	
	private final static String apiKey = "dfd";

	public void KakaoTranslateAPI() {
		try {
			String text = URLEncoder.encode("도연", "UTF-8");
			String postParams = "src_lang=kr&target__lang=en&query="+text;
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
