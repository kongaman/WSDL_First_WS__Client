package com.ckranz.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;

public class CustomerOrderWSClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrderWsImplService service = new CustomerOrderWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrderWsImplPort = service.getCustomerOrderWsImplPort();
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrderWsImplPort.getOrders(request);
	}

}
