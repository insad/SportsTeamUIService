package org.javamagazine.sportsteamuiservice.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import org.javamagazine.sportsteamuiservice.entity.TeamRoster;

/**
 *
 * @author juneau
 */
@Named
@RequestScoped
public class TeamQueryController {

    private Client client = ClientBuilder.newClient();

    private WebTarget resource = null;

    private List<TeamRoster> rosterList;

    @PostConstruct
    public void populateRoster() {
        resource = client
                .target("http://localhost:8080/SportsTeamQueryService/rest")
                .path("teamrosterqueryservice")
                .path("findAll");
        setRosterList(resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(
                    new GenericType<List<TeamRoster>>() {
            }));
        System.out.println("List size: " + rosterList.size());
    }

    /**
     * @return the rosterList
     */
    public List<TeamRoster> getRosterList() {
        if (rosterList == null) {
            populateRoster();
        }
        return rosterList;
    }

    /**
     * @param rosterList the rosterList to set
     */
    public void setRosterList(List<TeamRoster> rosterList) {
        this.rosterList = rosterList;
    }

}
