package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@CrossOrigin
@RestController
public class MyController 
{
	@Autowired
	CustRepo custRepo;
	
	@PostMapping("add")
	public Customer add(@RequestBody Customer customer)
	{
		try
		{
			Customer cust=custRepo.save(customer);
			return cust;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("read")
	public List<Customer> read()
	{
		List<Customer> cust=custRepo.findAll();
		return cust;
	}
	
	@PutMapping("update/{id}")
	public Customer update(@PathVariable int id, @RequestBody Customer customer)
	{
		try
		{
			Customer cust=custRepo.findById(id).get();
			cust.setName(customer.getName());
			cust.setAddress(customer.getAddress());
			cust.setMobile(customer.getMobile());
			return custRepo.save(cust);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@DeleteMapping("delete{id}")
	public int delete(@PathVariable int id)
	{
		try
		{
			custRepo.deleteById(id);
			return 1;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
