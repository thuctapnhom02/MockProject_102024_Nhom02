package com.mock_project_102024_nhom02.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

import com.mock_project_102024_nhom02.entity.*;

@EntityScan(basePackages = "com.mock_project_102024_nhom02.entity")
public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties pros = new Properties();
        pros.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        pros.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        pros.put(Environment.URL, "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;encrypt=true;trustServerCertificate=true;databaseName=webchungcu_91");
        pros.put(Environment.USER, "sa");
        pros.put(Environment.PASS, "123456");
        conf.setProperties(pros);
        conf.addAnnotatedClass(Apartment.class);
        conf.addAnnotatedClass(Complaints.class);
        conf.addAnnotatedClass(ContractLease.class);
        conf.addAnnotatedClass(ContractService.class);
        conf.addAnnotatedClass(EmploymentContract.class);
        conf.addAnnotatedClass(Equipment.class);
        conf.addAnnotatedClass(Income.class);
        conf.addAnnotatedClass(MaintenanceRepair.class);
        conf.addAnnotatedClass(NotificationStaff.class);
        conf.addAnnotatedClass(Outcome.class);
        conf.addAnnotatedClass(Payment.class);
        conf.addAnnotatedClass(PaymentMethod.class);
        conf.addAnnotatedClass(RentalRequest.class);
        conf.addAnnotatedClass(RepairHistory.class);
        conf.addAnnotatedClass(Role.class);
        conf.addAnnotatedClass(ScheduleAHomeInspection.class);
        conf.addAnnotatedClass(Service.class);
        conf.addAnnotatedClass(Staff.class);
        conf.addAnnotatedClass(Suppliers.class);
        conf.addAnnotatedClass(TechnicalMaintenance.class);
        conf.addAnnotatedClass(TechnicalRepair.class);
        conf.addAnnotatedClass(TypeIncome.class);
        conf.addAnnotatedClass(TypeOutcome.class);
        conf.addAnnotatedClass(TypePayment.class);
        conf.addAnnotatedClass(TypeEquipment.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(UtilityContract.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    @Bean
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
