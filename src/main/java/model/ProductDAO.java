package model;

import java.util.ArrayList;

public interface ProductDAO {
	
	public ArrayList<Product> getMyProductList(int id);
	
	public ArrayList<Product> getProductList(int id);
	
	public int addProduct(Product product);
	
	public int deleteProduct(int id);

}
