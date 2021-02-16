package pl.j.piotr.java.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.j.piotr.java.Database.SessionProvider;
import pl.j.piotr.java.Model.Car;
import pl.j.piotr.java.Model.CarStatus;

import java.util.List;

public class CarDao extends AbstractDao {
    public CarDao() { super(Car.class);}
    public Car findCarById(String id) {
        Session session = SessionProvider.getSession();
        Car car = session.find(Car.class, id);
        session.close();
        return car;
    }

    public void deleteCarById(String id) {
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Car.class, id));
        transaction.commit();
        session.close();
    }

    public List<Car> findAllCarsByStatus (CarStatus carStatus){
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        List<Car> records = session.createQuery("from Car where carStatus = :carStatus", Car.class)
                .setParameter("carStatus", carStatus)
                .list();
        transaction.commit();
        session.close();
        return records;
    }
}