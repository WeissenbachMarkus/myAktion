/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Pages;
import data.CampaignProducer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Campaign;

/**
 *
 * @author markus
 */
@SessionScoped
@Named
public class ListDonationsController implements Serializable {

    private static final long serialVersionUID = 437878972432L;

    @Inject
    private CampaignProducer campaignProducer;
    private Campaign campaignToDelete;

    public String doOk() {
        return Pages.LIST_CAMPAIGNS;
    }

    public String doListDonations(Campaign campaign) {
        campaignProducer.setSelectedCampaign(campaign);
        return Pages.LIST_DONATIONS;
    }

    public void doDeleteCampaign(Campaign campaign) {
        this.campaignToDelete = campaign;
        System.out.println("Aktion zum löschen vorgemerkt");
    }

    public void commitDeleteCampaign() {
        System.out.println("Aktion löschen noch nicht implementiert");
    }
}
