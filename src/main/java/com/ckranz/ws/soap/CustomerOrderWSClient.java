package com.ckranz.ws.soap;

import java.net.MalformedURLException;
import java.net.URL;

import com.bharath.ws.trainings.CustomerOrdersPortType;

public class CustomerOrderWSClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrderWsImplService service = new CustomerOrderWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrderWsImplPort = service.getCustomerOrderWsImplPort();
	}

}
