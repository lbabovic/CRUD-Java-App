package guiLayer;
import java.awt.EventQueue;

import javax.swing.JFrame;

import domainLayer.Product;
import main.AppDependenciesContainer;

public class AppCoordinator implements LoginDelegate, MainFrameDelegate {
	AppDependenciesContainer dependencies = new AppDependenciesContainer();
	MainFrame mainFrame;
	
	public void start() {
		LogInView logIn = new LogInView(dependencies);
		logIn.setDelegate(this);
		presentFrame(logIn);
	}
	
	private void presentFrame(JFrame frame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void presentMainFrame() {
		mainFrame = new MainFrame(new MainFrameDataSource(dependencies));
		mainFrame.setDelegate(this);
		presentFrame(mainFrame);
	}

	@Override
	public void presentEditFrame(Product p) {
		// TODO Auto-generated method stub
		EditFrame editFrame = new EditFrame(p);
		editFrame.setDependenciesAndDelegate(dependencies, mainFrame);
		presentFrame(editFrame);
	}

	@Override
	public void presentAddFrame() {
		// TODO Auto-generated method stub
		AddProductFrame addFrame = new AddProductFrame(dependencies, mainFrame);
		presentFrame(addFrame);
	}
}