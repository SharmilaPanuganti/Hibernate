package cgg.hibernate;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program started" );
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        // System.out.println(sessionFactory);
        // System.out.println(sessionFactory.isClosed());
        Student student = new Student();   //Creating student object
        student.setId(106);
        student.setName("Madhu");
        student.setCity("KNR");
        Address address=new Address();
        
        address.setStreet("Ganeshnagar");
        address.setCity("DRM");
        address.setAddedDate(new Date());
        address.setOpen(false);
        address.setX(32.34);
        try {
            FileInputStream img = new FileInputStream("src\\main\\java\\cgg\\hibernate\\img1.jpg");
            byte[] data=new byte[img.available()];
            img.read(data);
            address.setImage(data);
            img.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Session session = sessionFactory.openSession();   //open session
        //start transaction
        Transaction tx = session.beginTransaction();
        session.persist(student);
        session.persist(address);
       
        tx.commit();

        session.close();
        System.out.println("Done ");

       
    }
}
