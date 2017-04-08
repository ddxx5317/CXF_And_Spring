package com.cxf.ws.utils;

import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;

import com.cxf.ws.interceptor.AuthInterceptor;
import com.ws.cxf.impl.HelloWordImpl;


public class ServerMain {

	public static void main(String[] args) {
		//Endpoint.publish("http://127.0.0.1:12345/sayHi", new HelloWordImpl());
		
		
		EndpointImpl dp = (EndpointImpl) Endpoint.publish("http://127.0.0.1:12345/getCatsByUser", new HelloWordImpl());
		//��ӷ�������in��out������
		dp.getInInterceptors().add(new AuthInterceptor());
		
		System.out.println("����webService�ɹ���");

	}

}
 