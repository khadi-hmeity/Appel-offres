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
        out.println("<html><head><title>Login Page</title></head><body>");
        out.println("<h2>Login Page</h2>");
        out.println("<form method=\"post\" action=\"/Appels-offres/login\">");
        out.println("Nom: <input type=\"text\" name=\"username\"><br>");
        out.println("Mots de passe: <input type=\"password\" name=\"password\"><br>");
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

        // Affichage du résultat dans la réponse
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Résultat de la connexion</title></head><body>");
        out.println("<h2>Résultat de la connexion</h2>");
        out.println("<p>" + result + "</p>");
        out.println("</body></html>");
    }
}