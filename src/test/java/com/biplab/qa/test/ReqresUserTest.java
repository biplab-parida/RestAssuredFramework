package com.biplab.qa.test;

import com.biplab.qa.services.ReqresUsers;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresUserTest {

    @TmsLink("RP-12347")
    @Severity(SeverityLevel.MINOR)
    @Story("RP-125")
    @Test(groups = {"sanity"}, description = "verify user count")
    public void verifyUserCount() {
        Response res = ReqresUsers.getUsers();
        System.out.println(res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(), 200, "Statuscode not 200");
        System.out.println(res.jsonPath().getInt("total")); // To get total from json response
    }

    @TmsLink("RP-12348")
    @Severity(SeverityLevel.BLOCKER)
    @Story("RP-125")
    @Test(groups = {"sanity"}, description = "verify delayed response")
    public void verifyDelayedResponse() {
        Response res = ReqresUsers.getUsers();
        System.out.println(res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(), 200, "Statuscode not 200");
        System.out.println(res.jsonPath().getInt("total")); // To get total from json response
    }
}
