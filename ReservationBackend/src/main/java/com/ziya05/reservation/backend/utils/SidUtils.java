package com.ziya05.reservation.backend.utils;

import org.n3r.idworker.Sid;

public class SidUtils {

	public static void main(String[] args) {
		Sid sid = new Sid();
		
		for(int i = 0; i < 15; i++) {
			System.out.println("生成相关id为： " + sid.nextShort());
		}
		
	}

}
