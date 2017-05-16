/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import model.Campaign;
import util.TestQualifier.MyService;

/**
 *
 * @author markus
 */
@RequestScoped
//@MyService
public class CampaignServiceBean implements CampaignService {

    @Override
    public List<Campaign> getAllCampaigns() {
        return new LinkedList<Campaign>();
    }
}
