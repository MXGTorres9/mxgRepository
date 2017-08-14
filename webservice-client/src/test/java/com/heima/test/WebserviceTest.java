package com.heima.test;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import com.heima.test.domain.Customer;

@SuppressWarnings("all")
public class WebserviceTest {

	private String url = BaseInterface.CRM_BASE_URL; 
	
	@Test
	public void tesst1(){
		
		List<Customer> customers = (List<Customer>) WebClient.create(url + "queryAll")
				.accept(MediaType.APPLICATION_JSON).getCollection(Customer.class);
		System.out.println(customers);
	}
	
	@Test
	public void test2(){
		Customer customer = (Customer) WebClient.create(url + "queryById/" + 6)
		.accept(MediaType.APPLICATION_JSON).get(Customer.class);
		System.out.println(customer);
		
	}
	
	@Test
	public void test3(){
		Customer c = new Customer();
		c.setName("范冰冰");
		c.setAddress("北京");
		c.setTelephone("13622221111");
		Response post = WebClient.create(url + "add").accept(MediaType.APPLICATION_JSON).post(c);
		Customer customer = post.readEntity(Customer.class);
		System.out.println(customer);
	}
	
	@Test
	public void test4(){
		
		WebClient.create(url + "update/" + 6 + "/"+ "北京").accept(MediaType.APPLICATION_JSON).put(null);
		
	}
}
