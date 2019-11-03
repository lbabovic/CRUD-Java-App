package domainLayer;

import java.util.ArrayList;
import javax.swing.JButton;

public interface FileCreatorProviderInterface {
	String createXML(ArrayList<Product> products, JButton open);
	String validate(String xml);
	boolean createJSON(ArrayList<Product> products, JButton open);
	boolean createPDF(ArrayList<Product> products, JButton open);
}
