package be.ehb;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-21T11:51:10")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, String> name;
    public static volatile SingularAttribute<Event, Date> startTime;
    public static volatile SingularAttribute<Event, String> location;
    public static volatile SingularAttribute<Event, Integer> ID;
    public static volatile SingularAttribute<Event, Date> endTime;
    public static volatile SingularAttribute<Event, String> UUID;

}