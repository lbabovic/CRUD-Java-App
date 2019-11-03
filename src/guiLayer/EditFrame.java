package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.fonts.cmaps.CMapByteCid;

import dataLayer.Response;
import domainLayer.Product;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class EditFrame extends JFrame {
	private GUIDependencies dependencies;
	private EditFrameDelegate delegate;
	private Product product;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField nameEditText;
	private JLabel lblDescription;
	private JTextArea descEditText;
	private JLabel lblPrice;
	private JTextField priceEditText;
	private JLabel lblAmount;
	private JTextField amountEditText;
	private JCheckBox availableCheckbox;
	private JLabel lblCategory;
	private JButton updateButton;
	private JComboBox categoryCmb;
	private JTable table;
	private MainFrame mainFrame;
	private JFrame frame = this;
	private JOptionPane pane;

	public EditFrame(Product p) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 318, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.product = p;
		this.table = table;
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getNameEditText());
		contentPane.add(getLblDescription());
		contentPane.add(getDescEditText());
		contentPane.add(getLblPrice());
		contentPane.add(getTextField_1());
		contentPane.add(getLblAmount());
		contentPane.add(getTextField_2());
		contentPane.add(getAvailableCheckbox());
		contentPane.add(getLblCategory());
		contentPane.add(getUpdateButton());
		contentPane.add(getCategoryCmb());

		categoryCmb.addItem("Select");
		categoryCmb.addItem("Smartphone");
		categoryCmb.addItem("Game console");
		categoryCmb.addItem("Tablet");
		categoryCmb.addItem("Desktop PC");
		categoryCmb.addItem("Mouse and keyboards");
		categoryCmb.addItem("Monitor");
		categoryCmb.addItem("Laptop");

		categoryCmb.setSelectedItem(product.getCategory());

	}
	
	public void setDependenciesAndDelegate(GUIDependencies dependencies, EditFrameDelegate delegate) {
		this.dependencies = dependencies;
		this.delegate = delegate;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Edit product");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(98, 11, 116, 24);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Name:");
			lblNewLabel_1.setBounds(13, 93, 46, 14);
		}
		return lblNewLabel_1;
	}

	private JTextField getNameEditText() {
		if (nameEditText == null) {
			nameEditText = new JTextField();
			nameEditText.setBounds(91, 88, 195, 24);
			nameEditText.setColumns(10);

			nameEditText.setText(product.getName());
		}
		return nameEditText;
	}

	private JLabel getLblDescription() {
		if (lblDescription == null) {
			lblDescription = new JLabel("Description:");
			lblDescription.setBounds(13, 148, 68, 14);
		}
		return lblDescription;
	}

	private JTextArea getDescEditText() {
		if (descEditText == null) {
			descEditText = new JTextArea();
			descEditText.setLineWrap(true);
			descEditText.setRows(8);
			descEditText.setBounds(91, 143, 195, 108);

			descEditText.setText(product.getDescription());
		}
		return descEditText;
	}

	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("Price:");
			lblPrice.setBounds(13, 274, 46, 14);

		}
		return lblPrice;
	}

	private JTextField getTextField_1() {
		if (priceEditText == null) {
			priceEditText = new JTextField();
			priceEditText.setColumns(10);
			priceEditText.setBounds(91, 269, 57, 24);

			priceEditText.setText(product.getPrice() + "");
		}
		return priceEditText;
	}

	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount");
			lblAmount.setBounds(13, 323, 46, 14);

		}
		return lblAmount;
	}

	private JTextField getTextField_2() {
		if (amountEditText == null) {
			amountEditText = new JTextField();
			amountEditText.setColumns(10);
			amountEditText.setBounds(91, 318, 57, 24);

			amountEditText.setText(product.getAmount() + "");
		}
		return amountEditText;
	}

	private JCheckBox getAvailableCheckbox() {
		if (availableCheckbox == null) {
			availableCheckbox = new JCheckBox("Available");
			availableCheckbox.setBounds(91, 373, 97, 23);

			boolean deleted = product.isDeleted();

			if (deleted == true) {
				availableCheckbox.setSelected(false);
			} else {
				availableCheckbox.setSelected(true);
			}
		}
		return availableCheckbox;
	}

	private JLabel getLblCategory() {
		if (lblCategory == null) {
			lblCategory = new JLabel("Category:");
			lblCategory.setBounds(13, 420, 68, 14);
		}
		return lblCategory;
	}

	private JButton getUpdateButton() {
		if (updateButton == null) {
			updateButton = new JButton("Update");
			updateButton.setBounds(104, 482, 103, 37);

			updateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String ogName = product.getName();
					String ogDesc = product.getDescription();
					double ogPrice = product.getPrice();
					int ogAmount = product.getAmount();
					boolean ogIsDeleted = product.isDeleted();
					String ogCategory = product.getCategory();
					boolean isGood = true;
					boolean isChanged = true;

					String name = nameEditText.getText();
					if (name.equalsIgnoreCase("")) {
						// ZAVRSI PROVJERE OVDJE ZA UPDATEOVANJE I CUDA
						pane.showMessageDialog(frame, "Insert name", "Error", pane.ERROR_MESSAGE);
						isGood = false;
					}

					if (!name.matches("[a-zA-Z0-9\\s\\.\\-]*")) {
						pane.showMessageDialog(frame, "Name mustn't contain commas", "Error",
								pane.ERROR_MESSAGE);
						isGood = false;
					}

					String description = descEditText.getText();
					if (description.equalsIgnoreCase("")) {
						pane.showMessageDialog(frame, "Insert descripton", "Error", pane.ERROR_MESSAGE);
						isGood = false;
					}

					double price = 0;

					try {
						price = Double.parseDouble(priceEditText.getText());
						if (price <= 0 || price > 99999999) {
							pane.showMessageDialog(frame, "Enter valid price", "Error", pane.ERROR_MESSAGE);
							isGood = false;
						}
					} catch (NumberFormatException e2) {
						pane.showMessageDialog(frame, "Price must be numeric", "Error", pane.ERROR_MESSAGE);
						isGood = false;
					}
					
					int amount = 0;
					
					try {
						amount = Integer.parseInt(amountEditText.getText());
						if (amount <= 0 || amount > 99999999) {
							pane.showMessageDialog(frame, "Enter valid amount", "Error", pane.ERROR_MESSAGE);
							isGood = false;
						}
					} catch (NumberFormatException e2) {
						pane.showMessageDialog(frame, "Amount must be numeric", "Error", pane.ERROR_MESSAGE);
						isGood = false;
					}
					
					boolean isDeleted = true;
					if(availableCheckbox.isSelected()){
						isDeleted = false;
					}
					int deletedToSend = 0;
					if(isDeleted){
						deletedToSend = 1;
					}
										
					String category = categoryCmb.getSelectedItem().toString();
					
					if(category.equalsIgnoreCase("Select")){
						pane.showMessageDialog(frame, "Select a category", "Error", pane.ERROR_MESSAGE);
						isGood = false;
					}
					if (ogName.equalsIgnoreCase(name) && ogDesc.equalsIgnoreCase(description) && ogPrice == price && ogAmount == amount && ogIsDeleted == isDeleted && ogCategory.equalsIgnoreCase(category)) {
						// OVDJE VIDI JE LI STA MIJENJANO
						isChanged = false;
					}
					
					if (isGood) {
						if (isChanged) {
							Response<Boolean> response = dependencies.editUseCase.updateProduct(name, description, price, amount, deletedToSend, category,ogName);
							switch (response.getResponseType()) {
							case success:
								pane.showMessageDialog(frame, "Edit successful", "Done", pane.INFORMATION_MESSAGE);
								delegate.refreshTable();
								frame.dispose();
								break;
							case error:
								pane.showMessageDialog(frame, response.getErrorDescription(), "Error", pane.ERROR_MESSAGE);
							}
						} else {
							pane.showMessageDialog(frame, "Nothing changed, press OK to exit", "Done", pane.INFORMATION_MESSAGE);
							frame.dispose();
						}
					}
				}
			});
		}
		return updateButton;
	}

	private JComboBox getCategoryCmb() {
		if (categoryCmb == null) {
			categoryCmb = new JComboBox();
			categoryCmb.setBounds(98, 417, 188, 20);

		}
		return categoryCmb;
	}
}
