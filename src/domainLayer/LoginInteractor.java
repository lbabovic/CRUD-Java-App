package domainLayer;

import dataLayer.Response;

public class LoginInteractor implements LoginUseCase {
	LoginProviderInterface provider;
	
	public LoginInteractor(LoginProviderInterface provider) {
		this.provider = provider;
	}

	@Override
	public Response<Boolean> logIn(String username, String password) {
		// TODO Auto-generated method stub
		return provider.logIn(username, password);
	}
}
