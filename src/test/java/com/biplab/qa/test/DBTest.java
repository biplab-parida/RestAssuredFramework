package com.biplab.qa.test;

import com.biplab.qa.models.Product.ProductDBModel;
import com.biplab.qa.services.ProductService;
import com.biplab.qa.utils.DBUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DBTest {
    @Test
    public void databaseTest() {
        DBUtils dbUtils = new DBUtils();
        int productId = 101;
        String query = String.format("select * from %s where product_id = %d", "products", productId);

        try {
            ProductDBModel prod = ProductService.executeProductQuery(query);
            System.out.println(prod.getPrice());
            Assert.assertEquals(prod.getProductName(), "Laptop");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
