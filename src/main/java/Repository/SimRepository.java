package Repository;

import Entity.SimCard;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


//Here we are using @Application scopped annotaition so that we have have the object of the below class injected
//Whenever it is required
@ApplicationScoped
public class SimRepository implements PanacheRepository<SimCard> {
}
