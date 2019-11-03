package domainLayer;

import dataLayer.Response;

public interface LoginProviderInterface {
	public Response<Boolean> logIn(String username, String password);
}
