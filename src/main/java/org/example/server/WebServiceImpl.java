package org.example.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "org.example.server.Iwebservice",
name = "Login",
serviceName = "Iwebservice", 
targetNamespace = "http://http://org.example.server"

)
public class WebServiceImpl implements Iwebservice {
	@WebMethod
	public String sayHello(@WebParam(name="user") User name) {
		
		System.out.println(name);
		return "方法二"+name;
	}
	@WebMethod
	@Override
	public String say(@WebParam(name="user")  User  name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		return "方法一"+name;
	}

}
