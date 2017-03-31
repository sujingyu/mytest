package http;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

public class HttpClient {

	public static void main(String[] args) throws Exception {
		AsyncHttpClient client = new AsyncHttpClient();
		Future<Response> f = client.prepareGet("https://www.baidu.com").execute();
		Response r = f.get();
		
		
	}
}
