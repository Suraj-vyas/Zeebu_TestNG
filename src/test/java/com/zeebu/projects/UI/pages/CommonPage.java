package com.zeebu.projects.UI.pages;

import com.zeebu.projects.API.Post;

public class CommonPage {

    private PoolsPage poolsPage;
    private IndividualPoolPage individualPoolPage;
    private BalancerHomePage balancerHomePage;
    private SwapPage swapPage;
    private Post post;

    public PoolsPage getPoolsPage() {
        if (poolsPage == null) {
            poolsPage = new PoolsPage();
        }
        return poolsPage;
    }

    public IndividualPoolPage getIndividualPoolPage() {
        if (individualPoolPage == null) {
            individualPoolPage = new IndividualPoolPage();
        }
        return individualPoolPage;
    }

    public BalancerHomePage getBalancerHomePage() {
        if (balancerHomePage == null) {
            balancerHomePage = new BalancerHomePage();
        }
        return balancerHomePage;
    }

    public SwapPage getSwapPage() {
        if (swapPage == null) {
            swapPage = new SwapPage();
        }
        return swapPage;
    }

    public Post getPost() {
        if (post == null) {
            post = new Post();
        }
        return post;
    }
}
