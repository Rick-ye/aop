package com.aoplog;

import com.annotation.LogInfo;

public class AServiceimpl implements AService {
	
	@LogInfo(desc="Rick")
	public void cool() {
		System.out.println("你好！");		
	}

}
