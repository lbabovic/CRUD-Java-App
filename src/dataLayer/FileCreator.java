package dataLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.xml.sax.SAXException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import domainLayer.Product;

public class FileCreator {
	public String validate(String xml) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");
			factory.setSchema(schemaFactory
					.newSchema(new Source[] { new StreamSource(
							"inventory_schema.xsd") }));
			SAXParser parser = factory.newSAXParser();
			SAXReader reader = new SAXReader(parser.getXMLReader());
			try {
				System.out.println(xml);
				reader.read(new FileReader(new File(xml)));
				return "Successful validation";
			} catch (Exception e) {
				return "Unsuccessful validation. " + e.getMessage();
			}

		} catch (ParserConfigurationException | SAXException e) {
		}
		return "Error while validating.";

	}
	
	public String createXML(ArrayList<Product> products, JButton open){
		Document document = DocumentHelper.createDocument();
		
		Element root = document.addElement("ProductInventory");
		for (Product p : products) {
			Element product = root.addElement("Product");
			Element name = product.addElement("Name");
			name.setText(p.getName());
			Element description = product.addElement("Description");
			description.setText(p.getDescription());
			Element price = product.addElement("Price");
			price.setText(p.getPrice() + "");
			Element amount = product.addElement("Amount");
			amount.setText(p.getAmount() + "");
			Element isDeleted = product.addElement("IsDeleted");
			isDeleted.setText(p.isDeleted() + "");
			Element category = product.addElement("Category");
			category.setText(p.getCategory());
		}
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		int response = chooser.showSaveDialog(open);
		
		if(response == JFileChooser.APPROVE_OPTION){
			try {
				XMLWriter writer = new XMLWriter(new FileWriter(chooser.getSelectedFile() + ".xml"));
				writer.write(document);
				writer.flush();
				writer.close();
				return chooser.getSelectedFile().getAbsolutePath();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean createJSON(ArrayList<Product> products, JButton open){
		JSONArray productsJSON = new JSONArray();
		
		for (Product p : products) {
			JSONObject o = new JSONObject();
			
			o.put("name", p.getName());
			o.put("description",p.getDescription());
			o.put("price",p.getPrice());
			o.put("amount",p.getAmount());
			o.put("isDeleted",p.isDeleted());
			o.put("category",p.getCategory());
			
			productsJSON.add(o);
		}

		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		int response = chooser.showSaveDialog(open);
		
		if(response == JFileChooser.APPROVE_OPTION){
			
		}
		try {
			FileWriter writer = new FileWriter(chooser.getSelectedFile() + ".json");
			writer.write(productsJSON.toJSONString());
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean createPFD(ArrayList<Product> products, JButton open){
		com.itextpdf.text.Document document = new com.itextpdf.text.Document();
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		int response = chooser.showSaveDialog(open);
		
		if(response == JFileChooser.APPROVE_OPTION){
			try {
				PdfWriter.getInstance(document, new FileOutputStream(new File(chooser.getSelectedFile() + ".pdf")));
				document.open();
				
				Font headerFont = new Font(FontFamily.TIMES_ROMAN, 16, Font.NORMAL, BaseColor.RED);
				Font titleFont = new Font(FontFamily.TIMES_ROMAN, 19, Font.NORMAL,
						BaseColor.BLACK);
				Font textFont = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL,
						BaseColor.BLACK);
				
				Paragraph p = new Paragraph("Products",titleFont);
				document.add(p);
				document.add(new Paragraph(" "));
				createTable(document, textFont, headerFont, products);
				document.close();
				return true;
			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return false;
	}
	
	private void createTable(com.itextpdf.text.Document document,Font textFont, Font headerFont, ArrayList<Product> products) throws DocumentException{
		PdfPTable table = new PdfPTable(6);
		PdfPCell c1 = new PdfPCell(new Phrase("Name", headerFont));
		table.addCell(c1);
		PdfPCell c2 = new PdfPCell(new Phrase("Description", headerFont));
		table.addCell(c2);
		PdfPCell c3 = new PdfPCell(new Phrase("isDeleted", headerFont));
		table.addCell(c3);
		PdfPCell c4 = new PdfPCell(new Phrase("Category", headerFont));
		table.addCell(c4);
		PdfPCell c5 = new PdfPCell(new Phrase("Amount", headerFont));
		table.addCell(c5);
		PdfPCell c6 = new PdfPCell(new Phrase("Price", headerFont));
		table.addCell(c6);
		document.add(new Paragraph(" "));
		for (Product p : products) {
			table.addCell(new Phrase(p.getName(), textFont));
			table.addCell(new Phrase(p.getDescription(), textFont));
			table.addCell(new Phrase(p.isDeleted() + "", textFont));
			table.addCell(new Phrase(p.getCategory(), textFont));
			table.addCell(new Phrase(p.getAmount() + "", textFont));
			table.addCell(new Phrase(p.getPrice() + "", textFont));
		}
		document.add(table);
	}
}
