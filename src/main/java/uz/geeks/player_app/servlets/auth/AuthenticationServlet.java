package uz.geeks.player_app.servlets.auth;

import uz.geeks.player_app.container.ApplicationContext;
import uz.geeks.player_app.domains.AuthUser;
import uz.geeks.player_app.service.AuthUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth/login")
public class AuthenticationServlet extends HttpServlet {
    private final AuthUserService authUserService = ApplicationContext.getBean(AuthUserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AuthUser authUser = authUserService.login(username, password);
        HttpSession session = req.getSession();
        session.setAttribute("userId", authUser.getId());
        resp.sendRedirect("/");
    }
}
