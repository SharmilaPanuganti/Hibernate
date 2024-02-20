package cgg.hibernate.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MappingDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Emp e1 = new Emp();
        e1.setEmp_id(101);
        e1.setName("Martin");
        Emp e2=new Emp();
        e2.setEmp_id(102);
        e2.setName("Shawn");
        //Creating project
        Project p1 = new Project();
        p1.setProject_id(1);
        p1.setProject_name("TSPSC");
        Project p2=new Project();
        p2.setProject_id(2);
        p2.setProject_name("Quiz app");
        List<Emp> l1=new ArrayList<>();
        l1.add(e1);
        l1.add(e2);
        List<Project> l2=new ArrayList<>();
        l2.add(p1);
        l2.add(p2);
        e1.setProjects(l2);
        p1.setEmplooyees(l1);
        //session
        Session session=factory.openSession();
        session.beginTransaction();
        //save
        session.persist(p1);
        session.persist(p2);
        session.persist(e1);
        session.persist(e2);
        session.getTransaction().commit();
        factory.close();
    }
}
