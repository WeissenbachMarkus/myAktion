/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.CampaignProducer;
import data.CampaignListProducer;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 *
 * @author markus
 */
@SessionScoped
@Named
public class EditCampaignController implements Serializable {

    private static final long serialVersionUID = 2815796004558360299L;

    @Inject
    private CampaignListProducer campaignListProducer;
    @Inject
    private CampaignProducer campaignProducer;

    public String doSave() {
        if (campaignProducer.isAddMode()) {
            campaignListProducer.getCampaigns().add(
                    campaignProducer.getSelectedCampaign());
        }
        return Pages.LIST_CAMPAIGNS;
    }

    public String doCancel() {
        return Pages.LIST_CAMPAIGNS;
    }
    
    public String backToList()
    {
       
        return "listCampaings.xhtml";
    }

}
