package cgg.tutorial.nativequeries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.metamodel.model.domain.BasicDomainType;
import org.hibernate.type.descriptor.java.IntegerJavaType;
import org.hibernate.type.descriptor.java.StringJavaType;

import cgg.tutorial.HibernateUtil;
import cgg.tutorial.hql.BackupStudent;

public class NativeQueryEx {
    public static void main(String[] args) {
        Session session=HibernateUtil.getfactory().openSession();
        // List<BackupStudent> res = session.createNativeQuery("select * from student_backup",BackupStudent.class).getResultList();
        List<Object[]> res = session.createNativeQuery("select * from student_backup").addScalar("student_id", (BasicDomainType) IntegerJavaType.INSTANCE).addScalar("name", (BasicDomainType) StringJavaType.INSTANCE).getResultList();
        // for (BackupStudent backupStudent : res) {
        //     System.out.println(backupStudent);
        // }
        for (Object[] objects : res) {
            System.out.println(Arrays.toString(objects));
        }
        session.close();
    }
}
