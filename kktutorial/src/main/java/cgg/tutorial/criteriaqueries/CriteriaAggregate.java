package cgg.tutorial.criteriaqueries;

import java.util.List;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import cgg.tutorial.hql.StudentStatistics;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;

public class CriteriaAggregate {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getfactory().openSession()) {
            // getMaxMarks(session);
            // getTotalNoOfEmployees(session);
            // getAvgMarks(session);
            // getDistinct(session);
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<StudentStatistics> query = builder.createQuery(StudentStatistics.class);
            Root<BackupStudent> root = query.from(BackupStudent.class);
            Expression<Long> studentCount = builder.count(root);
            Expression<Double> avgMarks = builder.avg(root.get("marks"));
            Expression<Number> minMarks = builder.max(root.get("marks"));
            Expression<Number> sum = builder.sum(root.get("marks"));
            query.select(builder.construct(StudentStatistics.class, studentCount,avgMarks,minMarks,sum));
                        List<StudentStatistics> res = session.createQuery(query).getResultList();
            res.forEach(System.out::println);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static void getDistinct(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<BackupStudent> root = query.from(BackupStudent.class);
        query.select(builder.countDistinct(root));
        Long res = session.createQuery(query).getSingleResult();
        System.out.println("Distinct students count: " + res);
    }

    private static void getAvgMarks(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        Root<BackupStudent> root = query.from(BackupStudent.class);
        query.select(builder.avg(root.get("marks")));
        // query.select(builder.sum(root.get("marks")));
        Double res = session.createQuery(query).getSingleResult();
        // System.out.println("Sum: "+res);
        System.out.println("Average marks: " + res);
    }

    private static void getSumMarks(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        Root<BackupStudent> root = query.from(BackupStudent.class);
        // query.select(builder.avg(root.get("marks")));
        query.select(builder.sum(root.get("marks")));
        Double res = session.createQuery(query).getSingleResult();
        System.out.println("Sum: " + res);
        // System.out.println("Average marks: "+res);
    }

    private static void getMaxMarks(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        Root<BackupStudent> root = query.from(BackupStudent.class);
        query.select(builder.max(root.get("marks")));
        Double res = session.createQuery(query).getSingleResult();
        System.out.println("Maximum marks: " + res);
    }

    private static void getTotalNoOfEmployees(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<BackupStudent> root = query.from(BackupStudent.class);
        query.select(builder.count(root));
        Long res = session.createQuery(query).getSingleResult();
        System.out.println("No of students " + res);
    }
}
