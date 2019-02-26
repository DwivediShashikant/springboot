package co.cerner.app.responseconstants;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BaseResponse {

	private String statusMessage;
	private int statusCode;
	
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public BaseResponse() {
		super();
	}

	public BaseResponse(String statusMessage, int statusCode) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
	}

}