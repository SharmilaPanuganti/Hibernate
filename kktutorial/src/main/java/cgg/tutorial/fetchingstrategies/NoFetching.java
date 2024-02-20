package cgg.tutorial.fetchingstrategies;

import org.hibernate.Session;

import cgg.tutorial.HibernateUtil;

public class NoFetching {
    public static void main(String[] args) {
        Session session = HibernateUtil.getfactory().openSession();

        session.close();
    }
}
