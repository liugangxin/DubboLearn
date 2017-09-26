package com.liu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
* @author liugangxin:
* @version 创建时间：2017年9月18日 下午7:52:55
*/
public class TestLiu {

	public static void main(String[] args) {
		LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String format = of.format(formatter);
		System.out.println(format);
		LocalDate plusDays = LocalDate.now().plusDays(1L);
		LocalDateTime plusDays2 = LocalDateTime.of(plusDays, LocalTime.now());;
		System.out.println(plusDays2.format(formatter));
	}
}
