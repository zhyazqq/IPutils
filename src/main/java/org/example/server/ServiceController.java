package org.example.server;

import javax.xml.ws.Endpoint;

public class ServiceController {
	public static void main(String[] args) {
		String urlString = "http://localhost:9999/demo?wsdl";
		Endpoint.publish(urlString, new WebServiceImpl());
		System.out.println("success");
	}
}
