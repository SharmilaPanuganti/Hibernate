package cgg.tutorial.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import cgg.tutorial.HibernateUtil;

public class HQLGroupBy {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        String hql = "SELECT dept.dept_name, SUM(st.marks) FROM Department dept LEFT JOIN dept.students st GROUP BY dept";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> list = query.list();
        
        for (Object[] objects : list) {
            System.out.println(objects[0]+": "+objects[1]);
        }
        
        session.close();
    }
}
