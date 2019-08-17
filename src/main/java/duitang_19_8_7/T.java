package duitang_19_8_7;

import java.util.Date;

/**
 * @ClassName T
 * @Description 演示 泛型擦除引发的冲突。
 * @Author Numblgw
 * @Date 2019/8/8 8:41
 */
public class T<E> {

	E e;

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}
}

/**
 * 下面的方法会被判定为重写，而不是重载。
 */
class TT extends T<Date> {

	@Override
	public Date getE() {
		return this.e;
	}

	@Override
	public void setE(Date date) {

	}
}
