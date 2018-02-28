package org.ihsusta.server.webservice.impl;

import org.ihsusta.server.service.IndexService;
import org.ihsusta.server.webservice.WebServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "org.ihsusta.server.webservice.WebServer", // webservice接口类 名称
        serviceName = "webServerService", // 自定义 serviceName
        portName = "webServerPort", // 自定义 portName
        targetNamespace = "http://webservice.server.ihsusta.org/") // 自定义 namespace
@Component("webServerImpl") // 增加注解 注入spring容器中
public class WebServerImpl implements WebServer {
    private static final Logger logger = LoggerFactory.getLogger(WebServerImpl.class);

    @Resource
    private IndexService service;  // add service
    @Resource
    private WebServiceContext webServiceContext;

    public String saySomething(String name) {
        service.hello(name); // call service hello method
        logger.info("【saySomething】 接口被调用，访问IP:【" + getClientIp() + "】," +
                "参数:【name=" + name + "】");
        return "Hello " + name + "!";
    }

    // 获取客户端访问ip
    private String getClientIp() {
        String clientIP = null;
        try {
            MessageContext mc = webServiceContext.getMessageContext();
            HttpServletRequest request = (HttpServletRequest) (mc.get(MessageContext.SERVLET_REQUEST));
            clientIP = request.getRemoteAddr();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientIP;
    }
}
