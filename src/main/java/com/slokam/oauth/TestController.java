package com.slokam.oauth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("getData")
	public String getData(){
		return "Hello";
	}
	
	@RequestMapping("sales")
	@GetMapping
	public ResponseEntity<List<SalesData>> getSalesData() {
		System.out.println("getSalesData()");
		List<SalesData> list=new ArrayList<SalesData>();
		SalesData salesData1=new SalesData(1, "IN", "INDIA",5.143 , 80.0);
		SalesData salesData2=new SalesData(2, "BR", "Brazil",4.143 , 70.0);
		SalesData salesData3=new SalesData(3, "CA", "Canada",3.143 , 60.0);
		SalesData salesData4=new SalesData(4, "USA", "America",2.143 , 50.0);
		list.add(salesData1);
		list.add(salesData2);
		list.add(salesData3);
		list.add(salesData4);	
		
		
		return new ResponseEntity<List<SalesData>>(list,HttpStatus.OK);
	}
	
	@RequestMapping("salestostring")
	@GetMapping
	public ResponseEntity<List<String>> getSalesData1() {
		System.out.println("getSalesData()");
		List<String> list=new ArrayList<String>();
		SalesData salesData1=new SalesData(1, "IN", "INDIA",5.143 , 80.0);
		SalesData salesData2=new SalesData(2, "BR", "Brazil",4.143 , 70.0);
		SalesData salesData3=new SalesData(3, "CA", "Canada",3.143 , 60.0);
		SalesData salesData4=new SalesData(4, "USA", "America",2.143 , 50.0);
		list.add(salesData1.toString());
		list.add(salesData2.toString());
		list.add(salesData3.toString());
		list.add(salesData4.toString());	

		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
}

