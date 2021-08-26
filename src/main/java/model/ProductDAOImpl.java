package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
	static Connection connection;
	static PreparedStatement ps;
	static Statement st;

	@Override
	public ArrayList<Product> getMyProductList(int id) {
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			connection = DbConnection.connectDb();
			ps = connection.prepareStatement("select * from product where owner=?");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setCategory(resultSet.getString("category"));
				product.setCount(resultSet.getInt("count"));
				product.setPrice(resultSet.getInt("price"));
				product.setOwner(resultSet.getInt("owner"));
				list.add(product);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public int addProduct(Product product) {
		int status = 0;
		try {
			connection = DbConnection.connectDb();
			ps = connection.prepareStatement("insert into product(name,category,count,price,owner) values(?,?,?,?,?)");
			ps.setString(1, product.getName());
			ps.setString(2, product.getCategory());
			ps.setInt(3, product.getCount());
			ps.setInt(4, product.getPrice());
			ps.setInt(5, product.getOwner());
			status = ps.executeUpdate();
			
			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public int deleteProduct(int id) {
		int status=0;
		try {
			connection = DbConnection.connectDb();
			ps = connection.prepareStatement("delete from product where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			
			connection.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return status;
	}

	@Override
	public ArrayList<Product> getProductList(int id) {
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			connection = DbConnection.connectDb();
			ps = connection.prepareStatement("select * from product where owner!=?");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setCategory(resultSet.getString("category"));
				product.setCount(resultSet.getInt("count"));
				product.setPrice(resultSet.getInt("price"));
				product.setOwner(resultSet.getInt("owner"));
				list.add(product);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
		
	}

}
