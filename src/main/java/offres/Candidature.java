package offres;

import java.sql.Date;

public class Candidature {
    private String id ;
    private Utilisateur soumissionnaire;
    private Date dateSoumission;
    private String nomProjet;
    private String client;
    private double montantProjet;
    private Date dateRealisation;
	public Utilisateur getSoumissionnaire() {
		return soumissionnaire;
	}
	public void setSoumissionnaire(Utilisateur soumissionnaire) {
		this.soumissionnaire = soumissionnaire;
	}
	
	public Date getDateSoumission() {
		return dateSoumission;
	}
	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}
	public String getNomProjet() {
		return nomProjet;
	}
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getMontantProjet() {
		return montantProjet;
	}
	public void setMontantProjet(double montantProjet) {
		this.montantProjet = montantProjet;
	}
	public Date getDateRealisation() {
		return dateRealisation;
	}
	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    // Constructeur, getters, setters...
    
    
    
}