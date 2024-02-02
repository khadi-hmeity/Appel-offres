package offres;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager {
	
	    private List<Utilisateur> users;
	    private List<Candidature> candidatures;

	    public ResourceManager() {
	        this.users = new ArrayList<>();
	        this.candidatures = new ArrayList<>();
	    }

	    public List<Utilisateur> getUsers() {
	        return users;
	    }

	    public List<Candidature> getCandidatures() {
	        return candidatures;
	    }
	}

