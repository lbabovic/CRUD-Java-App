package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.log.SysoCounter;

import dataLayer.Response;
import domainLayer.Product;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame implements EditFrameDelegate, AddProductDelegate {
	private MainFrameDelegate delegate;
	private MainFrameDataSource datasource;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cmbCategory;
	private JLabel lblProductManager;
	private JLabel lblNewLabel_1;
	private JTextField txtMinprice;
	private JLabel lblNewLabel_2;
	private JTextField txtMaxprice;
	private JButton btnDisplay;
	private JOptionPane pane;
	private JFrame frame;
	private JTable table;
	private JButton btnEditItem;
	private JButton btnDeleteSelectedItem;
	private JLabel lblNewLabel_3;
	private JTextField searchEditText;
	private JButton btnAddItem;
	private JButton btnGenerateXmlFile;
	private JButton btnGenerateJsonFile;
	private JButton btnGeneratePdfFile;

	private JLabel lblAvailability;
	private JComboBox cmbIsDeleted;
	private JButton resetFilters;
	private JLabel lblAmount;
	private JTextField txtMinAmount;
	private JLabel lblMaxAmount;
	private JTextField txtMaxAmount;

	public MainFrame(MainFrameDataSource datasource) {
		this.datasource = datasource;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getCmbCategory());

		cmbCategory.addItem("Select");
		cmbCategory.addItem("Smartphone");
		cmbCategory.addItem("Game console");
		cmbCategory.addItem("Tablet");
		cmbCategory.addItem("Monitor");
		cmbCategory.addItem("Laptop");
		cmbCategory.addItem("Mouse and keyboards");
		cmbCategory.addItem("Desktop PC");
		contentPane.add(getLblProductManager());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTxtMinprice());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTxtMaxprice());
		contentPane.add(getBtnDisplay());

		frame = this;
		table = new JTable();
		table.setFocusable(false);
		table.setRowSelectionAllowed(true);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10,288,870,308);
		frame.getContentPane().add(scroll);
		contentPane.add(getBtnEditItem());
		contentPane.add(getBtnDeleteSelectedItem());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getSearchEditText());
		contentPane.add(getBtnAddItem());
		contentPane.add(getBtnGenerateXmlFile());
		contentPane.add(getBtnGenerateJsonFile());
		contentPane.add(getBtnGeneratePdfFile());
		contentPane.add(getLblAvailability());
		contentPane.add(getCmbIsDeleted());
		contentPane.add(getResetFilters());
		contentPane.add(getLblAmount());
		contentPane.add(getTxtMinAmount());
		contentPane.add(getLblMaxAmount());
		contentPane.add(getTxtMaxAmount());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Category:");
			lblNewLabel.setBounds(10, 79, 84, 14);
		}
		return lblNewLabel;
	}

	private JComboBox getCmbCategory() {
		if (cmbCategory == null) {
			cmbCategory = new JComboBox();
			cmbCategory.setBounds(76, 76, 232, 20);
		}
		return cmbCategory;
	}

	private JLabel getLblProductManager() {
		if (lblProductManager == null) {
			lblProductManager = new JLabel("Product managing tool");
			lblProductManager.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblProductManager.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductManager.setBounds(338, 11, 204, 27);
		}
		return lblProductManager;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Min price:");
			lblNewLabel_1.setBounds(10, 119, 71, 14);
		}
		return lblNewLabel_1;
	}

	private JTextField getTxtMinprice() {
		if (txtMinprice == null) {
			txtMinprice = new JTextField();
			txtMinprice.setBounds(86, 116, 71, 20);
			txtMinprice.setColumns(10);
		}
		return txtMinprice;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Max price:");
			lblNewLabel_2.setBounds(167, 119, 66, 14);
		}
		return lblNewLabel_2;
	}

	private JTextField getTxtMaxprice() {
		if (txtMaxprice == null) {
			txtMaxprice = new JTextField();
			txtMaxprice.setColumns(10);
			txtMaxprice.setBounds(237, 116, 71, 20);
		}
		return txtMaxprice;
	}

	private JButton getBtnDisplay() {
		if (btnDisplay == null) {
			btnDisplay = new JButton("Display products");
			btnDisplay.setBounds(76, 237, 232, 40);

			btnDisplay.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					searchEditText.setEnabled(true);
					searchEditText.setText("");
					btnDeleteSelectedItem.setEnabled(true);
					btnEditItem.setEnabled(true);
					btnGenerateXmlFile.setEnabled(true);
					btnGenerateJsonFile.setEnabled(true);
					btnGeneratePdfFile.setEnabled(true);
					
					String category = cmbCategory.getSelectedItem().toString();
					String isDeleted = cmbIsDeleted.getSelectedItem().toString();
					double minPrice = 0;
					double maxPrice = 0;
					int minAmount = 0;
					int maxAmount = 0;

					if (txtMinprice.getText().equalsIgnoreCase("")) {
						minPrice = 0;
					} else {
						try {
							minPrice = Double.parseDouble(txtMinprice.getText());
						} catch (Exception e2) {
							pane.showMessageDialog(frame, "Price must be numeric", "Error", pane.ERROR_MESSAGE);
						}
					}
					if (txtMaxprice.getText().equalsIgnoreCase("")) {
						maxPrice = 9999999;
					} else {
						try {
							maxPrice = Double.parseDouble(txtMaxprice.getText());
						} catch (Exception e2) {
							pane.showMessageDialog(frame, "Price must be numeric", "Error", pane.ERROR_MESSAGE);
						}
					}
					
					if(txtMinAmount.getText().equalsIgnoreCase("")){
						minAmount = 0;
					}else{
						try {
							minAmount = Integer.parseInt(txtMinAmount.getText());
						} catch (Exception e2) {
							pane.showMessageDialog(frame, "Amount must be numeric", "Error", pane.ERROR_MESSAGE);
						}
					}
					
					if(txtMaxAmount.getText().equalsIgnoreCase("")){
						maxAmount = 9999999;
					}else{
						try {
							maxAmount = Integer.parseInt(txtMaxAmount.getText());
						} catch (Exception e2) {
							pane.showMessageDialog(frame, "Amount must be numeric", "Error", pane.ERROR_MESSAGE);
						}
					}
					
					refreshTable();
				}
			});
		}
		return btnDisplay;
	}
	
	public void refreshTable(){
		Response<Object[][]> response = datasource.getAllProducts(); 
		switch (response.getResponseType()) {
		case success:
			Object[][] products = response.getResponse();
			Object[] columnNames = {"Name", "Description", "Price", "Amount", "Category",
					"Is deleted" };
			DefaultTableModel model = new DefaultTableModel(products, columnNames);
			table.setModel(model);
			break;
		case error:
			pane.showMessageDialog(frame, response.getErrorDescription(), "Error", pane.ERROR_MESSAGE);
		}
	}
	
	public void refreshInputFields(JComboBox category, JTextField searchInput, JTextField minPrice, JTextField maxPrice){
		category.setSelectedItem("Select");
		searchInput.setText("");
		minPrice.setText("");
		maxPrice.setText("");
	}
	
	private JButton getBtnEditItem() {
		if (btnEditItem == null) {
			btnEditItem = new JButton("Edit selected item");
			btnEditItem.setEnabled(false);
			btnEditItem.setBounds(357, 73, 175, 27);
			
			btnEditItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DefaultTableModel m = (DefaultTableModel) table.getModel();
					int row = table.getSelectedRow();
					
					if(row == -1){
						pane.showMessageDialog(frame, "Select a product", "Error", pane.ERROR_MESSAGE);
						return;
					}				
					
					String[] s = m.getDataVector().elementAt(table.getSelectedRow()).toString().replaceAll("\\[", "").replaceAll("\\]", "").split(",");
					Response<Product> productResponse = datasource.getProductForEdit(s[0]);
					switch (productResponse.getResponseType()) {
					case success:
						Product p = productResponse.getResponse();
						delegate.presentEditFrame(p);
						break;
					case error:
						pane.showMessageDialog(frame, productResponse.getErrorDescription(), "Error", pane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnEditItem;
	}
	
	private JButton getBtnDeleteSelectedItem() {
		if (btnDeleteSelectedItem == null) {
			btnDeleteSelectedItem = new JButton("Delete selected item");
			btnDeleteSelectedItem.setEnabled(false);
			btnDeleteSelectedItem.setBounds(357, 113, 175, 27);
			btnDeleteSelectedItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel m = (DefaultTableModel) table.getModel();
					
					int row = table.getSelectedRow();
					
					if(row == -1){
						pane.showMessageDialog(frame, "Select a product", "Error", pane.ERROR_MESSAGE);
						return;
					}		
					
					int yes = pane.YES_NO_OPTION;
					int result = pane.showConfirmDialog(frame, "Product will be permanenently deleted from the database. Proceed?", "Warning", yes);
					
					if(result == 0){
						String[] s = m.getDataVector().elementAt(table.getSelectedRow()).toString().replaceAll("\\[", "").replaceAll("\\]", "").split(",");
						Response<Boolean> deleteResponse = datasource.deleteProduct(s[0]);
						switch (deleteResponse.getResponseType()) {
						case success:
							pane.showMessageDialog(frame, "Product deleted", "Success!", pane.INFORMATION_MESSAGE);
							refreshTable();
							refreshInputFields(cmbCategory, searchEditText, txtMinprice, txtMaxprice);
							break;
						case error:
							pane.showMessageDialog(frame, deleteResponse.getErrorDescription(), "Error", pane.ERROR_MESSAGE);
						}
					}	
				}
			});
		}
		return btnDeleteSelectedItem;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Name:");
			lblNewLabel_3.setBounds(10, 42, 46, 14);
		}
		return lblNewLabel_3;
	}
	private JTextField getSearchEditText() {
		if (searchEditText == null) {
			searchEditText = new JTextField();
			searchEditText.setEnabled(false);
			searchEditText.setBounds(76, 39, 232, 20);
			searchEditText.setColumns(10);
			searchEditText.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					if (searchEditText.getText().isEmpty()) { refreshTable();return; };
					String category = cmbCategory.getSelectedItem().toString();
					String isDeleted = cmbIsDeleted.getSelectedItem().toString();
					double minPrice = 0;
					double maxPrice = 0;
					int minAmount = 0;
					int maxAmount = 0;

					if (txtMinprice.getText().equalsIgnoreCase("")) {
						minPrice = 0;
					} else {
						try {
							minPrice = Double.parseDouble(txtMinprice.getText());
						} catch (Exception e2) {
							pane.showMessageDialog(frame, "Price must be numeric", "Error", pane.ERROR_MESSAGE);
						}
					}
					if (txtMaxprice.getText().equalsIgnoreCase("")) {
						maxPrice = 9999999;
					} else {
						try {
							maxPrice = Double.parseDouble(txtMaxprice.getText());
						} catch (Exception e2) {
							pane.showMessageDialog(frame, "Price must be numeric", "Error", pane.ERROR_MESSAGE);
						}
					}
					
					if(txtMinAmount.getText().equalsIgnoreCase("")){
						minAmount = 0;
					}else{
						try {
							minAmount = Integer.parseInt(txtMinAmount.getText());
						} catch (Exception e2) {
							pane.showMessageDialog(frame, "Amount must be numeric", "Error", pane.ERROR_MESSAGE);
						}
					}
					
					if(txtMaxAmount.getText().equalsIgnoreCase("")){
						maxAmount = 9999999;
					}else{
						try {
							maxAmount = Integer.parseInt(txtMaxAmount.getText());
						} catch (Exception e2) {
							pane.showMessageDialog(frame, "Amount must be numeric", "Error", pane.ERROR_MESSAGE);
						}
					}
					
					Response<Object[][]> searchResponse = datasource.filteredProductsForTable(searchEditText.getText(),category, minPrice, maxPrice,isDeleted, minAmount,maxAmount);
					switch (searchResponse.getResponseType()) {
					case success:
						Object[][] products = searchResponse.getResponse();
						Object[] columnNames = {"Name", "Description", "Price", "Amount", "Category",
								"Is deleted" };
						DefaultTableModel model = new DefaultTableModel(products, columnNames);
						table.setModel(model);
						break;
					case error:
						pane.showMessageDialog(frame, searchResponse.getErrorDescription(), "Error", pane.ERROR_MESSAGE);
					}
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					
				}
			});
		}
		return searchEditText;
	}
	private JButton getBtnAddItem() {
		if (btnAddItem == null) {
			btnAddItem = new JButton("Add item");
			btnAddItem.setBounds(357, 151, 175, 27);
			
			btnAddItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					delegate.presentAddFrame();
				}
			});
		}
		return btnAddItem;
	}
	private JButton getBtnGenerateXmlFile() {
		if (btnGenerateXmlFile == null) {
			btnGenerateXmlFile = new JButton("Generate XML file");
			btnGenerateXmlFile.setEnabled(false);
			btnGenerateXmlFile.setBounds(651, 73, 217, 27);
			
			btnGenerateXmlFile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//OVDJE ZOVES METODU IZ KLASE FILE KOJA CE DA PRAVI XML EZ
					
					int yes = pane.YES_NO_OPTION;
					int result = pane.showConfirmDialog(frame, "You're about to create XML file of all visible products in table.\nProceed?", "Warning", yes);
					
					if(result == 1){
						return;
					}
					
					String ok = datasource.getDependencies().fileWriterUseCase.createXML(btnGenerateXmlFile);
					
					if(ok != null){
						String msg = datasource.getDependencies().fileWriterUseCase.validate(ok + ".xml");
						pane.showMessageDialog(frame, "XML exported: " + msg, "Success", pane.INFORMATION_MESSAGE);
					}
				}
			});
		}
		return btnGenerateXmlFile;
	}
	
	private JButton getBtnGenerateJsonFile() {
		if (btnGenerateJsonFile == null) {
			btnGenerateJsonFile = new JButton("Generate JSON file");
			btnGenerateJsonFile.setEnabled(false);
			btnGenerateJsonFile.setBounds(651, 113, 217, 27);
			
			btnGenerateJsonFile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					int yes = pane.YES_NO_OPTION;
					int result = pane.showConfirmDialog(frame, "You're about to create JSON file of all visible products in table.\nProceed?", "Warning", yes);
					
					if(result == 1){
						return;
					}
					
					boolean ok = datasource.getDependencies().fileWriterUseCase.createJSON(btnGenerateJsonFile);
					
					if(ok){
						pane.showMessageDialog(frame, "Successfully created JSON file", "Success", pane.INFORMATION_MESSAGE);
						return;
					}else{
						pane.showMessageDialog(frame, "Failed while creating JSON file", "Error", pane.ERROR_MESSAGE);
						return;
					}
				}
			});
		}
		return btnGenerateJsonFile;
	}
	private JButton getBtnGeneratePdfFile() {
		if (btnGeneratePdfFile == null) {
			btnGeneratePdfFile = new JButton("Generate PDF file");
			btnGeneratePdfFile.setEnabled(false);
			btnGeneratePdfFile.setBounds(651, 153, 217, 27);
			
			btnGeneratePdfFile.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String fileName = "";
					
					int yes = pane.YES_NO_OPTION;
					int result = pane.showConfirmDialog(frame, "You're about to create a PDF file of all visible products in table.\nProceed?", "Warning", yes);
					
					if(result == 1){
						return;
					}
					
					boolean ok = datasource.getDependencies().fileWriterUseCase.createPDF(btnGeneratePdfFile);
					
					if(ok){
						pane.showMessageDialog(frame, "Successfully created PDF file", "Success", pane.INFORMATION_MESSAGE);
						return;
					}else{
						pane.showMessageDialog(frame, "Failed while creating PDF file", "Error", pane.ERROR_MESSAGE);
						return;
					}
					
				}
			});
		}
		return btnGeneratePdfFile;
	}
	private JLabel getLblAvailability() {
		if (lblAvailability == null) {
			lblAvailability = new JLabel("Availability:");
			lblAvailability.setBounds(10, 157, 84, 14);
		}
		return lblAvailability;
	}
	private JComboBox getCmbIsDeleted() {
		if (cmbIsDeleted == null) {
			cmbIsDeleted = new JComboBox();
			cmbIsDeleted.setBounds(76, 154, 232, 20);
			
			cmbIsDeleted.addItem("Select");
			cmbIsDeleted.addItem("Available");
			cmbIsDeleted.addItem("Deleted");
		}
		return cmbIsDeleted;
	}
	private JButton getResetFilters() {
		if (resetFilters == null) {
			resetFilters = new JButton("<html><center>Reset<br/>filters</center></html>");
			resetFilters.setFont(new Font("Tahoma", Font.PLAIN, 10));
			resetFilters.setBounds(10, 237, 56, 40);
			
			resetFilters.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					searchEditText.setText("");
					cmbCategory.setSelectedItem("Select");
					cmbIsDeleted.setSelectedItem("Select");
					txtMinprice.setText("");
					txtMaxprice.setText("");
					txtMinAmount.setText("");
					txtMaxAmount.setText("");
				}
			});
		}
		return resetFilters;
	}
	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Min amount:");
			lblAmount.setBounds(10, 199, 71, 14);
		}
		return lblAmount;
	}
	private JTextField getTxtMinAmount() {
		if (txtMinAmount == null) {
			txtMinAmount = new JTextField();
			txtMinAmount.setColumns(10);
			txtMinAmount.setBounds(86, 196, 71, 20);
		}
		return txtMinAmount;
	}
	private JLabel getLblMaxAmount() {
		if (lblMaxAmount == null) {
			lblMaxAmount = new JLabel("Max amount:");
			lblMaxAmount.setBounds(165, 199, 81, 14);
		}
		return lblMaxAmount;
	}
	private JTextField getTxtMaxAmount() {
		if (txtMaxAmount == null) {
			txtMaxAmount = new JTextField();
			txtMaxAmount.setColumns(10);
			txtMaxAmount.setBounds(237, 196, 71, 20);
		}
		return txtMaxAmount;
	}
	
	public void setDelegate(MainFrameDelegate delegate) {
		this.delegate = delegate;
	}
}
