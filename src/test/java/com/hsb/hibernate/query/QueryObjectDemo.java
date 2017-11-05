package com.hsb.hibernate.query;/*
 * Copyright ©2011-2016 hsb
 */

import com.hsb.hibernate.entity.Employee;
import com.hsb.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class QueryObjectDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        String sql = "select e from " + Employee.class.getName() + " e " + " order by e.empName, e.empNo ";
        Query query = session.createQuery(sql);

        List<Employee> employees = query.getResultList();

        for (Employee employee: employees) {
            System.out.println("Emp: " + employee.getEmpNo() + " : "
                    + employee.getEmpName());
        }
        // Commit data.
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}




















