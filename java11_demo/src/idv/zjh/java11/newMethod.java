package idv.zjh.java11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class newMethod {

	public static void StringDemo() {
		System.out.println(" hello, jkd11\u3000");
		System.out.println(" hello, jkd11\u3000".trim());//刪除前後空白符
		System.out.println(" hello, jkd11\u3000".strip());//刪除字符串頭尾空白符（含unicode）
		System.out.println(" hello, jkd11\u3000".stripLeading());//刪除頭部空白符號（含unicode）
		System.out.println(" hello, jkd11\u3000".stripTrailing());//刪除尾部空白符號（含unicode）
		System.out.println("-------------------------");
		
		System.out.println("\u3000".isEmpty());//判斷是否空白
		System.out.println("\u3000".isBlank());//判斷是否空白（含unicode）
		
		System.out.println("-------------------------");
		// line
		String lines = "hello\nworld\njdk11";
		lines.lines().forEach(System.out::println);
		//
		System.out.println("-*".repeat(50));//重複50次
		
	}
	
	public static void FileDemo() {
		String path = "C:/tmp/jdk11__new_fewture.text";
		try {
			Files.writeString(Path.of(path), "jdk11 new feature", StandardCharsets.UTF_8);
			System.out.println(Files.readString(Path.of(path)));
			Files.delete(Path.of(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ListDemo() {
		List<String> list = List.of("java8","java11","java12");
		System.out.println(list);
		//舊方法
		String[] oldway = list.toArray(new String[0]);
		//新方法
		String[] newway = list.toArray(String[]::new);
	}
	
	public static void main(String[] args) {
		ListDemo();
//		FileDemo();
//		StringDemo();
		// TODO Auto-generated method stub
//		strip()
//		isBlank 空或僅包含空格
//		line() 返回一個流Stream，
//		stripLeading 刪除頭部字串
//		stripRealing 刪除尾部字串
		
//		File
//		readStriing
		
//		List
		
		
	}

}
