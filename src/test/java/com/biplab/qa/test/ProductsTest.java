package com.biplab.qa.test;

import com.biplab.qa.models.Product.ProductBodyModel;
import com.biplab.qa.models.Product.ProductResponseModel;
import com.biplab.qa.services.ProductService;
import com.biplab.qa.utils.StringUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest {

    @Test
    public void verifyCreateProducts() {
        String filePath = "src/test/resources/Products.json";
//    JsonObject body = JsonUtil.readJsonFile(filePath);
        String strBody = StringUtil.readFile(filePath);
        Response res = ProductService.createProducts(strBody);
        Assert.assertEquals(res.getStatusCode(), 201);
        Assert.assertNotNull(res.body().jsonPath().get("id").toString());

        //convert Response to POJO
        ProductResponseModel obj = res.as(ProductResponseModel.class);

        Assert.assertNotNull(obj.getId());
        Assert.assertTrue(obj.getPrice() > 0);
        System.out.println(obj.getDescription());

    }

    @Test
    public void verifyCreateProducts2() {
        ProductBodyModel body = new ProductBodyModel()
                .setTitle("test")
                .setPrice(89.45)
                .setDescription("New Description")
                .setDimensions(new ProductBodyModel.Dimensions().setDepth(10.22).setWidth(4.55).setHeight(14.5));
        Response res = ProductService.createProducts(body);
        Assert.assertEquals(res.getStatusCode(), 201);
        Assert.assertNotNull(res.body().jsonPath().get("id").toString());

        //convert Response to POJO
        ProductResponseModel obj = res.as(ProductResponseModel.class);

        Assert.assertNotNull(obj.getId());
        Assert.assertTrue(obj.getPrice() > 0);
        System.out.println(obj.getDescription());

    }
}
