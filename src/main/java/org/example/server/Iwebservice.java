package org.example.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "Login",
serviceName = "Iwebservice", 
targetNamespace = "http://org.example.server"
)
public interface Iwebservice {
	@WebMethod
	String sayHello(@WebParam(name="user") User name);
	@WebMethod
	String say(@WebParam(name="user") User  name);
}
