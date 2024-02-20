package cgg.tutorial.criteriaqueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public class CriteriaSelect {
   /**
 * @param args
 */
public static void main(String[] args) {
    try (Session session=HibernateUtil.getfactory().openSession()) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        // CriteriaQuery<BackupStudent> query = builder.createQuery(BackupStudent.class);
        CriteriaQuery<String> query = builder.createQuery(String.class);
       Root<BackupStudent> root = query.from(BackupStudent.class);
       Join<BackupStudent, Department> departmentJoin = root.join("department");
    //    query.select(root);
       query.select(root.get("name"));
    //    query.where(builder.equal(departmentJoin.get("dept_id"), 1));
    //    List<BackupStudent> list = session.createQuery(query).getResultList();
       List<String> list = session.createQuery(query).getResultList();
       list.forEach(System.out::println);
        
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
   } 
}
