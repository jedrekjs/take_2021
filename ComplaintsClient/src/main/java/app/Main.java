/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        if(args.length != 1){
            args[0] = "252";
        }
        
        Client client = ClientBuilder.newClient();
        String count
                = client.target("http://localhost:8080/Complaints/resources/complaints/count")
                        .request(MediaType.TEXT_PLAIN)
                        .get(String.class);

        System.out.println("Count: " + count);

        String allComplaints = client.target("http://localhost:8080/Complaints/resources/complaints/")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        System.out.println("All: " + allComplaints);
        
        String openComplaints = client.target("http://localhost:8080/Complaints/resources/complaints/?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        System.out.println("Open: " + openComplaints);
        
        //run with argument to select other open
        Complaint openComplaint = client.target("http://localhost:8080/Complaints/resources/complaints/" + args[0])
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint.class);
        String open = openComplaint.toString();
        
        System.out.println("Selected open: " + open);
        
        openComplaint.setStatus("closed");
        client.target("http://localhost:8080/Complaints/resources/complaints/" + args[0])
                .request()
                .put(Entity.entity(openComplaint, MediaType.APPLICATION_JSON));
        String closed = openComplaint.toString();
        System.out.println("Closed: " + closed);
        
        client.close();
    }
}
