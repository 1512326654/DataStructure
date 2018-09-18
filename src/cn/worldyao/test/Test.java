package cn.worldyao.test;

import cn.worldyao.entity.LinearList;

public class Test implements Runnable{
	public static void main(String[] args) {
		Test test = new Test();
		Thread thread = new Thread(test);
		thread.start();

	}


	@Override
	public void run() {
		LinearList linearList = new LinearList<String>();
		for (int i = 0 ; i < 7 ; i++){
			linearList.insert("你好" + i);
		}
		linearList.traverse();
		System.out.println();
		linearList.insert(0,"索引插入测试");
		linearList.update(5,"你好嘛");
		linearList.traverse();
		System.out.println();
		linearList.delete(5);
		linearList.traverse();
		System.out.println();
		linearList.delete(0);
		linearList.traverse();
		System.out.println();
		linearList.clear();
		linearList.traverse();

	}
}
