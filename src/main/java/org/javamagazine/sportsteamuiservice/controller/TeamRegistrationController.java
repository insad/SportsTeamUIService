package org.javamagazine.sportsteamuiservice.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.javamagazine.sportsteamuiservice.entity.TeamRoster;
import org.javamagazine.sportsteamuiservice.utility.JsfUtils;

/**
 * Request scoped container for use with registering player records.
 * 
 * @author juneau
 */
@Named
@RequestScoped
public class TeamRegistrationController {
    
    @Inject
    TeamQueryController teamQueryController;
    
    private Client client = ClientBuilder.newClient();
   
    private WebTarget resource = null;
    
    private TeamRoster teamRoster;
    
    /**
     * Action method used to register a player.  Utilizes a JAX-RS client to post
     * a <code>javax.ws.rs.core.Form</code> to register parameters received via user
     * input from the index.xhtml view.  <code>InvocationBuilder</code> is used to
     * post the form and obtain a <code>javax.ws.rs.core.Response</code> to indicate
     * whether the post was successful.
     */
    public void registerPlayer(){
        resource = client
                .target("http://localhost:8080/SportsTeamRegistrationService/rest")
                .path("teamrosterregistrationservice").path("addPlayer");
        
      
        Form form = new Form();
        form.param("firstName", teamRoster.getFirstName());
        form.param("lastName", teamRoster.getLastName());
        form.param("position", teamRoster.getPosition());

       
        Invocation.Builder invocationBuilder = resource.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), Response.class);
        if (response.getStatus() == Response.Status.CREATED.getStatusCode() || response.getStatus() == Response.Status.OK.getStatusCode()) {
            teamQueryController.setRosterList(null);
            JsfUtils.addSuccessMessage("Player Successfully Added to Roster");
        } else {
  
            JsfUtils.addErrorMessage("Player Not Added...Error Occurred, Please Try Again");

        }
    }
    
    /**
     * Returns <code>TeamRoster</code> object.  If the object is null then a
     * new <code>TeamRoster</code> is instantiated.
     * @return 
     */
    public TeamRoster getTeamRoster(){
        if(teamRoster == null){
            teamRoster = new TeamRoster();
        }
        return this.teamRoster;
    }
    
    /**
     * Sets a <code>TeamRoster</code> object.
     * 
     * @param teamRoster 
     */
    public void setTeamRoster(TeamRoster teamRoster){
        this.teamRoster = teamRoster;
    }
    
}
