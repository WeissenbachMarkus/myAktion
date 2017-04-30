package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.Campaign;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 *
 * @author markus
 */

@SessionScoped
@Named
public class ListCampaignsController implements Serializable {

    private static final long serialVersionUID = 8693277383648025822L;

    public String doAddCampaign() {
        System.out.println("Add Campaign");
        return Pages.EDIT_CAMPAIGN;
    }

    public String doEditCampaign(Campaign campaign) {
        System.out.println("Edit Campaign " + campaign);
        return Pages.EDIT_CAMPAIGN;
    }

    public String doEditDonationForm(Campaign campaign) {
        System.out.println("Edit Donation Form of Campaign " + campaign);
        return Pages.EDIT_DONATION_FORM;
    }

    public String doListDonations(Campaign campaign) {
        System.out.println("List Donations of Campaign " + campaign);
        return Pages.LIST_DONATIONS;
    }

    public void doDeleteCampaign(Campaign campaign) {
        System.out.println("Deletion not implemented, yet!");
    }
}
