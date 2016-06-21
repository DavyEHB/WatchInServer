/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.service;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author davy.van.belle
 */
@javax.ws.rs.ApplicationPath("data")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        // Add Jackson feature.
        resources.add(JacksonFeature.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(be.ehb.service.ContactsFacadeREST.class);
        resources.add(be.ehb.service.EventFacadeREST.class);
        resources.add(be.ehb.service.PersonFacadeREST.class);
        resources.add(be.ehb.service.PersoneventFacadeREST.class);
        resources.add(be.ehb.service.PersonmeetFacadeREST.class);
        resources.add(be.ehb.service.SkillsFacadeREST.class);
    }
    
}
