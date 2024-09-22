package com.zeebu.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeebu.annotations.FrameworkAnnotation;
import com.zeebu.constants.FrameworkConstants;
import com.zeebu.enums.AuthorType;
import com.zeebu.enums.CategoryType;
import com.zeebu.enums.TestScenarioType;
import com.zeebu.reusableLibrary.common.Base;
import com.zeebu.reusableLibrary.dataProvider.dataProviderManager;
import com.zeebu.reusableLibrary.pojo.Pool;
import com.zeebu.utils.ExcelUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class IndividualPoolPageTest extends Base {

    @FrameworkAnnotation(author = {AuthorType.Suraj}, category = {CategoryType.SANITY}, scenario = {TestScenarioType.POSITIVE})
    @Test(dataProvider = "csvLoginData", dataProviderClass = dataProviderManager.class,description = "Validating the One Pool data on Balancer Individual Pool Page")
    public void Validate_One_Pool_Data_for_SupportedNetworks(String Network) throws JsonProcessingException {
//        String Network = (String) testData.get("PoolNetwork");
        getPoolsPage().navigateToPoolsPage();
        getPoolsPage().isUserOnPoolsPage();
        //Applying the Network Filter
        getPoolsPage().NetworkFilter(Network);
        //Clicking the first pool from the list
        String PoolID = getIndividualPoolPage().gotoFirstPoolAndReturnID();
        //Verifying the user is on Pool Page or not
        getIndividualPoolPage().isUserOnPoolPage();
        //Setting the POJO File for API Validation
        Pool pool= new Pool();
        pool.setChain(Network);
        pool.setId(PoolID);
        //Calling the API for same pool Data and same network
        Response response = getPost().call_BalancerAPI_toFetch_OnePoolData(Network, PoolID);
        //Validating the Response Status Code
        Assert.assertEquals(response.statusCode(),200);
        //Storing the response body into Json path
        JsonPath JSONResponse = response.getBody().jsonPath();
        //Validating the Pool Id with UI and API
        Assert.assertEquals(PoolID, JSONResponse.getString("data.pool.id"), "Validation of Total pools in UI with API");
        //Validating the Pool Creation Time with UI and API
        getIndividualPoolPage().validatePoolCreationDate(JSONResponse.getLong("data.pool.createTime"));
        //Validating the Pool Type with UI and API
        getIndividualPoolPage().validatePoolType(JSONResponse.getString("data.pool.type"));
        //Validating the Pool address with UI and API
        getIndividualPoolPage().validatePoolAddress(JSONResponse.getString("data.pool.address"));
        //Validating the Pool Name with UI and API
        getIndividualPoolPage().validatePoolName(JSONResponse.getString("data.pool.name"));
    }
}
