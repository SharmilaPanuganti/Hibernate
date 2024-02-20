package cgg.tutorial.criteriaqueries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.Department;
import cgg.tutorial.hql.StudentStatistics;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

public class CriteriaJoin {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
             CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            Root<BackupStudent> root = query.from(BackupStudent.class);
            Root<Department> dRoot = query.from(Department.class);
            Join<Object, Object> joinDepartment = root.join("department");

            query.multiselect(root, joinDepartment);
            // query.multiselect(root,dRoot);
            // query.where(builder.equal(root.get("department"), dRoot.get("dept_id")));
            Query<Object[]> query2 = session.createQuery(query);
            List<Object[]> resultList = query2.getResultList();
            resultList.forEach(s->System.out.println(Arrays.toString(s)));
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
