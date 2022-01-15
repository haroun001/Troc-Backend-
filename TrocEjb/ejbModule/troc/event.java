package troc;



import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  
public class event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private short etat;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private Timestamp dateCreation;
	public event() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public short getEtat() {
		return etat;
	}
	public void setEtat(short etat) {
		this.etat = etat;
	}
	public Timestamp getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Timestamp getDateFin() {
		return dateFin;
	}
	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}
	public Timestamp getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}
    
}
