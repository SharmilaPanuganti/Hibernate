package cgg.hibernate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        // Student student = session.get(Student.class,105);
        // System.out.println(student);
        Address address = session.get(Address.class, 152);
        
        System.out.println(address);
        byte[] image = address.getImage();
        try {
            FileOutputStream fop = new FileOutputStream("src/main/java/img2.jpg");
            fop.write(image);
            fop.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        session.close();
    }
}
