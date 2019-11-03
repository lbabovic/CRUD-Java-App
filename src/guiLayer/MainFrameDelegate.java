package guiLayer;

import domainLayer.Product;

public interface MainFrameDelegate {
	void presentEditFrame(Product p);
	void presentAddFrame();
}
