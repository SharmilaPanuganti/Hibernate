package cgg.eventlisteners;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;

public class HibernateUtil {
    private static StandardServiceRegistry ssr;
    private static SessionFactory factory;

    static {
        try {
            if (factory == null)
                ssr = new StandardServiceRegistryBuilder().configure().build();
            MetadataSources meta = new MetadataSources(ssr);
            Metadata metadata = meta.getMetadataBuilder().build();
            factory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if (ssr != null)
                StandardServiceRegistryBuilder.destroy(ssr);
        }
    }

    public static SessionFactory getfactory() {
        return factory;
    }

    public static void closeSessionFactory() {
        if (factory != null)
            factory.close();
    }

}
