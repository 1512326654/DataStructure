package cn.worldyao.entity;

/**
 * @author worldyao
 * <p>
 * 线性表
 */
public class LinearList<E> {

	/**
	 * DEFAULT_LIST_SIZE    默认长度
	 * size                 设定长度
	 * currentSize          元素长度
	 * objects              存储对象
	 * DEFAULT_LIST_LOAD    默认负载因子
	 * load                 设定负载因子
	 */
	private final static int DEFAULT_LIST_SIZE = 10;
	private int size;
	private int currentSize;
	private E[] objects;
	private final static float DEFAULT_LIST_LOAD = 0.75f;
	private float load;

	public LinearList() {
		this(DEFAULT_LIST_SIZE, DEFAULT_LIST_LOAD);
	}

	public LinearList(int size) {
		this(size, DEFAULT_LIST_LOAD);
	}

	public LinearList(int size, float load) {
		this.currentSize = 0;
		this.size = size;
		this.objects = (E[]) new Object[this.size];
		this.load = load;
	}


	/**
	 * 返回表L的长度，即表中元素个数
	 *
	 * @return
	 */
	public int length() {
		return size;
	}

	/**
	 * 函数值为L中位置i处的元素（1≤i≤n）
	 *
	 * @param index
	 * @return
	 */
	public E get(int index) {
		try {
			if (index < 0) {
				throw new Exception("不允许的下标");
			}
			if (index > (size - 1)) {
				throw new Exception("下标越界");
			}
		} catch (Exception e) {
			System.err.println(e.fillInStackTrace());
			System.exit(0);
		}
		return objects[index];
	}

	/**
	 * 取index的前驱元素
	 *
	 * @param index
	 * @return
	 */
	public E prior(int index) {
		return get(index - 1);
	}

	/**
	 * 取index的后继元素
	 *
	 * @param index
	 * @return
	 */
	public E next(int index) {
		return get(index + 1);
	}

	/**
	 * 在表L的位置i处插入元素x，将原占据位置i的元素及后面的元素都向后推一个位置
	 *
	 * @param e
	 */
	public void insert(E e) {
		insert(0, e);
	}

	public void insert(int index, E e) {
		if (size == 0) {
			objects[0] = e;
			currentSize++;
		} else {
			/**
			 * 如果添加的元素到达临界值
			 * 扩增到以前的2倍
			 * 并且将以前的元素复制到新的数组
			 */
			if (((float) currentSize / (float) size) > load) {
				size = 2 * size;
				E[] newLinearList = (E[]) new Object[size];
				for (int i = 0; i < (size / 2); i++) {
					newLinearList[i] = objects[i];
				}
				objects = newLinearList;
			}
			try {
				if (index < 0 || index > currentSize) {
					throw new Exception("下标不允许");
				} else {
					currentSize++;
					/**
					 * 指定索引插入，该索引后边的元素向后移动一位
					 */
					for (int i = (currentSize - 1); i > index; i--) {
						objects[i] = objects[i - 1];
					}
					objects[index] = e;
				}
			} catch (Exception ex) {
				System.err.println(ex);
				System.exit(0);
			}
		}
	}

	/**
	 * 从表L中删除位置p处的元素
	 * @param index
	 */
	public void delete(int index){
		try {
			if (index < 0 || index > currentSize) {
				throw new Exception("下标不允许");
			} else {
				/**
				 * 指定索引插入，该索引后边的元素向后移动一位
				 */
				for (int i = index ; i < currentSize ; i++) {
					objects[i] = objects[i + 1];
				}
				currentSize --;
			}
		} catch (Exception ex) {
			System.err.println(ex);
			System.exit(0);
		}
	}

	/**
	 * 如果表L为空表(长度为0)则返回true，否则返回false
	 *
	 * @return
	 */
	public boolean isEmpty() {
		return (currentSize == 0) ? true : false;
	}

	/**
	 * 清除所有元素
	 */
	public void clear(){
		currentSize = 0;
	}

	/**
	 * 遍历输出所有元素
	 */
	public void traverse() {
		for (int i = 0; i < currentSize; i++) {
			System.out.println(objects[i]);
		}
	}

	/**
	 * 查找并返回元素
	 * @return
	 */
	public E find(){
		return null;
	}

	/**
	 * 修改元素
	 * @return
	 */
	public void update(int index , E e){
		try {
			if (index < 0 || index > currentSize) {
				throw new Exception("下标不允许");
			} else {
				objects[index] = e;
			}
		} catch (Exception ex) {
			System.err.println(ex);
			System.exit(0);
		}
	}
}
