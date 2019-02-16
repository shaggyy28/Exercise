package com.sagar.exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {
	String ROOT = "/home/sagar/";
	public static void main(String[] args) {
		try {
			
			HttpServer server = HttpServer.create(new InetSocketAddress("192.168.43.50", 9999), 5);
			server.createContext("/", new rootHandler("/"));
			server.createContext("/a", new rootHandler("/a"));
			server.start();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

class rootHandler implements HttpHandler{
	
	private String context;
	String ROOT = "/home/shaggyy28";
	public rootHandler(String context) {
		this.context = context;
	}

	@Override	
	public void handle(HttpExchange exchange) throws IOException{
		InputStream requestBody = exchange.getRequestBody();
		Map<String, List<String>> requestHeaders = exchange.getRequestHeaders();
		String requestMethod = exchange.getRequestMethod();
		URI contextPath = exchange.getRequestURI();
//		System.out.println(requestHeaders);
		System.out.println(this.context);
		
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(String.format("%s%s", ROOT, contextPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Headers responseHeaders = exchange.getResponseHeaders();
		List<String> contentType = new ArrayList<>();
		contentType.add("text/html");
		responseHeaders.put("Content-type", contentType);
		try {
			exchange.sendResponseHeaders(200, inputStream.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream responseBody = exchange.getResponseBody();
		int cha;
		while((cha = inputStream.read()) != -1) {
			responseBody.write(cha);
		}
		responseBody.close();
	}

	
	
}
