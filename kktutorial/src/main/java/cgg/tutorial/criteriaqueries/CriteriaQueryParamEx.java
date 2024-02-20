package cgg.tutorial.criteriaqueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;

public class CriteriaQueryParamEx {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            CriteriaBuilder builder=session.getCriteriaBuilder();
            CriteriaQuery<BackupStudent> query = builder.createQuery(BackupStudent.class);
            Root<BackupStudent> root = query.from(BackupStudent.class);
            ParameterExpression<String> nameParam = builder.parameter(String.class);
            query.where(builder.equal(root.get("name"),nameParam));
            Query<BackupStudent> query2 = session.createQuery(query);
            query2.setParameter(nameParam, "Sai");
            List<BackupStudent> resultList = query2.getResultList();
            resultList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
