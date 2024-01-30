package offres;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

//Assurez-vous d'avoir la bonne importation pour @Path
@Path("/admin") // Le chemin de base pour toutes les méthodes dans cette classe
public class AdminResource {

	private Administrator admin;
    private List<Utilisateur> users; // Assurez-vous d'avoir une classe Utilisateur également

    public AdminResource() {
        this.admin = new Administrator(); // Assurez-vous d'avoir la classe Administrator
        this.users = new ArrayList<>();
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
 public String changeAdminPassword(@QueryParam("newPassword") String newPassword) {
     Administrator admin = getAdministrator(); // Utilisez la méthode appropriée pour obtenir l'administrateur
     admin.setPassword(newPassword);
     return "Mot de passe administrateur modifié avec succès.";
 }

 @Path("/addUser")
 @POST
 @Consumes("application/x-www-form-urlencoded")
 public String addUser(@FormParam("username") String username, @FormParam("password") String password) {
     Utilisateur nouvelUtilisateur = new Utilisateur(username, password);
     List<Utilisateur> users = getUsers(); // Utilisez la méthode appropriée pour obtenir la liste des utilisateurs
     addToUserList(users, nouvelUtilisateur);
     return "Utilisateur ajouté avec succès.";
 }
 // Ajout de la méthode pour ajouter un utilisateur à la liste
 private void addToUserList(List<Utilisateur> users, Utilisateur utilisateur) {
     users.add(utilisateur);
 }

 private Administrator getAdministrator() {
     // Implémentez la logique pour obtenir l'administrateur
     return new Administrator();
 }

 private List<Utilisateur> getUsers() {
     // Implémentez la logique pour obtenir la liste des utilisateurs
     return new ArrayList<>();
 }
}