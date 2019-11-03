package guiLayer;
import domainLayer.EditUseCase;
import domainLayer.FileWriterUseCase;
import domainLayer.LoginUseCase;
import domainLayer.ProductUseCase;
import domainLayer.SearchUseCase;

public abstract class GUIDependencies {
	ProductUseCase productUseCase;
	SearchUseCase searchUseCase;
	EditUseCase editUseCase;
	FileWriterUseCase fileWriterUseCase;
	LoginUseCase logInUseCase;

	public void setLoginUseCase(LoginUseCase logInUseCase) {
		this.logInUseCase = logInUseCase;
	}
	public void setProductUseCase(ProductUseCase productUseCase) {
		this.productUseCase = productUseCase;
	}
	public void setSearchUseCase(SearchUseCase searchUseCase) {
		this.searchUseCase = searchUseCase;
	}
	public void setEditUseCase(EditUseCase editUseCase) {
		this.editUseCase = editUseCase;
	}
	public void setFileWriterUseCase(FileWriterUseCase fileWriterUseCase) {
		this.fileWriterUseCase = fileWriterUseCase;
	}
}
