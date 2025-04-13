package com.biplab.qa.utils;

import com.biplab.qa.models.Product.ProductDBModel;

import java.sql.*;

public class DBUtils {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
    public static final String USERNAME = "biplab";
    public static final String PASSWORD = "biplab123";

    public static Connection connectToDatabase() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to Oracle DB!");
        return conn;
    }

    public void executeQuery(String query) throws SQLException {

        try (Connection conn = connectToDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ProductDBModel prod = new ProductDBModel();
                prod.setProductId(rs.getInt("PRODUCT_ID"));
                prod.setProductName(rs.getString("PRODUCT_NAME"));
                prod.setPrice(rs.getDouble("PRICE"));
                prod.setQuantity(rs.getInt("STOCK_QUANTITY"));
                System.out.println(prod.getPrice());
            }

        }
    }

}
