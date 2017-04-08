package com.cxf.ws.interceptor;

import java.util.List;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	public AuthInterceptor() {
		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		System.out.println("msg:"+msg);
		
		List<Header> headers = msg.getHeaders();
		if(CollectionUtils.isEmpty(headers)){
			throw new Fault(new IllegalArgumentException("没有header信息，不能调用"));
		}
		
		Header firstHeader  = headers.get(0);
		Element e = (Element) firstHeader.getObject();
		
		NodeList nodeIds = e.getElementsByTagName("userId");
		NodeList nodePasses = e.getElementsByTagName("userPass");
		
		if(nodeIds.getLength() != 1){
			throw new Fault(new IllegalArgumentException("用户名格式不对"));
		}
		
		if(nodePasses.getLength() != 1){
			throw new Fault(new IllegalArgumentException("密码格式不对"));
		}
		
		String userId = nodeIds.item(0).getTextContent();
		String userPass = nodePasses.item(0).getTextContent();
		System.out.println("userId:"+userId);
		System.out.println("userPass:"+userPass);
		if(!"ABC".equals(userId) || !"123".equals(userPass)){
			throw new Fault(new IllegalArgumentException("用户名或者密码不正确"));
		}
	}
}
