package idv.zjh.java11;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * <h1>Lambda 參數的本地變量</h1>
 * @author zjh
 *
 */
public class LocalVarDemo {
	
	/**
	 * java 8 特性
	 */
	private static void lambdaInJava8() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("before JAVA8");
			}
		}).start();
		
		new Thread(() -> System.out.println("in Java8")).start();
	}
	
	/**
	 * java 10 特性 局部變量類型腿短
	 */
	private static void lambdaInJava10() {
		int var = 10;//var 是保留類型,int 是關鍵字
		var i = 15465;
		var s = "java";
		var list1 = Arrays.asList("1","22","333");
		var map = Map.of("key1","1","key2","2");
	}
	
	/**
	 * java 10 特性 局部變量類型腿短
	 */
	private static void lambdaInJava1() {
		List<Integer> list1 = Arrays.asList(1,2,3,0);
		list1.sort((Integer s1,Integer s2) ->{
			if(s1.equals(s2)) {
				return 0;
			}else {
				return s1 > s2 ? 1 : -1;
			}
		});
		// java 11 這裡可以使用var可以使用變量
		list1.sort((var s1,var s2) ->{
			if(s1.equals(s2)) {
				return 0;
			}else {
				return s1 > s2 ? 1 : -1;
			}
		});
		
		list1.sort((@NotNull var s1,@NotNull var s2) ->{
			if(s1.equals(s2)) {
				return 0;
			}else {
				return s1 > s2 ? 1 : -1;
			}
		});
	}

	public static void main(String[] args) {


	}

	
	
}