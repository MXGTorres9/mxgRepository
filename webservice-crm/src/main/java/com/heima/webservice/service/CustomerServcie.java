package com.heima.webservice.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.heima.webservice.domain.Customer;


/**
 * 生产者
 * @author Administrator
 *
 */
@Produces("*/*")	//生产者
public interface CustomerServcie {

	/**
	 * 查询所有客户
	 * @return
	 */
	@GET
	@Path("/customer/queryAll")
	@Produces({ "application/json", "application/xml" })
	public List<Customer> queryAll();
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@GET
	@Path("/customer/queryById/{id}")
	@Produces({"application/xml","application/json"})	// 服务器 回送给客户端数据类型 xml /json
	@Consumes({"application/xml","application/json"})	// 消费者 请求数据类型定义
	public Customer queryById(@PathParam("id")String id);// @PathParam 获取请求路径 参数信息
	
	/**
	 * 条件查询
	 * @param id
	 * @param address
	 * @param telephone
	 * @return
	 */
	@GET
	@Path("/customer/queryByCondition/{id}/{address}/{telephone}")
	@Produces({"application/xml","application/json"})	
	@Consumes({"application/xml","application/json"})
	public List<Customer> queryByCondition(@PathParam("id")String id, @PathParam("address")String address, @PathParam("telephone")String telephone);	
	
	/**
	 * 添加客户
	 * @param c
	 * @return
	 */
	@POST
	@Path("/customer/add")
	@Produces({"application/xml","application/json"})	
	@Consumes({"application/xml","application/json"})
	public Customer add(Customer c);
	
	/**
	 * 更新客户
	 * @param id
	 */
	@PUT
	@Path("/customer/update/{id}/{address}")
	@Consumes({"applcation/xml","application/json"})
	public void update(@PathParam("id")String id,@PathParam("address")String address);
	
	@GET
	@Path("/customer/queryAll2")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	public List<Customer> queryAll2();
}
