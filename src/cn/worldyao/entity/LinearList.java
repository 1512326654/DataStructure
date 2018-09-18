package cn.worldyao.entity;

/**
 * @author worldyao
 *
 * 线性表
 */
public class LinearList {

	/**
	 * DEFAULT_LIST_SIZE    默认长度
	 * size                 长度
	 * objects              存储对象
	 */
	private final int DEFAULT_LIST_SIZE = 10;
	private int size;
	private Object[] objects;

	public LinearList(){
		this.size = 0;
		objects = new Object[DEFAULT_LIST_SIZE];
	}

	public LinearList(int size){
		this.size = 0;
		objects = new Object[size];
	}

	public void insert(Object object){
		objects[size] = object;
		size ++;
	}

	public int length(){
		return size;
	}
	public boolean isEmpty(){
		return (size == 0) ? true : false;
	}

}
