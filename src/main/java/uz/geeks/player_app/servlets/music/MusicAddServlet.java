package uz.geeks.player_app.servlets.music;

import uz.geeks.player_app.service.MusicPlayerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
@MultipartConfig
public class MusicAddServlet extends HttpServlet {

    private final MusicPlayerService music = MusicPlayerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dp = req.getRequestDispatcher("/views/music/add.jsp");
        dp.forward(req, resp);
//        PrintWriter writer = resp.getWriter();
//        writer.println("sss");
    }
//    private final static FileStorageService fileStorageService = ApplicationContext.getBean(FileStorageService.class);
//
//    private static MusicPlayerDao dao = ApplicationContext.getBean(MusicPlayerDao.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            music.create(req);
            resp.sendRedirect("/musics");
//        PrintWriter writer = resp.getWriter();
//        writer.println("sss");
    }
//    private static final Function<HttpServletRequest, MusicPlayerDto> toDTO = MusicPlayerDto::toDTO;
//    private static final Function<MusicPlayerDto, MusicPlayer> toMusicPlayerDomain = MusicPlayer::toDomain;
//    private static final Function<Part, UploadsDTO> toUploadsDTO = UploadsDTO::toDTO;
}
