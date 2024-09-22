package com.zeebu.projects.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static com.zeebu.constants.FrameworkConstants.*;

public class Post {

    public Response call_BalancerAPI_toFetch_OnePoolData(String chain, String poolId) {
        // Define the base URL
        RestAssured.baseURI = APIBaseURL;

        // Create a JSON body for the request
        JSONObject requestBody = new JSONObject();
        requestBody.put("query", "query GetPool($id: String!, $chain: GqlChain!, $userAddress: String) {\n" +
                "  pool: poolGetPool(id: $id, chain: $chain, userAddress: $userAddress) {\n" +
                "    id\n    address\n    name\n    version\n    owner\n    decimals\n    factory\n    symbol\n" +
                "    createTime\n    type\n    chain\n    protocolVersion\n    tags\n    dynamicData {\n" +
                "      poolId\n      swapEnabled\n      totalLiquidity\n      totalShares\n      fees24h\n" +
                "      surplus24h\n      swapFee\n      volume24h\n      holdersCount\n      isInRecoveryMode\n" +
                "      isPaused\n      aprItems {\n        id\n        title\n        apr\n        type\n" +
                "        rewardTokenSymbol\n        rewardTokenAddress\n        __typename\n      }\n      __typename\n" +
                "    }\n    allTokens {\n      id\n      address\n      name\n      symbol\n      decimals\n" +
                "      isNested\n      isPhantomBpt\n      isMainToken\n      __typename\n    }\n    displayTokens {\n" +
                "      id\n      address\n      name\n      weight\n      symbol\n      nestedTokens {\n        id\n" +
                "        address\n        name\n        weight\n        symbol\n        __typename\n      }\n      __typename\n" +
                "    }\n    staking {\n      id\n      type\n      chain\n      address\n      gauge {\n        id\n" +
                "        gaugeAddress\n        version\n        status\n        workingSupply\n        otherGauges {\n" +
                "          gaugeAddress\n          version\n          status\n          id\n          rewards {\n" +
                "            id\n            tokenAddress\n            rewardPerSecond\n            __typename\n" +
                "          }\n          __typename\n        }\n        rewards {\n          id\n          rewardPerSecond\n" +
                "          tokenAddress\n          __typename\n        }\n        __typename\n      }\n      aura {\n        id\n" +
                "        apr\n        auraPoolAddress\n        auraPoolId\n        isShutdown\n        __typename\n      }\n" +
                "      __typename\n    }\n    userBalance {\n      totalBalance\n      totalBalanceUsd\n" +
                "      walletBalance\n      walletBalanceUsd\n      stakedBalances {\n        balance\n        balanceUsd\n" +
                "        stakingType\n        stakingId\n        __typename\n      }\n      __typename\n    }\n" +
                "    ... on GqlPoolWeighted {\n      nestingType\n      poolTokens {\n        ... on GqlPoolTokenDetail {\n" +
                "          id\n          index\n          name\n          symbol\n          balance\n          balanceUSD\n" +
                "          address\n          priceRate\n          decimals\n          weight\n          hasNestedPool\n" +
                "          isAllowed\n          priceRateProvider\n          priceRateProviderData {\n" +
                "            ...PriceRateProviderDataFields\n            __typename\n          }\n          nestedPool {\n" +
                "            id\n            address\n            type\n            tokens {\n              index\n" +
                "              address\n              decimals\n              __typename\n            }\n            __typename\n" +
                "          }\n          isAllowed\n          __typename\n        }\n        __typename\n      }\n" +
                "      __typename\n    }\n    ... on GqlPoolStable {\n      amp\n      poolTokens {\n        ... on GqlPoolTokenDetail {\n" +
                "          id\n          index\n          name\n          symbol\n          balance\n          balanceUSD\n" +
                "          address\n          priceRate\n          decimals\n          weight\n          hasNestedPool\n" +
                "          isAllowed\n          priceRateProvider\n          priceRateProviderData {\n" +
                "            ...PriceRateProviderDataFields\n            __typename\n          }\n          nestedPool {\n" +
                "            id\n            address\n            type\n            tokens {\n              index\n" +
                "              address\n              decimals\n              __typename\n            }\n            __typename\n" +
                "          }\n          isAllowed\n          __typename\n        }\n        __typename\n      }\n" +
                "      __typename\n    }\n    ... on GqlPoolMetaStable {\n      amp\n      poolTokens {\n        ... on GqlPoolTokenDetail {\n" +
                "          id\n          index\n          name\n          symbol\n          balance\n          balanceUSD\n" +
                "          address\n          priceRate\n          decimals\n          weight\n          hasNestedPool\n" +
                "          isAllowed\n          priceRateProvider\n          priceRateProviderData {\n" +
                "            ...PriceRateProviderDataFields\n            __typename\n          }\n          nestedPool {\n" +
                "            id\n            address\n            type\n            tokens {\n              index\n" +
                "              address\n              decimals\n              __typename\n            }\n            __typename\n" +
                "          }\n          isAllowed\n          __typename\n        }\n        __typename\n      }\n" +
                "      __typename\n    }\n    ... on GqlPoolElement {\n      unitSeconds\n      principalToken\n      baseToken\n" +
                "      poolTokens {\n        ... on GqlPoolTokenDetail {\n          id\n          index\n          name\n" +
                "          symbol\n          balance\n          balanceUSD\n          address\n          priceRate\n" +
                "          decimals\n          weight\n          hasNestedPool\n          isAllowed\n          priceRateProvider\n" +
                "          priceRateProviderData {\n            ...PriceRateProviderDataFields\n            __typename\n" +
                "          }\n          nestedPool {\n            id\n            address\n            type\n" +
                "            tokens {\n              index\n              address\n              decimals\n              __typename\n" +
                "            }\n            __typename\n          }\n          isAllowed\n          __typename\n" +
                "        }\n        __typename\n      }\n      __typename\n    }\n    ... on GqlPoolComposableStable {\n" +
                "      amp\n      nestingType\n      bptPriceRate\n      poolTokens {\n        ... on GqlPoolTokenDetail {\n" +
                "          id\n          index\n          name\n          symbol\n          balance\n          balanceUSD\n" +
                "          address\n          priceRate\n          decimals\n          weight\n          hasNestedPool\n" +
                "          isAllowed\n          priceRateProvider\n          priceRateProviderData {\n" +
                "            ...PriceRateProviderDataFields\n            __typename\n          }\n          nestedPool {\n" +
                "            id\n            address\n            type\n            tokens {\n              index\n" +
                "              address\n              decimals\n              __typename\n            }\n            __typename\n" +
                "          }\n          isAllowed\n          __typename\n        }\n        __typename\n      }\n" +
                "      __typename\n    }\n    ... on GqlPoolLiquidityBootstrapping {\n      name\n      nestingType\n" +
                "      poolTokens {\n        ... on GqlPoolTokenDetail {\n          id\n          index\n          name\n" +
                "          symbol\n          balance\n          balanceUSD\n          address\n          priceRate\n" +
                "          decimals\n          weight\n          hasNestedPool\n          isAllowed\n          priceRateProvider\n" +
                "          priceRateProviderData {\n            ...PriceRateProviderDataFields\n            __typename\n" +
                "          }\n          nestedPool {\n            id\n            address\n            type\n            tokens {\n" +
                "              index\n              address\n              decimals\n              __typename\n            }\n" +
                "            __typename\n          }\n          isAllowed\n          __typename\n        }\n        __typename\n" +
                "      }\n      __typename\n    }\n    ... on GqlPoolGyro {\n      alpha\n      beta\n      type\n      c\n      dSq\n" +
                "      lambda\n      root3Alpha\n      s\n      sqrtAlpha\n      sqrtBeta\n      tauAlphaX\n      tauAlphaY\n" +
                "      tauBetaX\n      tauBetaY\n      u\n      v\n      w\n      z\n      nestingType\n      poolTokens {\n" +
                "        ... on GqlPoolTokenDetail {\n          id\n          index\n          name\n          symbol\n" +
                "          balance\n          balanceUSD\n          address\n          priceRate\n          decimals\n" +
                "          weight\n          hasNestedPool\n          isAllowed\n          priceRateProvider\n" +
                "          priceRateProviderData {\n            ...PriceRateProviderDataFields\n            __typename\n" +
                "          }\n          nestedPool {\n            id\n            address\n            type\n            tokens {\n" +
                "              index\n              address\n              decimals\n              __typename\n            }\n" +
                "            __typename\n          }\n          isAllowed\n          __typename\n        }\n        __typename\n" +
                "      }\n      __typename\n    }\n    ... on GqlPoolFx {\n      alpha\n      beta\n      delta\n" +
                "      epsilon\n      lambda\n      poolTokens {\n        ... on GqlPoolTokenDetail {\n" +
                "          id\n          index\n          name\n          symbol\n          balance\n          balanceUSD\n" +
                "          address\n          priceRate\n          decimals\n          weight\n          hasNestedPool\n" +
                "          isAllowed\n          priceRateProvider\n          priceRateProviderData {\n" +
                "            ...PriceRateProviderDataFields\n            __typename\n          }\n          nestedPool {\n" +
                "            id\n            address\n            type\n            tokens {\n              index\n" +
                "              address\n              decimals\n              __typename\n            }\n            __typename\n" +
                "          }\n          isAllowed\n          __typename\n        }\n        __typename\n      }\n" +
                "      __typename\n    }\n    __typename\n  }\n}\n\nfragment PriceRateProviderDataFields on GqlPriceRateProviderData {\n" +
                "  address\n  name\n  summary\n  reviewed\n  warnings\n  upgradeableComponents {\n    entryPoint\n" +
                "    implementationReviewed\n    __typename\n  }\n  reviewFile\n  factory\n  __typename\n}");

        // Define the variables
        JSONObject variables = new JSONObject();
        variables.put("id", poolId);
        variables.put("chain",chain);
        variables.put("userAddress", "");

        // Add variables to the body
        requestBody.put("variables", variables);

        // Send the POST request and capture the response
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post();

        // Print the response
        System.out.println("Response: " + response.prettyPrint());
        return response;
    }

    public Response call_BalancerAPI_toFetch_PoolsData(String[] chain, String[] poolType, int TVL) {
        // Define the base URL
        RestAssured.baseURI = APIBaseURL;

        String query = "query GetPools($first: Int, $skip: Int, $orderBy: GqlPoolOrderBy, $orderDirection: GqlPoolOrderDirection, $where: GqlPoolFilter, $textSearch: String) {\n" +
                "  pools: poolGetPools(\n" +
                "    first: $first\n" +
                "    skip: $skip\n" +
                "    orderBy: $orderBy\n" +
                "    orderDirection: $orderDirection\n" +
                "    where: $where\n" +
                "    textSearch: $textSearch\n" +
                "  ) {\n" +
                "    address\n" +
                "    chain\n" +
                "    createTime\n" +
                "    decimals\n" +
                "    protocolVersion\n" +
                "    tags\n" +
                "    displayTokens {\n" +
                "      id\n" +
                "      address\n" +
                "      name\n" +
                "      weight\n" +
                "      symbol\n" +
                "      nestedTokens {\n" +
                "        id\n" +
                "        address\n" +
                "        name\n" +
                "        weight\n" +
                "        symbol\n" +
                "        __typename\n" +
                "      }\n" +
                "      __typename\n" +
                "    }\n" +
                "    dynamicData {\n" +
                "      totalLiquidity\n" +
                "      lifetimeVolume\n" +
                "      lifetimeSwapFees\n" +
                "      volume24h\n" +
                "      fees24h\n" +
                "      holdersCount\n" +
                "      swapFee\n" +
                "      swapsCount\n" +
                "      totalShares\n" +
                "      aprItems {\n" +
                "        id\n" +
                "        title\n" +
                "        apr\n" +
                "        type\n" +
                "        rewardTokenSymbol\n" +
                "        rewardTokenAddress\n" +
                "        __typename\n" +
                "      }\n" +
                "      __typename\n" +
                "    }\n" +
                "    staking {\n" +
                "      id\n" +
                "      type\n" +
                "      chain\n" +
                "      address\n" +
                "      gauge {\n" +
                "        id\n" +
                "        gaugeAddress\n" +
                "        version\n" +
                "        status\n" +
                "        workingSupply\n" +
                "        otherGauges {\n" +
                "          gaugeAddress\n" +
                "          version\n" +
                "          status\n" +
                "          id\n" +
                "          rewards {\n" +
                "            id\n" +
                "            tokenAddress\n" +
                "            rewardPerSecond\n" +
                "            __typename\n" +
                "          }\n" +
                "          __typename\n" +
                "        }\n" +
                "        rewards {\n" +
                "          id\n" +
                "          rewardPerSecond\n" +
                "          tokenAddress\n" +
                "          __typename\n" +
                "        }\n" +
                "        __typename\n" +
                "      }\n" +
                "      aura {\n" +
                "        id\n" +
                "        apr\n" +
                "        auraPoolAddress\n" +
                "        auraPoolId\n" +
                "        isShutdown\n" +
                "        __typename\n" +
                "      }\n" +
                "      __typename\n" +
                "    }\n" +
                "    factory\n" +
                "    id\n" +
                "    name\n" +
                "    owner\n" +
                "    symbol\n" +
                "    type\n" +
                "    userBalance {\n" +
                "      totalBalance\n" +
                "      totalBalanceUsd\n" +
                "      walletBalance\n" +
                "      walletBalanceUsd\n" +
                "      stakedBalances {\n" +
                "        balance\n" +
                "        balanceUsd\n" +
                "        stakingType\n" +
                "        stakingId\n" +
                "        __typename\n" +
                "      }\n" +
                "      __typename\n" +
                "    }\n" +
                "    __typename\n" +
                "  }\n" +
                "  count: poolGetPoolsCount(\n" +
                "    first: $first\n" +
                "    skip: $skip\n" +
                "    orderBy: $orderBy\n" +
                "    orderDirection: $orderDirection\n" +
                "    where: $where\n" +
                "    textSearch: $textSearch\n" +
                "  )\n}";

        // Create the variables object using JSONObject
        JSONObject where = new JSONObject();
        where.put("poolTypeIn", poolType);
        where.put("chainIn", chain);
        where.put("userAddress", JSONObject.NULL);
        where.put("minTvl", TVL);
        where.put("tagIn", JSONObject.NULL);
        where.put("tagNotIn", new String[]{"BLACK_LISTED"});

        JSONObject variables = new JSONObject();
        variables.put("first", 20);
        variables.put("skip", 0);
        variables.put("orderBy", "totalLiquidity");
        variables.put("orderDirection", "desc");
        variables.put("where", where);
        variables.put("textSearch", JSONObject.NULL);

        // Create the final payload JSON object
        JSONObject payload = new JSONObject();
        payload.put("query", query);
        payload.put("variables", variables);

        // Make the request
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")// Replace with your actual API key
                .body(payload.toString())
                .post();

        // Print the response
        System.out.println(response.prettyPrint());
        return response;

    }
}
