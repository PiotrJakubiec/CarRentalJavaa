package pl.j.piotr.java.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.j.piotr.java.Database.SessionProvider;
import pl.j.piotr.java.Model.Rent;
import pl.j.piotr.java.Model.RentStatus;


import java.util.List;

public class RentDao extends AbstractDao {

    public RentDao(){
        super(Rent.class);
    }


    public List<Rent> findAllRentByStatus (RentStatus rentStatus){
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        List<Rent> records = session.createQuery("from Rent where rentStatus = :rentStatus", Rent.class)
                .setParameter("rentStatus", rentStatus)
                .list();
        transaction.commit();
        session.close();
        return records;
    }
}
