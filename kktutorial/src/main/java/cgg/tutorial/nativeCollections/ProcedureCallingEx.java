package cgg.tutorial.nativeCollections;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.type.StandardBasicTypes;

import cgg.tutorial.HibernateUtil;
import jakarta.persistence.ParameterMode;

public class ProcedureCallingEx {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        ProcedureCall query = session.createStoredProcedureQuery("sp_count_phones(:pId, :phoneCount)");
         query.registerStoredProcedureParameter("pId", Integer.class, ParameterMode.IN);
         query.registerStoredProcedureParameter("phoneCount", Integer.class, ParameterMode.OUT);
         query.setParameter("pId", 1,StandardBasicTypes.INTEGER);
         query.execute();
         Integer phoneCount=(Integer) query.getOutputParameterValue("phoneCount");
         System.out.println("Count: "+phoneCount);
        session.close();
    }
}
