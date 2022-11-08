package idv.zjh.java11;

import java.util.concurrent.TimeUnit;

/**
 * <h1>JPE315 改進 Aarch64 函數</h1>
 * 改進在64位元上sin、cos、log的計算效率
 *
 */
public class Aarch64Example {
	
	public static void mathOnJdk11() {
		long startTime = System.nanoTime();
		for (int i = 0;i<10000000;++i) {
			Math.sin(i);
			Math.cos(i);
			Math.log(i);
		}
		long endTime = System.nanoTime();
		System.out.println(TimeUnit.MILLISECONDS.toMillis(endTime-startTime)+"");
		//時間顯示
		//java8 	991184100	
		//java11	889397900
	}

	public static void main(String[] args) {
		mathOnJdk11();
	}

}
