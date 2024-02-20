package cgg.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("honda");
        bike.setSteeringHandle("bike handle");
        FourWheeler car=new FourWheeler();
        car.setVehicleName("Porsche");
        car.setSteeringWheel("posrsche steering wheel");
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        session.beginTransaction();
         session.persist(vehicle);
         session.persist(bike);
         session.persist(car);
         session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
