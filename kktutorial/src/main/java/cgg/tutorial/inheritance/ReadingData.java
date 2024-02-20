package cgg.tutorial.inheritance;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;

public class ReadingData {
    public static void main(String[] args) {
        Session session=HibernateUtil.getfactory().openSession();
        Person person = session.get(Person.class, 2);
        if(person instanceof Person && !(person instanceof Worker) && !(person instanceof Pupil)){
            System.out.println(person);
        }
        else if(person instanceof Person && (person instanceof Worker)){
            person=(Worker)person;
            System.out.println(person);
        }
        else if(person instanceof Person && person instanceof Pupil){
            person=(Pupil)person;
            System.out.println(person);
        }
          
        //joined table
        

        session.close();
    }
}
