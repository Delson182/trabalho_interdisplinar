package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.Requerente;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class RequerenteDAO {
	
	public boolean salva(Requerente requerente) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(requerente);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Requerente> recuperaTodos() {
		List<Requerente> requerente = new ArrayList<Requerente>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Requerente");
			requerente = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requerente;
	}
	@SuppressWarnings("unchecked")
	public List<Requerente> recuperaApenasRequerentesNaoAlunos() {
		List<Requerente> requerente = new ArrayList<Requerente>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Requerente r WHERE r.estudante.cpf != r.cpf");
			requerente = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requerente;
	}
	
	public Requerente recuperaPorCpf(String cpf) {
		Requerente requerente = new Requerente();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Requerente as r where r.cpf=:cpf");
			query.setParameter("cpf", cpf);
			requerente = (Requerente) query.getSingleResult();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requerente;
	}
	
	public Requerente buscaCpfComIdDoEstudante(String cpf, Integer id) {
		Requerente requerente = new Requerente();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM Requerente where cpf=:cpf and estudante_fk=:id");
			query.setParameter("cpf", cpf);
			query.setParameter("id", id);
			if(query.getResultList().isEmpty()){
				return null;
			}else{
				requerente = (Requerente) query.getSingleResult();
			}		
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requerente;
	}


}
