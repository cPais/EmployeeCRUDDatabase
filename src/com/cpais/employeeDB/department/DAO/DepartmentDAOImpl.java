package com.cpais.employeeDB.department.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cpais.employeeDB.department.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Department> getDepartments() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("from Department");
		
		return theQuery.getResultList();
	}

	@Override
	public void saveDepartment(Department theDepartment) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theDepartment);
		
	}

	@Override
	public Department getDepartment(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Department.class, theId);
		
	}

	@Override
	public void deleteDepartment(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery(
				"delete from Department where id=:departmentId");
		
		theQuery.setParameter("departmentId", theId);
		theQuery.executeUpdate();
		
	}

}
