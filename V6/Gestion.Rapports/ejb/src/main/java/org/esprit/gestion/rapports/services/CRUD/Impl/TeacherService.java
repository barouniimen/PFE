package org.esprit.gestion.rapports.services.CRUD.Impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.esprit.gestion.rapports.persistence.Teacher;
import org.esprit.gestion.rapports.services.CRUD.Interfaces.IServiceLocal;
import org.esprit.gestion.rapports.services.CRUD.Interfaces.IServiceRemote;
import org.esprit.gestion.rapports.services.CRUD.Util.TeacherQualifier;

@TeacherQualifier
@Stateless
public class TeacherService implements IServiceLocal<Teacher>,IServiceRemote<Teacher> {

	@PersistenceContext
	EntityManager em;

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("pas encore implémentée");

	}

	@Override
	public void create(Object object) {
		try {
			em.persist(object);
			} catch (EntityExistsException exist) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!User existe!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	}

	@Override
	public Object retrieve(Object object, String searchBy) {
		Teacher teacherSearched = null;
		
		
	/***************************    search by ID    *********************************************/	
		if(searchBy == "ID"){
			TypedQuery<Teacher> query = em.createNamedQuery("Teacher.findById", Teacher.class);
			query.setParameter("id",((Teacher) object).getId());
			teacherSearched = query.getSingleResult();
		}
		
		
		
		return teacherSearched;
	}
	

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("pas encore implémentée");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}


	@Override
	public List<Teacher> retrieveList(Object object, String searchBy) {
		List<Teacher> teacherList = null;

		/*********************** Search by coachinghours ***************************/
		if (searchBy == "HOURS") {
			TypedQuery<Teacher> query = em.createNamedQuery("Teacher.findByCoachingHours", Teacher.class);
			query.setParameter("coachingHours",((Teacher) object).getCoachingHours());
			teacherList = query.getResultList();
		}
		return teacherList;
	}

}