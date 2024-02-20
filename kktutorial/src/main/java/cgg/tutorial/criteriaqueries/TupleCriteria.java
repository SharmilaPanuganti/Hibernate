package cgg.tutorial.criteriaqueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPath;
import org.hibernate.query.criteria.JpaRoot;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import jakarta.persistence.Tuple;

public class TupleCriteria {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);
            JpaRoot<BackupStudent> root = query.from(BackupStudent.class);
            JpaPath<Object> id = root.get("student_id");
            JpaPath<Object> name = root.get("name");
            JpaPath<Object> marks = root.get("marks");
            query.multiselect(name,id,marks);
            List<Tuple> list = session.createQuery(query).getResultList();
            for (Tuple tuple : list) {
                String stName=(String)tuple.get(name);
                Integer stid=(Integer)tuple.get(id);
                System.out.println(stid+" : "+stName);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
