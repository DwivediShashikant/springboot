/*
 *
 * 
 */

package com.staxrt.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "requestdetails")
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "content", nullable = false)
	private String content;
	@Column(name = "requestName", nullable = false)
	private String requestName;
	@Column(name = "approvalRequired", nullable = false)
	private boolean approvalRequired;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "User [id=" + id + ", title=" + title + ", content=" + content + ", requestName=" + requestName
				+ ", approvalRequired=" + approvalRequired + "]";
	}

}
