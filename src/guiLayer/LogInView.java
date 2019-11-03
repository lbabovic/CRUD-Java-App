package guiLayer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataLayer.Response;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LogInView extends JFrame {
    private JFrame frame;
    private GUIDependencies dependencies;
	private JPanel contentPane;
	private JLabel lblDatabaseHandler;
	private JLabel lblUserName;
	public JTextField usernameTextField;
	private JButton btnConnect;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private LoginDelegate delegate;

	public LogInView(GUIDependencies dependencies) {
		this.dependencies = dependencies;
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 270);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblDatabaseHandler());
		contentPane.add(getLblUserName());
		contentPane.add(getUsernameTextField());
		contentPane.add(getBtnConnect());
		contentPane.add(getLblPassword());
		contentPane.add(getPasswordField());
		this.setResizable(false);
	}
	private JLabel getLblDatabaseHandler() {
		if (lblDatabaseHandler == null) {
			lblDatabaseHandler = new JLabel("Log in");
			lblDatabaseHandler.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblDatabaseHandler.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatabaseHandler.setBounds(10, 11, 314, 41);
		}
		return lblDatabaseHandler;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("Username:");
			lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
			lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblUserName.setBounds(10, 102, 95, 20);
		}
		return lblUserName;
	}
	private JTextField getUsernameTextField() {
		if (usernameTextField == null) {
			usernameTextField = new JTextField();
			usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
			usernameTextField.setToolTipText("Enter username");
			usernameTextField.setBounds(115, 102, 209, 20);
			usernameTextField.setColumns(10);
			usernameTextField.addKeyListener(new KeyListener() {
			
			 

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				getBtnConnect().setEnabled(!usernameTextField.getText().isEmpty());
				
			}
			 
			});
		}
		return usernameTextField;
	}
	private JButton getBtnConnect() {
		if (btnConnect == null) {
			btnConnect = new JButton("Connect");
			btnConnect.setEnabled(false);
			btnConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {	
					Response<Boolean> loginResponse = dependencies.logInUseCase.logIn(usernameTextField.getText(), String.valueOf(passwordField.getPassword()));
					switch (loginResponse.getResponseType()) {
					    case success:
					    	LogInView.this.dispose();
					    	delegate.presentMainFrame();
					    	break;
					    case error:
					    	JOptionPane.showMessageDialog(frame, loginResponse.getErrorDescription());
					}
				}
			});
			btnConnect.setBounds(10, 197, 314, 23);
		}
		return btnConnect;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPassword.setBounds(10, 138, 95, 20);
		}
		return lblPassword;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(115, 138, 209, 20);
		}
		return passwordField;
	}
	
	
	public void setDelegate(LoginDelegate delegate) {
		this.delegate = delegate;
	}
}
