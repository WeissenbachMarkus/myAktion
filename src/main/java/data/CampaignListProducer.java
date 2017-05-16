/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Services.CampaignService;
import model.Account;
import model.Campaign;
import model.Donation;
import model.Donation.Status;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import util.Events.Added;
import util.Events.Deleted;
import util.TestQualifier.MyService;

/**
 *
 * @author markus
 */
@SessionScoped
public class CampaignListProducer implements Serializable {

    private static final long serialVersionUID = -182866064791747156L;
    private List<Campaign> campaigns;

    /* public CampaignListProducer() {
        campaigns = createMockCampaigns();
    }*/
    @Inject
    @MyService
    private CampaignService campaignService;

    @PostConstruct
    public void init() {
        this.campaigns = campaignService.getAllCampaigns();
    }

    @Named
    @Produces
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void onCampaignAdded(@Observes @Added Campaign campaign) {
        this.getCampaigns().add(campaign);
    }

    public void onCampaignDeleted(@Observes @Deleted Campaign campaign) {
        this.getCampaigns().remove(campaign);
    }

}
