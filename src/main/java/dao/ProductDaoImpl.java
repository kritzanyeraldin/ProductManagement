package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private final Connection conn;

    public ProductDaoImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void addProduct(Product product){
        String querySql = "INSERT INTO product (name, price, quantity) VALUES (?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(querySql)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts(){
        String querySql = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(querySql)) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public void updateProduct(Product product){
        String querySql = "UPDATE product SET name = ?, price = ?, quantity = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(querySql)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id){
        String querySql = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(querySql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int id){
        String querySql = "SELECT * FROM product WHERE id = ?";
        Product product = null;
        try (PreparedStatement stmt = conn.prepareStatement(querySql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;

    }
}
