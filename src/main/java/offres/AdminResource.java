package offres;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//Assurez-vous d'avoir la bonne importation pour @Path

@Path("/admin") // Le chemin de base pour toutes les méthodes dans cette classe
public class AdminResource {

	private Administrator admin;
    private List<Utilisateur> users; // Assurez-vous d'avoir une classe Utilisateur également
    private static List<Candidature> candidatures = new ArrayList<>();
    public AdminResource() {
    	this.admin = new Administrator();
        this.users = new ArrayList<>();
    }
    @Path("/test")
    @GET
    public void test() {
    	System.out.println("aaaaaaa");
    }
 @Path("/login")
 @POST
 public String adminLogin(@FormParam("username") String username, @FormParam("password") String password) {
     if (admin.getUsername().equals(username) && admin.checkPassword(password)) {
         return "Connexion réussie en tant qu'administrateur.";
     } else {
         return "Échec de la connexion. Vérifiez vos identifiants.";
     }
 }
 @Path("/changePassword")
 @PUT
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 public String changeAdminPassword(@FormParam("newPassword") String newPassword) {
     Administrator admin = getAdministrator();
     admin.setPassword(newPassword);
     return "Mot de passe administrateur modifié avec succès. Nouveau mot de passe : " + admin.getPassword();
 }
 @Path("/addUser")
 @POST
 @Consumes("application/x-www-form-urlencoded")
 public String addUser(@FormParam("username") String username, @FormParam("password") String password) {
     System.out.println("Adding user: " + username);
     Utilisateur nouvelUtilisateur = new Utilisateur(username, password);
     addToUserList(users, nouvelUtilisateur);
     System.out.println("User added successfully.");
     return "Utilisateur ajouté avec succès.";
 }

 private void addToUserList(List<Utilisateur> users, Utilisateur utilisateur) {
     users.add(utilisateur);
 }
 
 private Administrator getAdministrator() {
     
     return admin;
 }


 @POST
 @Path("/submit")
 @Consumes(MediaType.APPLICATION_JSON)
 public String soumettreCandidature(Candidature candidature) {
     if (candidature != null) {
         candidatures.add(candidature);
         System.out.println("Candidature submitted: " + candidature.getId());
         return "Candidature soumise avec succès.";
     } else {
         // Gérer le cas où candidature est null
         return "La candidature est nulle. Impossible de la soumettre.";
     }
 }

 @PUT
 @Path("/modifyOffer")
 @Consumes(MediaType.APPLICATION_JSON)
 public String modifierOffre(Candidature candidature) {
     // Logique pour modifier l'offre financière
     // Vous pouvez rechercher la candidature dans la liste et mettre à jour le montant de l'offre.
     // Ici, nous supposons que vous avez un identifiant unique pour chaque candidature.
     for (Candidature c : candidatures) {
         if (c.getId().equals(candidature.getId())) {
             c.setMontantProjet(candidature.getMontantProjet());
             return "Montant de l'offre financière modifié avec succès.";
         }
     }
     return "Candidature non trouvée.";
 }
 
 @GET
 @Path("/users")
 @Produces(MediaType.APPLICATION_JSON)
 public List<Utilisateur> getUsers() {
     System.out.println("Number of users: " + users.size());
     return users;
 }


 @Path("/candidatures")
 @GET
 public String showCandidatureList() {
     StringBuilder candidatureHtml = new StringBuilder();
     candidatureHtml.append("<h2>Liste des candidatures</h2>");
     candidatureHtml.append("<ul>");
     for (Candidature candidature : candidatures) {
         candidatureHtml.append("<li>").append("ID: ").append(candidature.getId()).append(", Montant: ")
                         .append("</li>");
     }
     candidatureHtml.append("</ul>");
     return candidatureHtml.toString();
 }
public void setUsers(List<Utilisateur> users) {
	this.users = users;
}
 
}