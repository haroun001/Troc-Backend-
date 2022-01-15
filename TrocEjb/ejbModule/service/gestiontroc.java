package service;

import java.util.List;


import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import troc.article;
import troc.user;
import troc.utilisateur;

/**
 * Session Bean implementation class gestiontroc
 */

@Stateless 

@LocalBean
public class gestiontroc implements gestiontrocRemote, gestiontrocLocal {
	@PersistenceContext(unitName="molkaaa")
    private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public gestiontroc() {
      //  TODO Auto-generated constructor stub
    }

	@Override
public void addUser(utilisateur user) {
	entityManager.persist(user);
		
	}

	@Override
	public utilisateur login(String email, String password) {
		Query query;
		try {
		String myFirstJPQLQuery="SELECT u FROM utilisateur u WHERE u.email = :p1 AND u.password= :p2";
		 query = entityManager.createQuery(myFirstJPQLQuery);
		query.setParameter("p1", email);
		query.setParameter("p2", password);
		return (utilisateur) query.getSingleResult();
		}
		catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	
	}
	

	@Override
	public void updateutilisateur(utilisateur user) {
		entityManager.merge(user);		
	}

	@Override
	public void updatearticle(article article) {
		entityManager.merge(article);		
		
	}

	@Override
	public void addarticle(article article) {
		entityManager.persist(article);		
		
	}

	@Override
	public List<utilisateur> findAllutilis() {
		String myJPQLQuery="SELECT e FROM utilisateur e";
		Query query=entityManager.createQuery(myJPQLQuery);
		return query.getResultList();
	}

	@Override
	public List<article> findAllarticle() {
		return entityManager.createQuery("SELECT a FROM article a").getResultList();
	}

	@Override
	public void deleteutilisateur(utilisateur user) {
		entityManager.remove(entityManager.merge(user));		
	}

	

	

	@Override
	public utilisateur findUserfById(int id) {
		return entityManager.find(utilisateur.class,id);
	}

	@Override
	public article findArticleById(int id) {
		return entityManager.find(article.class,id);
	}

	@Override
	
	public void deletearticle(article article) {
		entityManager.remove(entityManager.merge(article));
	}

	@Override
	public article deleteArticleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public utilisateur getByEmail(String email) {
		return entityManager.find(utilisateur.class,email);
	}

	@Override
	public void addarticle(user user1) {
		entityManager.persist(user1);	
		
	}

	@Override
	public List<user> findAll() {
		return entityManager.createQuery("SELECT a FROM user a").getResultList();
	}

	@Override
	public void deleteutilisateur(user user1) {
		entityManager.remove(entityManager.merge(user1));
		
	}

	

	

}
