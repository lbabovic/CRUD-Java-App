package dataLayer;

public class Response<T> {
	private WebServiceResponseEnum responseType;
	private T responseFile;
	private String errorDescription;
	
	public Response(boolean isSuccessful, T response, String errorDescription) {
		super();
		if (isSuccessful) {
			this.responseType = WebServiceResponseEnum.success;
			this.responseFile = response;
		} else {
			this.responseType = WebServiceResponseEnum.error;
			this.errorDescription = errorDescription;
		}
	}

	public T getResponse() {
		return responseFile;
	}

	public String getErrorDescription() {
		return errorDescription == null ? "No error!" : errorDescription;
	}
	
	public WebServiceResponseEnum getResponseType() {
		return responseType;
	}
}
