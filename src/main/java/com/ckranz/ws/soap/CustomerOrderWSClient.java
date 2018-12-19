package com.ckranz.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;

public class CustomerOrderWSClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrderWsImplService service = new CustomerOrderWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrderWsImplPort = service.getCustomerOrderWsImplPort();
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrderWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println("Anzahl der Bestellungen für den Kunden: " + orders.size());
	}

}
