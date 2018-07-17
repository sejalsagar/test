package com.vs.demo.repository;

import com.vs.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Employee emp){
        entityManager.persist(emp);
    }

    public void update(Employee emp){
        entityManager.merge(emp);
    }

    public Employee get(Integer id){
        return entityManager.find(Employee.class, id);
    }

    public void delete(Integer id){
        Employee emp = get(id);
        if(null!=emp) {
            entityManager.remove(emp);
        }
    }

    public List<Employee> getManagers(){
        Query query = entityManager.createNativeQuery("SELECT * FROM EMPLOYEE where id in (select distinct manager from employee)", Employee.class);
        List<Employee> managers = query.getResultList();
        return managers;
    }

}
