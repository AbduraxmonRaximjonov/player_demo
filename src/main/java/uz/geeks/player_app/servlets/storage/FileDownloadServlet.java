package uz.geeks.player_app.servlets.storage;

import uz.geeks.player_app.dao.CoverDao;
import uz.geeks.player_app.dao.UploadsDao;
import uz.geeks.player_app.domains.Cover;
import uz.geeks.player_app.domains.Uploads;
import uz.geeks.player_app.exceptions.BadRequestException;
import uz.geeks.player_app.service.CoverService;
import uz.geeks.player_app.service.FileStorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;


@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {

    private final static UploadsDao uploadDao = UploadsDao.getInstance();

    private final CoverDao coverDao = CoverDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        String cover = req.getParameter("cover");

        Path resolvedPath = null;
        if (Objects.nonNull(filename)) {
            Uploads uploads = uploadDao.findByGeneratedName(filename).orElseThrow(() -> {
                throw new BadRequestException("File not found");
            });
           resolvedPath = FileStorageService.rootPath.resolve(filename);
            resp.setContentType(uploads.getContentType());
        } else {
            Cover cover_ = coverDao.findByGeneratedName(cover).orElseThrow(() -> {
                throw new BadRequestException("File not found");
            });
            resolvedPath = CoverService.rootPath.resolve(cover);
            resp.setContentType(cover_.getContentType());
        }
        FileInputStream fileInputStream = new FileInputStream(resolvedPath.toString());
        byte[] bytes = fileInputStream.readAllBytes();
        resp.getOutputStream().write(bytes);
    }
}
