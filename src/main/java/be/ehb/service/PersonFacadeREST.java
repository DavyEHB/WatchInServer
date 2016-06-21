/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.service;

import be.ehb.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author davy.van.belle
 */
@Stateless

@Path("persons")
public class PersonFacadeREST extends AbstractFacade<Person> {
    
    @Context  //injected response proxy supporting multiple threads
    private HttpServletResponse response;

    @PersistenceContext(unitName = "WatchInServerPU")
    private EntityManager em;

    public PersonFacadeREST() {
        super(Person.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Person entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Person entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Person> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("email/{email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public JsonObject checkMail(@PathParam("email") String email) {
        Person person = null;
        System.out.println("Checking email for: " + email);
        javax.persistence.Query q = getEntityManager().createNamedQuery("Person.findByEmail", Person.class);
        q.setParameter("email", email);
        
        try {
            person = (Person) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Email not found");
            throw new NotFoundException();
        }
        
        System.out.println("Found one");
        
        JsonObject myObject = Json.createObjectBuilder()
        .add("ID", person.getID())
        .add("email",person.getEmail())
        .build();
        return myObject;
    }
    
    @GET
    @Path("mutual/{myID}/{cID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> findMutual(@PathParam("myID") Integer myID, @PathParam("cID") Integer cID) {
        List<Person> persons = null;
        System.out.println("finding mutual contacts for " + myID + " and " + cID);
        //javax.persistence.Query q = getEntityManager().createNamedQuery("Person.findMutualContacts", Person.class);
        javax.persistence.StoredProcedureQuery q = getEntityManager().createStoredProcedureQuery("getMutualContacts", Person.class);
      
        q.registerStoredProcedureParameter("aID", Integer.class, ParameterMode.IN);
        q.registerStoredProcedureParameter("bID", Integer.class, ParameterMode.IN);
        
        q.setParameter("aID", myID);
        q.setParameter("bID", cID);
        
        try {
            persons = q.getResultList();
        } catch (Exception e) {
            System.out.println("no mutual not found");
            throw new NotFoundException();
        }
        
        System.out.println("Found some");
        
        return persons;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
