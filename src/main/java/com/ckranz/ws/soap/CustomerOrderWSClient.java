package com.ckranz.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

public class CustomerOrderWSClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrderWsImplService service = new CustomerOrderWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrderWsImplPort = service.getCustomerOrderWsImplPort();
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrderWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println("Anzahl der Bestellungen für den Kunden: " + orders.size());
		
		
		
		CreateOrdersRequest requestCreate = new CreateOrdersRequest();
		requestCreate.setCustomerId(BigInteger.valueOf(1));	
		
		Product p = new Product();
		p.setId("Iphone");
		p.setQuantity(BigInteger.valueOf(3));
		p.setDescription("Bla");
		Order orderCreate = new Order();
		orderCreate.setId(BigInteger.valueOf(2));
		orderCreate.getProduct().add(p);
		
		CreateOrdersResponse responseCreate = customerOrderWsImplPort.createOrders(requestCreate);
		boolean result = responseCreate.isResult();
		System.out.println(result);
		
//		GetOrdersRequest request1 = new GetOrdersRequest();
//		request.setCustomerId(BigInteger.valueOf(1));
//		GetOrdersResponse response1 = customerOrderWsImplPort.getOrders(request1);
//		List<Order> orders1 = response1.getOrder();
//		System.out.println("Anzahl der Bestellungen für den Kunden: " + orders1.size());
		
		
		
	}

}
