package offres;

public class Administrator {

	 private String username;
	    private String password;

	    // Constructeur par défaut
	    public Administrator() {
	        this.setUsername("admin");
	        this.password = ("admin");
	    }


	    public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		// Méthode pour vérifier le mot de passe
	    public boolean checkPassword(String enteredPassword) {
	        return this.password.equals(enteredPassword);
	    }

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
	}

