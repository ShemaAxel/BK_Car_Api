package com.example.api.domain;

import java.io.IOException;

import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {
	final String API_KEY = "AIzaSyDUYbTR-3PDWPhgxjENs4yf35g2eHc641s";
	OkHttpClient client = new OkHttpClient();

	public static void main(String[] args) {
		Main m = new Main();
		try {
			System.out.println(m.calculate(41.0259285,-81.5899887,41.0259285,-81.5899887));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String calculate(double depLat,double depLong,double destLat,double dstLong) throws IOException {
		String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+depLat+","+depLong+"&destinations="+destLat+","+depLong+"&key=AIzaSyDUYbTR-3PDWPhgxjENs4yf35g2eHc641s";
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

}
