package cn.worldyao.test;

import cn.worldyao.entity.LinearList;

public class Test {
	public static void main(String[] args) {
		LinearList linearList = new LinearList();
		linearList.insert("你好");
		System.out.println(linearList.length());
		System.out.println(linearList.isEmpty());
	}
}
