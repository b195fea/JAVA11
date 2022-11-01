package idv.zjh.java11;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * <h1>JPE309 增加一個常量類型 - constant_Dynamic</h1>
 * 降低開發新型式的可實現類文件的約束帶來的成本和干擾
 * @author zjh
 * 
 * class 文件結構
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html
 * java11 新增的常量，設定在cp_info 裡面
 * 
 * 常量池標記
 * Constant Kind		        Tag	class file format	Java SE
 * CONSTANT_Utf8		        1	45.3	            1.0.2
 * CONSTANT_Integer		        3	45.3	            1.0.2
 * CONSTANT_Float		        4	45.3	            1.0.2
 * CONSTANT_Long		        5	45.3	            1.0.2
 * CONSTANT_Double		        6	45.3	            1.0.2
 * CONSTANT_Class		        7	45.3	            1.0.2
 * CONSTANT_String		        8	45.3	            1.0.2
 * CONSTANT_Fieldref	        9	45.3	            1.0.2
 * CONSTANT_Methodref	        10	45.3	            1.0.2
 * CONSTANT_InterfaceMethodref	11	45.3	            1.0.2
 * CONSTANT_NameAndType			12	45.3	            1.0.2
 * CONSTANT_MethodHandle		15	51.0	            7	   	（JAVA7 新增）
 * CONSTANT_MethodType			16	51.0	            7	   	（JAVA7 新增）
 * CONSTANT_Dynamic				17	55.0	            11		（JAVA11 新增）
 * CONSTANT_InvokeDynamic		18	51.0	            7		（JAVA7 新增）
 * CONSTANT_Module				19	53.0	            9		（JAVA9 新增）
 * CONSTANT_Package				20	53.0	            9		（JAVA7 新增）
 * 
 * javap -verbose DynamicTest.class 查看本地 class 文件
 * #13 = NameAndType 就是上述的一種常量池標記
 * 
 * NameAndType
 * Constant pool:
 *    #1 = Class              #2             // idv/zjh/java11/DynamicTest
 *    #2 = Utf8               idv/zjh/java11/DynamicTest
 *    #3 = Class              #4             // java/lang/Object
 *    #4 = Utf8               java/lang/Object
 *    #5 = Utf8               say
 *    #6 = Utf8               Ljava/lang/String;
 *    #7 = Utf8               <clinit>
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = String             #11            // hello
 *   #11 = Utf8               hello
 *   #12 = Fieldref           #1.#13         // idv/zjh/java11/DynamicTest.say:Ljava/lang/String;
 *   #13 = NameAndType        #5:#6          // say:Ljava/lang/String;
 * 
 * ClassFile 完整目錄結構（補充）
 * ClassFile {
 *     u4             magic;								魔術（分辨是否為java class 文件）
 *     u2             minor_version;						java 文件版本號			
 *     u2             major_version;
 *     u2             constant_pool_count;
 *     cp_info        constant_pool[constant_pool_count-1]; 常量池
 *     u2             access_flags;
 *     u2             this_class;
 *     u2             super_class;
 *     u2             interfaces_count;
 *     u2             interfaces[interfaces_count];
 *     u2             fields_count;
 *     field_info     fields[fields_count];
 *     u2             methods_count;
 *     method_info    methods[methods_count];
 *     u2             attributes_count;
 *     attribute_info attributes[attributes_count];
 * }
 * 
 * 常量池標記結構
 * cp_info {
 *     u1 tag;
 *     u1 info[];
 * }
 * 
 *
 */
public class DynamicTest {
	
	public static String say = "hello";

	public static void main(String[] args) throws Throwable {
		// Java 7 讀取靜態方法
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle mh = lookup.findStatic(DynamicTest.class, "test", MethodType.methodType(void.class));
		mh.invokeExact();
	}
	
	private static void test() {
		System.out.println("say");
	}

}
