package com.biplab.qa.test;

import com.biplab.qa.models.Product.ProductBodyModel;
import com.biplab.qa.models.Product.ProductResponseModel;
import com.biplab.qa.services.ProductService;
import com.biplab.qa.utils.StringUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;


public class ProductsTest {
    @TmsLink("RP-12345")
    @Severity(SeverityLevel.CRITICAL)
    @Story("RP-123")
    @Test(groups = {"sanity"}, description = "Verify creation of new products")
    public void verifyCreateProducts() {
        String filePath = "src/test/resources/products/Products.json";
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

    @Test(groups = {"smoke"},description = "Create product with Model")
    @TmsLink("RP-12346")
    @Severity(SeverityLevel.MINOR)
    @Story("RP-124")
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
