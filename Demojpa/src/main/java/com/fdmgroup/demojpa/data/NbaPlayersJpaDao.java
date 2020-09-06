package com.fdmgroup.demojpa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fdmgroup.demojpa.model.NbaPlayer;

public class NbaPlayersJpaDao implements Crudable<NbaPlayer, Integer> {
	private EntityManagerFactory emf;
	

	public NbaPlayersJpaDao() {
		super();
		emf= Persistence.createEntityManagerFactory("JpaNbaPlayer");
		
	}

	@Override
	public boolean create(NbaPlayer player) {
		boolean iscreated=false;
		EntityManager em = null;
		try {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(player);
		em.getTransaction().commit();
		iscreated=true;
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
		}
		return iscreated;
	}

	@Override
	public NbaPlayer read(Integer id) {
		
		NbaPlayer managedNbaPlayer = null;
		EntityManager em = null;
		try {
		em = emf.createEntityManager();
		managedNbaPlayer = em.find(NbaPlayer.class,id);
	
		
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
		}
		return managedNbaPlayer;
	}

	@Override
	public boolean update(NbaPlayer player) {
		boolean isupdated=false;
		EntityManager em = null;
		try {
		em = emf.createEntityManager();
		NbaPlayer managedNbaPlayer = em.find(NbaPlayer.class, player.getId());
		em.getTransaction().begin();
		managedNbaPlayer.setFirstName(player.getFirstName());
		managedNbaPlayer.setLastName(player.getLastName());
		managedNbaPlayer.setCareerPoints(player.getCareerPoints());
		em.getTransaction().commit();
		isupdated = true;
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
		}
		return isupdated;
	}
	

	@Override
	public boolean delete(Integer id) {
		boolean isdeleted = false;
		EntityManager em = null;
		try {
			em= emf.createEntityManager();
			NbaPlayer managenba = em.find(NbaPlayer.class, id);
			EntityTransaction  et = em.getTransaction();
			et.begin();
			em.remove(managenba);
			et.commit();
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
		}
		return false;
	}

	@Override
	public List<NbaPlayer> read() {
		EntityManager em = null;
		List<NbaPlayer> players = new ArrayList<>();		
		try {
		em = emf.createEntityManager();
		TypedQuery<NbaPlayer> query = em.createNamedQuery("findall", NbaPlayer.class);
		players = query.getResultList();		
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}		
		return players;
	}
	
	
	public void close() {
		if (this.emf != null && this.emf.isOpen()) {
			this.emf.close();
		}
	}
	
	public NbaPlayer readbyLastname(String lastname) {
		EntityManager em = null;
		NbaPlayer player = null;	
		try {
		em = emf.createEntityManager();
		TypedQuery<NbaPlayer> query = em.createQuery("SELECT p FROM NbaPlayer p where p.lastName = :lname ", NbaPlayer.class);
		query.setParameter("lname", lastname);
		player = query.getSingleResult();		
		} finally {
			if(em != null && em.isOpen()) {
				em.close();
			}
		}		
		return player;
	}

}
