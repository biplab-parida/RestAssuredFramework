package com.biplab.qa.services;

import com.biplab.qa.models.Product.ProductBodyModel;
import com.biplab.qa.models.Product.ProductDBModel;
import com.biplab.qa.utils.DBUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static io.restassured.RestAssured.given;

public class ProductService {
    public static String BASE_URL = "https://dummyjson.com/";
    public static String PRODUCT_URL = BASE_URL + "products";
    public static String ADD_PRODUCT_URL = PRODUCT_URL + "/add";

    @Step("Executing POST Request")
    public static Response createProducts(String body) {
        Response res = given()
                .baseUri(ADD_PRODUCT_URL)
                .header("Content-Type", "application/json")
                .body(body)
                .post();
        return res;
    }
    @Step("Executing POST Request with Model")
    public static Response createProducts(ProductBodyModel body) {
        Response res = given()
                .baseUri(ADD_PRODUCT_URL)
                .header("Content-Type", "application/json")
                .body(body)
                .post();
        return res;
    }

    public static ProductDBModel executeProductQuery(String query) throws SQLException {
        ProductDBModel prod = new ProductDBModel();
        try (
                Connection conn = DBUtils.connectToDatabase();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                prod.setProductId(rs.getInt("PRODUCT_ID"));
                prod.setProductName(rs.getString("PRODUCT_NAME"));
                prod.setPrice(rs.getDouble("PRICE"));
                prod.setQuantity(rs.getInt("STOCK_QUANTITY"));

            }
            return prod;
        }
    }
}
