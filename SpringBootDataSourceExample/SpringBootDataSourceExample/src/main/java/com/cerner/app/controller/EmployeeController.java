
package com.cerner.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cerner.app.model.Employe;
import com.cerner.app.repository.EmployeDAO;

// URL: http://localhost:8080/cerner/getempinfoInfo?title=RCM&content=Software Intern
@RestController
public class EmployeeController {
	@Autowired
	public EmployeDAO dao;
	@CrossOrigin(origins = "http://localhost:4200")
	
	@RequestMapping(value = "/getempinfoInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Employe> fullInfo(String teamName, String role) {
		List<Employe> customers;
		try {
			customers = dao.getData(teamName, role);
		} catch (Exception e) {
			customers = new ArrayList<Employe>();
			e.printStackTrace();
		}

		return customers;
	}
}
