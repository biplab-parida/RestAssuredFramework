package com.biplab.qa.test;

import com.biplab.qa.services.ReqresUsers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresUserTest {

   @Test
   public void verifyUserCount()
   {
       Response res = ReqresUsers.getUsers();
       System.out.println(res.getStatusCode());
       Assert.assertEquals(res.getStatusCode(),200,"Statuscode not 200");
       System.out.println(res.jsonPath().getInt("total")); // To get total from json response
   }

    @Test
    public void verifyDelayedResponse()
    {
        Response res = ReqresUsers.getUsers();
        System.out.println(res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(),200,"Statuscode not 200");
        System.out.println(res.jsonPath().getInt("total")); // To get total from json response
    }
}
