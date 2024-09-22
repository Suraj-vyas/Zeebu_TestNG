package com.zeebu.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zeebu.reusableLibrary.pojo.Pool;
import com.zeebu.projects.API.Post;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sampleTest {

    @Test
    public void sample() throws JsonProcessingException {
        Pool pool= new Pool();
        pool.setAddress("abc");
        pool.setChain("MAINNET");
        pool.setId("0x382dc5b2eca1c1308eb7e2b40c0f571afb899ac8000100000000000000000557");
        pool.setName("name");
        pool.setSymbol("symbol");

        Post API = new Post();
        Response res=API.call_BalancerAPI_toFetch_PoolsData(new String[]{"MAINNET"}, new String[]{"WEIGHTED"},0);
        Assert.assertEquals(res.statusCode(),200);
    }
}
