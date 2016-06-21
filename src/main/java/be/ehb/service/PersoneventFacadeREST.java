/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.service;

import be.ehb.Personevent;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author davy.van.belle
 */
@Stateless
@Path("personevent")
public class PersoneventFacadeREST extends AbstractFacade<Personevent> {

    @PersistenceContext(unitName = "WatchInServerPU")
    private EntityManager em;

    public PersoneventFacadeREST() {
        super(Personevent.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Personevent entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Personevent entity) {
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
    public Personevent find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Personevent> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Personevent> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("P_ID/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Personevent> findByPerson(@PathParam("id") Integer p_id) {
        System.out.println("Searching events for: " + p_id);
        javax.persistence.Query q = getEntityManager().createNamedQuery("Personevent.findByP_ID", Personevent.class);
        q.setParameter("P_ID", p_id);
        return q.getResultList();
    }
    
    @GET
    @Path("E_ID/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Personevent> findByEvent(@PathParam("id") Integer e_id) {
        System.out.println("Searching persons for: " + e_id);
        javax.persistence.Query q = getEntityManager().createNamedQuery("Personevent.findByE_ID", Personevent.class);
        q.setParameter("E_ID", e_id);
        return q.getResultList();
    }
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
