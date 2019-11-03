package dataLayer;

import java.util.ArrayList;

import javax.swing.JButton;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;

import domainLayer.FileCreatorProviderInterface;
import domainLayer.Product;

public class FileCreatorProvider implements FileCreatorProviderInterface {
	private FileCreator fileCreator;

	public FileCreatorProvider(FileCreator fileCreator) {
		super();
		this.fileCreator = fileCreator;
	}

	@Override
	public String createXML(ArrayList<Product> products, JButton open) {
		// TODO Auto-generated method stub
		return fileCreator.createXML(products, open);
	}

	@Override
	public String validate(String xml) {
		// TODO Auto-generated method stub
		return fileCreator.validate(xml);
	}

	@Override
	public boolean createJSON(ArrayList<Product> products, JButton open) {
		// TODO Auto-generated method stub
		return fileCreator.createJSON(products, open);
	}

	@Override
	public boolean createPDF(ArrayList<Product> products, JButton open) {
		// TODO Auto-generated method stub
		return fileCreator.createPFD(products, open);
	}
}
