package main;

import dataLayer.DatabaseLoginProvider;
import dataLayer.DatabaseProductProvider;
import dataLayer.DatabaseService;
import dataLayer.FileCreator;
import dataLayer.FileCreatorProvider;
import domainLayer.LoginInteractor;
import domainLayer.ProductInteractor;
import guiLayer.GUIDependencies;

public class AppDependenciesContainer extends GUIDependencies {
	DatabaseService webService = new DatabaseService("jdbc:mysql://localhost:3306/lukababovic", "root", "");
	DatabaseProductProvider databaseProvider = new DatabaseProductProvider(webService);
	DatabaseLoginProvider loginProvider = new DatabaseLoginProvider(webService);
	FileCreatorProvider fileCreatorProvider= new FileCreatorProvider(new FileCreator());
	ProductInteractor productInteractor = new ProductInteractor(databaseProvider, fileCreatorProvider);
	LoginInteractor loginInteractor = new LoginInteractor(loginProvider);
	
	public AppDependenciesContainer() {
		super();
		super.setProductUseCase(productInteractor);
		super.setSearchUseCase(productInteractor);
		super.setEditUseCase(productInteractor);
		super.setFileWriterUseCase(productInteractor);
		super.setLoginUseCase(loginInteractor);
	}
}
