package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import data.CampaignProducer;
import model.Campaign;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import util.Events.Deleted;

/**
 *
 * @author markus
 */
@SessionScoped
@Named
public class ListCampaignsController implements Serializable {

    @Inject
    private CampaignProducer campaignProducer;
    
    @Inject @Deleted
    private Event<Campaign> campaignDeleteEvent;
    private Campaign campaingToDelete;
    

    private static final long serialVersionUID = 8693277383648025822L;

    public String doAddCampaign() {
        campaignProducer.prepareAddCampaign();
        return Pages.EDIT_CAMPAIGN;
    }

    public String doEditCampaign(Campaign campaign) {
        campaignProducer.prepareEditCampaign(campaign);
        return Pages.EDIT_CAMPAIGN;
    }

    public String doEditDonationForm(Campaign campaign) {
        campaignProducer.setSelectedCampaign(campaign);
        return Pages.EDIT_DONATION_FORM;
    }

    public String doListDonations(Campaign campaign) {
        campaignProducer.setSelectedCampaign(campaign);
        return Pages.LIST_DONATIONS;
    }

    public void doDeleteCampaign(Campaign campaign) {
        this.campaingToDelete=campaign;
        System.out.println("Läschen vermerkt");
    }
    
    public void commitDeleteCampaign()
    {
      this.campaignDeleteEvent.fire(this.campaingToDelete);
    }
   

}
