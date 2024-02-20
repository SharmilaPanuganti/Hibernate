package cgg.tutorial.blobbinary;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;

public class ReadImage {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getfactory().openSession()) {
            session.beginTransaction();
            JPAStudent st = session.get(JPAStudent.class, 1);
            System.out.println(st.getName());
            Blob img = st.getProfile_pic();
            InputStream is = img.getBinaryStream();
            Files.copy(is, Paths.get("src\\main\\java\\cgg\\tutorial\\profilepics/" + st.getName() + ".jpg"),
                    StandardCopyOption.REPLACE_EXISTING);
            is.close();
            session.getTransaction().commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
