package cgg.tutorial.nativeCollections;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.concurrent.atomic.AtomicReference;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;

public class FunctionCall {
    public static void main(String[] args) {
        try (Session session=HibernateUtil.getfactory().openSession()) {
            final AtomicReference<Integer> count=new AtomicReference<>();
            session.doWork(connection->{
                try (CallableStatement cl=connection.prepareCall("{?=call fn_count_phones(1)}")) {
                    cl.registerOutParameter(1, Types.INTEGER);
                    cl.execute();
                    count.set(cl.getInt(1));
                    System.out.println("Phone numbers count:"+count);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            });
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
