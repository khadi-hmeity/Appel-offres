package offres;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	out.println("<html><head><title>Page de connexion</title>");
    	out.println("<style>");
    	out.println("body {");
    	out.println("    font-family: 'Arial', sans-serif;");
    	out.println("    background-color: #f4f4f4;");
    	out.println("    margin: 0;");
    	out.println("    padding: 0;");
    	out.println("    display: flex;");
    	out.println("    flex-direction: column;");
    	out.println("    align-items: center;");
    	out.println("    justify-content: center;");
    	out.println("    height: 100vh;");
    	out.println("}");

    	out.println("h2 {");
    	out.println("    text-align: center;");
    	out.println("    color: #333;");
    	out.println("    margin-top: 0;");
    	out.println("}");

    	out.println("form {");
    	out.println("    background-color: #fff;");
    	out.println("    padding: 20px;");
    	out.println("    border-radius: 5px;");
    	out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
    	out.println("    width: 400px;"); // Augmentation de la largeur du formulaire
    	out.println("    margin-top: 50px;");
    	out.println("}");

    	out.println("label {");
    	out.println("    display: block;");
    	out.println("    margin-bottom: 8px;");
    	out.println("    color: #555;");
    	out.println("}");

    	out.println("input {");
    	out.println("    width: 100%;");
    	out.println("    padding: 10px;");
    	out.println("    margin-bottom: 10px;");
    	out.println("    box-sizing: border-box;");
    	out.println("}");

    	out.println("input[type=\"submit\"] {");
    	out.println("    background-color: #4caf50;"); // Couleur verte pour le bouton Login
    	out.println("    color: #fff;");
    	out.println("    cursor: pointer;");
    	out.println("    transition: background-color 0.3s;");
    	out.println("}");

    	out.println("input[type=\"submit\"]:hover {");
    	out.println("    background-color: #45a049;");
    	out.println("}");

    	out.println("</style>");
    	out.println("</head><body>");
    	out.println("<h2>Page de connexion</h2>");
    	out.println("<form method=\"post\" action=\"/Appels-offres/login\">");
    	out.println("<label for=\"username\">Nom:</label>");
    	out.println("<input type=\"text\" name=\"username\"><br>");
    	out.println("<label for=\"password\">Mot de passe:</label>");
    	out.println("<input type=\"password\" name=\"password\"><br>");
    	out.println("<input type=\"submit\" value=\"Login\">");
    	out.println("</form>");
    	out.println("</body></html>");





    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Traitement des données du formulaire POST
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Vous pouvez ajouter ici la logique de connexion, par exemple, en utilisant la classe AdminResource
        AdminResource adminResource = new AdminResource();
        String result = adminResource.adminLogin(username, password);

        // Si la connexion est réussie, afficher les boutons supplémentaires
     // ... (votre code existant)

        if (result.contains("Connexion réussie")) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Menu Admin</title></head><body>");
            out.println("<h2>Menu Admin</h2>");
            out.println("<p>" + result + "</p>");
            out.println("<form method=\"get\" action=\"/Appels-offres/rest/admin/users\">");
            out.println("<input type=\"submit\" value=\"Afficher les utilisateurs\"></form>");
            out.println("<form method=\"get\" action=\"/Appels-offres/rest/admin/candidatures\">");
            out.println("<input type=\"submit\" value=\"Afficher les candidatures\"></form>");
            out.println("<form method=\"get\" action=\"/Appels-offres/AddUsers.html\">");
            out.println("<input type=\"submit\" value=\"Ajouter un utilisateur\"></form>");
            out.println("<form method=\"get\" action=\"/Appels-offres/AddCandidature.html\">");
            out.println("<input type=\"submit\" value=\"Ajouter une candidature\"></form>");
            out.println("</body></html>");
        } 
 else {
            // Affichage du résultat de la connexion échouée dans la réponse
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Résultat de la connexion</title></head><body>");
            out.println("<h2>Résultat de la connexion</h2>");
            out.println("<p>" + result + "</p>");
            out.println("</body></html>");
        }
    }
}