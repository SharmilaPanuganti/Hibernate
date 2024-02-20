package cgg.tutorial.criteriaqueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;
import cgg.tutorial.inheritance.Person;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.Join;

public class MultipleRoots {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getfactory().openSession()) {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);
            JpaRoot<BackupStudent> student = query.from(BackupStudent.class);
            JpaRoot<Person> person = query.from(Person.class);
            Join<BackupStudent, Department> departmentJoin = student.join("department");
            query.multiselect(student, person);
            JpaPredicate stPred = builder.and(builder.equal(departmentJoin.get("dept_id"), 1), 
            builder.equal(student.get("student_id"), 1));
            JpaPredicate prPred = builder.and(
                builder.equal(person.get("gender"), "female"),
                builder.equal(person.get("id"), 1));
                query.where(builder.and(stPred,prPred));
                List<Tuple> li = session.createQuery(query).getResultList();
                for (Tuple tuple : li) {
                    BackupStudent bp=(BackupStudent)tuple.get(0);
                    if(bp!=null){
                        System.out.println(bp);
                    }
                    Person p=(Person)tuple.get(1);
                    if(p!=null){
                        System.out.println(p);
                    }
                }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
