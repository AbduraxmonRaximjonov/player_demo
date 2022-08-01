package uz.geeks.player_app.servlets.music;

import uz.geeks.player_app.container.ApplicationContext;
import uz.geeks.player_app.dao.MusicPlayerDao;
import uz.geeks.player_app.domains.MusicPlayer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = "/musics")
public class MusicListServlet extends HttpServlet {

    private final static MusicPlayerDao music = ApplicationContext.getBean(MusicPlayerDao.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("musics",music.findAll());
//        req.setAttribute("musics",List.of(music.findAll().get(0)));
//        RequestDispatcher dp = req.getRequestDispatcher("views/music/list.jsp");
        RequestDispatcher dp = req.getRequestDispatcher("player/index.jsp");
        dp.forward(req, resp);
    }
}
