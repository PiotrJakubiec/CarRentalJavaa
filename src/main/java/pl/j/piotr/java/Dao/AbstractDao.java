package pl.j.piotr.java.Dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.j.piotr.java.Database.SessionProvider;
import java.util.List;

public abstract class  AbstractDao<T> {

    private final Class<T> clas;

    protected AbstractDao(Class<T> clas) { this.clas = clas;}

    public T findById(int id) {
        Session session = SessionProvider.getSession();
        T record = session.find(clas, id);
        session.close();
        return record;
    }

    public List<T> findAll() {
        Session session = SessionProvider.getSession();
        List<T> records = session.createQuery("from" + clas.getCannonicalName(), clas). list();
        session.close();
        return records;

    }

    public void add(T record) {
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(record);
        transaction.commit();
        session.close();
    }

    public void update(T record) {
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(record);
        transaction.commit();
        session.close
    }

    public void deleteById(int id) {
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(clas, id));
        transaction.commit();
        session.close();
    }
}