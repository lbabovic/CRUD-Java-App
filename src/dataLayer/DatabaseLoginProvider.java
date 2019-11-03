package dataLayer;

import domainLayer.LoginProviderInterface;

public class DatabaseLoginProvider implements LoginProviderInterface{
	DatabaseService databaseService;
	
	public DatabaseLoginProvider(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@Override
	public Response<Boolean> logIn(String username, String password) {
		return databaseService.logIn(username, password);
	}
}
