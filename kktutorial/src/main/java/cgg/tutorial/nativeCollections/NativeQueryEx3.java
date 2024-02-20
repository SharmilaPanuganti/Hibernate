package cgg.tutorial.nativeCollections;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import cgg.tutorial.HibernateUtil;

public class NativeQueryEx3 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        // NativeQuery<Phone> query = session.createNativeQuery("select * from phone_numbers").addEntity(Phone.class);
        NativeQuery<Object[]> query = session.createNativeQuery("select * from phone_numbers ph left join person_mapped pr on ph.person_id =pr.person_id");
        List<Object[]> res = query.getResultList();
        for (Object[] objects : res) {
            System.out.println(Arrays.toString(objects));
        }
        session.close();
    }
}
