package troc;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  
	public class article { 
		@Id
		
		private int id;
	    private String type;
	    private int etat;
	    private Date dateCreation;
	    private String emailTroqueur;
	    private String commentaire;
	    private String rubirique;
		public article() {
			
		}
		
		public article(int id, String type, int etat, Date dateCreation, String emailTroqueur, String commentaire,
				String rubirique) {
			super();
			this.id = id;
			this.type = type;
			this.etat = etat;
			this.dateCreation = dateCreation;
			this.emailTroqueur = emailTroqueur;
			this.commentaire = commentaire;
			this.rubirique = rubirique;
		}
		public long getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getEtat() {
			return etat;
		}
		public void setEtat(short etat) {
			this.etat = etat;
		}
		public Date getDateCreation() {
			return dateCreation;
		}
		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}
		public String getEmailTroqueur() {
			return emailTroqueur;
		}
		public void setEmailTroqueur(String emailTroqueur) {
			this.emailTroqueur = emailTroqueur;
		}
		public String getCommentaire() {
			return commentaire;
		}
		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}
		public String getRubirique() {
			return rubirique;
		}
		public void setRubirique(String rubirique) {
			this.rubirique = rubirique;
		}
	    
	}

