package cgg.tutorial.criteriaqueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.nativeCollections.Person2;
import cgg.tutorial.nativeCollections.Phone;

public class JoinCriteria {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<Phone> query = builder.createQuery(Phone.class);
            JpaRoot<Phone> root = query.from(Phone.class);
            // root.join("person");
            root.fetch("person");
            root.fetch("calls");  //eager loading
            query.where(builder.isNotEmpty(root.get("calls")));
            List<Phone> list = session.createQuery(query).getResultList();
            list.forEach(ph->{
                System.out.println(ph);
                System.out.println(ph.getPerson().getName());
                System.out.println(ph.getCalls());
            });
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
