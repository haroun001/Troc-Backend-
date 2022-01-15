package service;

import java.util.List;


import javax.ejb.Local;


import troc.article;
import troc.user;
import troc.utilisateur;

@Local
public interface gestiontrocLocal {
	public List<user> findAll();
	public void addarticle( user user1);
	public void deleteutilisateur(user user1);
	public void addUser( utilisateur user);
	public utilisateur getByEmail(String email);
	public utilisateur login(String email, String password);
	public void updateutilisateur(utilisateur user);
	public void updatearticle(article article);
	public void addarticle( article article);
	public List<utilisateur> findAllutilis();
	public List<article> findAllarticle();	 
	 public void deleteutilisateur(utilisateur user);
	 public void deletearticle(article article);
	 public utilisateur findUserfById(int id);
	 public article findArticleById(int id);
	 public article deleteArticleById(int id);
	 
	 
}



