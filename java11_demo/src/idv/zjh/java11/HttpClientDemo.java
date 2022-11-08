package idv.zjh.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * <h1>JPE321 標準http客戶端</h1>
 * 目標：取代HttpURLConnection
 *
 */
public class HttpClientDemo {
	
	/**
	 * 同步 get
	 * @param url
	 * @throws Exception
	 */
	private static void synGet(String url)throws Exception{
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
	}
	
    /**
     * 異步get
     * @param uri
     * @throws Exception
     */
    private static void asyncGet(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(
                URI.create(uri)).build();
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        future.whenComplete((resp,ex)->{
            if (ex!=null){
                ex.printStackTrace();
            }else {
                System.out.println(resp.statusCode());
                System.out.println(resp.body());
            }
        }).join();
    }

    public static void main(String[] args) throws Exception {
//        String uri = "http://t.weather.sojson.com/api/weather/city/101030100";
        String uri = "https://www.google.com";
        // 網址內容
        //{"message":"success感谢又拍云(upyun.com)提供CDN赞助","status":200,"date":"20221108","time":"2022-11-08 11:28:58","cityInfo":{"city":"天津市","citykey":"101030100","parent":"天津","updateTime":"09:16"},"data":{"shidu":"73%","pm25":95.0,"pm10":138.0,"quality":"轻度","wendu":"8","ganmao":"儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼","forecast":[{"date":"08","high":"高温 17℃","low":"低温 5℃","ymd":"2022-11-08","week":"星期二","sunrise":"06:47","sunset":"17:03","aqi":103,"fx":"西南风","fl":"1级","type":"霾","notice":"雾霾来袭，戴好口罩再出门"},{"date":"09","high":"高温 15℃","low":"低温 7℃","ymd":"2022-11-09","week":"星期三","sunrise":"06:48","sunset":"17:02","aqi":117,"fx":"西南风","fl":"1级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"10","high":"高温 17℃","low":"低温 9℃","ymd":"2022-11-10","week":"星期四","sunrise":"06:49","sunset":"17:01","aqi":119,"fx":"东风","fl":"2级","type":"霾","notice":"雾霾来袭，戴好口罩再出门"},{"date":"11","high":"高温 16℃","low":"低温 8℃","ymd":"2022-11-11","week":"星期五","sunrise":"06:50","sunset":"17:00","aqi":70,"fx":"东南风","fl":"2级","type":"大雨","notice":"出门最好穿雨衣，勿挡视线"},{"date":"12","high":"高温 12℃","low":"低温 1℃","ymd":"2022-11-12","week":"星期六","sunrise":"06:51","sunset":"16:59","aqi":12,"fx":"北风","fl":"4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"13","high":"高温 12℃","low":"低温 1℃","ymd":"2022-11-13","week":"星期日","sunrise":"06:52","sunset":"16:59","aqi":28,"fx":"东北风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"14","high":"高温 13℃","low":"低温 3℃","ymd":"2022-11-14","week":"星期一","sunrise":"06:53","sunset":"16:58","aqi":76,"fx":"西南风","fl":"2级","type":"阴","notice":"不要被阴云遮挡住好心情"},{"date":"15","high":"高温 13℃","low":"低温 4℃","ymd":"2022-11-15","week":"星期二","sunrise":"06:54","sunset":"16:57","aqi":78,"fx":"西风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16","high":"高温 13℃","low":"低温 5℃","ymd":"2022-11-16","week":"星期三","sunrise":"06:55","sunset":"16:56","aqi":78,"fx":"西南风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"17","high":"高温 14℃","low":"低温 6℃","ymd":"2022-11-17","week":"星期四","sunrise":"06:57","sunset":"16:55","aqi":95,"fx":"西南风","fl":"2级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"18","high":"高温 12℃","low":"低温 6℃","ymd":"2022-11-18","week":"星期五","sunrise":"06:58","sunset":"16:55","aqi":102,"fx":"西北风","fl":"2级","type":"霾","notice":"雾霾来袭，戴好口罩再出门"},{"date":"19","high":"高温 12℃","low":"低温 6℃","ymd":"2022-11-19","week":"星期六","sunrise":"06:59","sunset":"16:54","aqi":78,"fx":"东北风","fl":"3级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"20","high":"高温 10℃","low":"低温 6℃","ymd":"2022-11-20","week":"星期日","sunrise":"07:00","sunset":"16:53","aqi":49,"fx":"西北风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"21","high":"高温 8℃","low":"低温 6℃","ymd":"2022-11-21","week":"星期一","sunrise":"07:01","sunset":"16:53","aqi":86,"fx":"西北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"22","high":"高温 11℃","low":"低温 6℃","ymd":"2022-11-22","week":"星期二","sunrise":"07:02","sunset":"16:52","aqi":48,"fx":"西风","fl":"3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}],"yesterday":{"date":"07","high":"高温 16℃","low":"低温 7℃","ymd":"2022-11-07","week":"星期一","sunrise":"06:46","sunset":"17:04","aqi":22,"fx":"北风","fl":"3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"}}}
        synGet(uri);
//        asyncGet(uri);
    }
	

}
