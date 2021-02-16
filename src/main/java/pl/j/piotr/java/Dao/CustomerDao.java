package pl.j.piotr.java.Dao;

import org.hibernate.Session;
import pl.j.piotr.java.Database.SessionProvider;
import pl.j.piotr.java.Model.Customer;

import java.util.List;

public class CustomerDao extends AbstractDao{

    public CustomerDao(){
        super(Customer.class);

    }

    public List<Customer> findCustomerByAll(int id,String firstName, String lastName, String street, String houseNumber, String city, String postalCode) {
        Session session = SessionProvider.getSession();
        List<Customer> records = session.createQuery("from Customer where  id = :id and firstName =:firstName and lastName =:lastName and street =:street and houseNumber =:houseNumber and city =:city and postalCode =:postalCode", Customer.class)
                .setParameter("id", id)
                .setParameter("firstName",firstName)
                .setParameter("lastName",lastName)
                .setParameter("street",street)
                .setParameter("houseNumber",houseNumber)
                .setParameter("city",city)
                .setParameter("postalCode",postalCode)
                .list();
        session.close();

        return records;
    }

}