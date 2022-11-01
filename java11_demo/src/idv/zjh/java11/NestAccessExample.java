package idv.zjh.java11;

import java.lang.reflect.Field;


/**
 * <h1>JPE181 Nest-Based Access Control</h1>
 * <h2>基於嵌套類（內部類）的私有屬性訪問控制</h2>
 * 網址訪問：https://openjdk.org/projects/jdk/11/
 * 
 * 內部類可以互相訪問私有屬性
 * @author zjh
 *
 */
public class NestAccessExample {
	public static class X {
		void test() throws Exception {
			Y y = new Y();
			y.y = 1;
			Field field = Y.class.getDeclaredField("y");
			field.setAccessible(true);//java 11 之前
			field.setInt(y, 1);
		}
	}

	private static class Y {
		private int y;
	}

	public static void main(String[] args) throws Exception {
		new X().test();
	}
}
