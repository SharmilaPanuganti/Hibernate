package cgg.tutorial.blobbinary;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.swing.JPanel;

import org.hibernate.Session;
import org.hibernate.engine.jdbc.BlobProxy;

import cgg.tutorial.HibernateUtil;

public class BlobMapping {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getfactory().openSession()) {
            JPAStudent st = new JPAStudent();
            st.setDob(new Date());
            st.setMarks(908.05);
            st.setName("Sai");
            session.doWork(conn -> st.setProfile_pic(BlobProxy.generateProxy(getImage())));
            session.beginTransaction();
            session.persist(st);
            session.getTransaction().commit();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    private static byte[] getImage() {
        Path path = Paths.get("src\\main\\java\\cgg\\tutorial\\images\\img2.jpg");
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return data;
    }
}
