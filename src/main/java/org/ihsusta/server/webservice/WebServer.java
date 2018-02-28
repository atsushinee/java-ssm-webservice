package org.ihsusta.server.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebServer {
    @WebMethod(operationName = "saySomething") //表明这是一个发布出webservice方法，方法名为设置的operationName
    String saySomething(@WebParam(name = "name") String name);
}
