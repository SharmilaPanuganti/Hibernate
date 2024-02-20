package cgg.tutorial.criteriaqueries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

public class CriteriaMultiSelect {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            // CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            CriteriaQuery<BackupDTO> query = builder.createQuery(BackupDTO.class);
            Root<BackupStudent> root = query.from(BackupStudent.class);
            Path<Object> id = root.get("student_id");
            Path<Object> name = root.get("name");
            Path<Object> marks = root.get("marks");
            // query.select(builder.array(id,name,marks));
            // query.multiselect(name,id,marks);
            query.select(builder.construct(BackupDTO.class, name,id,marks));
            // List<Object[]> list = session.createQuery(query).getResultList();
            List<BackupDTO> list = session.createQuery(query).getResultList();
            list.forEach(s->System.out.println(s));
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
