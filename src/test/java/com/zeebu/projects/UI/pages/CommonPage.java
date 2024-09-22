package com.zeebu.projects.UI.pages;

public class CommonPage {

    private PoolsPage poolsPage;
    private IndividualPoolPage individualPoolPage;
    private BalancerHomePage balancerHomePage;

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
}
