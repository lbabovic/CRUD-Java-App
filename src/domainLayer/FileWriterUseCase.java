package domainLayer;

import java.util.ArrayList;
import javax.swing.JButton;


public interface FileWriterUseCase {
	String createXML(JButton open);
	String validate(String xml);
	boolean createJSON(JButton open);
	boolean createPDF(JButton open);
}
