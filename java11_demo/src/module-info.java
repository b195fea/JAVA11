module java11_demo {
//	requires java.net.http;//需要java.net.http
	exports idv.zjh.java11;//其他系統可以引用java11
	requires transitive java.net.http;//需要java.net.http
}