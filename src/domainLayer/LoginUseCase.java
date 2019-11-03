package domainLayer;

import dataLayer.Response;

public interface LoginUseCase {
	public Response<Boolean> logIn(String username, String password);
}
