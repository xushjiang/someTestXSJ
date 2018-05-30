package test.test;

import java.net.URI;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RequestAndResponse {

	/**
	 * 发送请求并返回数据
	 * 
	 * @param url
	 * @throws Exception
	 */
	public static void sendRequestAndResponse(String url, BasicCookieStore cookieStore) throws Exception {

		CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

		HttpGet httpget = new HttpGet(url);

		System.out.println("Executing request " + httpget.getRequestLine());

		CloseableHttpResponse response = client.execute(httpget);

		System.out.println(response.getStatusLine());
		System.out.println(EntityUtils.toString(response.getEntity()));

		response.close();
		client.close();
	}

	public static BasicCookieStore login() throws Exception {

		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

		HttpUriRequest login = RequestBuilder.post()
				.setUri(new URI("http://192.168.1.236:8080/dhyt/webclient/newLogin")).addParameter("loginid", "12311")
				.addParameter("password", "96e79218965eb72c92a549dd5a330112").build();

		CloseableHttpResponse response2 = httpclient.execute(login);

		List<Cookie> cookies = cookieStore.getCookies();
		if (cookies.isEmpty()) {
			System.out.println("None");
		} else {
			return cookieStore;
//			for (int i = 0; i < cookies.size(); i++) {
//				System.out.println("- " + cookies.get(i).toString());
//			}
		}

		response2.close();
		httpclient.close();

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BasicCookieStore cookieStore = login();
			sendRequestAndResponse("http://192.168.1.236:8080/dhyt/api/jintai/getJtCheckLists?check_type_id=1",
					cookieStore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
