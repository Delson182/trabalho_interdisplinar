package br.edu.ifms.requerimentos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.ifms.requerimentos.model.ServidorSetor;
import br.edu.ifms.requerimentos.util.JPAUtil;

public class ServidorSetorDAO {
	
	public boolean salva(ServidorSetor servidorSetor) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			EntityTransaction transacao = em.getTransaction();
			transacao.begin();
			em.persist(servidorSetor);
			transacao.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<ServidorSetor> recuperaTodos() {
		List<ServidorSetor> servidorSetor = new ArrayList<ServidorSetor>();
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("FROM servidor_setor");
			servidorSetor = query.getResultList();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servidorSetor;
	}
	
	

}
