
package com.cerner.app.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.cerner.app.responseconstants.BaseResponse;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class Employe extends BaseResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "Team_Name", nullable = false)
	private String teamName;
	@Column(name = "Role", nullable = false)
	private String role;
	@Column(name = "Request_Name", nullable = false)
	private String requestName;
	@Column(name = "Approval_Required", nullable = false)
	private boolean approvalRequired;

	public Employe() {
	}

	public Employe(long id, String title, String content, String requestName, boolean approvalRequired) {
		super();
		this.id = id;
		this.teamName = title;
		this.role = content;
		this.requestName = requestName;
		this.approvalRequired = approvalRequired;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return teamName;
	}

	public void setTitle(String title) {
		this.teamName = title;
	}

	public String getContent() {
		return role;
	}

	public void setContent(String content) {
		this.role = content;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public boolean isApprovalRequired() {
		return approvalRequired;
	}

	public void setApprovalRequired(boolean approvalRequired) {
		this.approvalRequired = approvalRequired;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + teamName + ", content=" + role + ", requestName=" + requestName
				+ ", approvalRequired=" + approvalRequired + "]";
	}

}
