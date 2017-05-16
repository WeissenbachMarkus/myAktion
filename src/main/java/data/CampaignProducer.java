package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.Campaign;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.inject.Produces;

/**
 *
 * @author markus
 */
@SessionScoped
public class CampaignProducer implements Serializable {

    private static final long serialVersionUID = -1828660647917534556L;

    private enum Mode {
        EDIT, ADD
    }
    private Campaign campaign;
    private Mode mode;

    @Named
    @Produces
    public Campaign getSelectedCampaign() {
        return campaign;
    }

    public void setSelectedCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @Named
    @Produces
    public boolean isAddMode() {
        return mode == Mode.ADD;
    }

    public void prepareAddCampaign() {
        this.campaign = new Campaign();
       
        this.mode = Mode.ADD;
    }

    public void prepareEditCampaign(Campaign campaign) {
        this.campaign = campaign;
        this.mode = Mode.EDIT;

    }
    // public void deleteCampaing
}
