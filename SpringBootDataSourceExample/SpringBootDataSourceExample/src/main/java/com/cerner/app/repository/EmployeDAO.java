

package com.cerner.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cerner.app.model.Employe;
import com.cerner.tableconstants.TableConstants;

@Repository
public class EmployeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Employe> getData(String teamName, String role) {
		final String SQL = "select * from " + TableConstants.EMPLOYEE_DETAILS + " where Team_Name ='" + teamName
			+ "' and Role ='" + role + "'";
		
		List<Employe> customers = new ArrayList<Employe>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);
		for (Map<String, Object> row : rows) {
			Employe employee = new Employe();
			employee.setRequestName((String) row.get("Request_Name"));
			employee.setApprovalRequired((boolean) row.get("Approval_Required"));
			customers.add(employee);
		}

		return customers;

	}
}