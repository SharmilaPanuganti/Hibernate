package cgg.tutorial.formula;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;

public class FormulaDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();
        Account acc = new Account();
        acc.setCredit(9000.00);
        // acc.setRate(8.35);
        acc.setIsbn("08989867868");
        acc.setEmail("sharmi@gmail.com");
        acc.setFname("Sharmi");
        acc.setlName("Panuganti");
        Account acc2 = new Account();
        acc2.setCredit(10000.24);
        acc2.setRate(5.76);
        acc2.setIsbn("808897987898");
        acc2.setEmail("sharmila@gmail.com");
        acc2.setFname("Sai");
        acc2.setlName("Panuganti");
        session.beginTransaction();
        session.persist(acc);
        session.persist(acc2);
        // Account account = session.get(Account.class, 1);
        // Account account = session.byNaturalId(Account.class).using("isbn",
        // "08989867867868").load();
        // System.out.println(account.getInterest());
        session.getTransaction().commit();
        session.close();
    }
}
