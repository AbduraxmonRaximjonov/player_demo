package uz.geeks.player_app.service;

import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import uz.geeks.player_app.configs.ThreadPoolExecutorConfig;
import uz.geeks.player_app.container.ApplicationContext;
import uz.geeks.player_app.dao.FileStorageDao;
import uz.geeks.player_app.dao.MusicPlayerDao;
import uz.geeks.player_app.dao.UploadsDao;
import uz.geeks.player_app.domains.Uploads;
import uz.geeks.player_app.dto.UploadsDTO;
import uz.geeks.player_app.exceptions.BadRequestException;
import uz.geeks.player_app.util.Utils;

import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.function.Function;

public class FileStorageService extends Service<FileStorageDao> {
    public static final Path rootPath = Paths.get("/home/ubuntu/player_app/src/main/webapp/audios");

    public static final UploadsDao uploadsDao = UploadsDao.getInstance();
    private static FileStorageService instance;
    private static final FileStorageDao fileStorageDao = FileStorageDao.getInstance();

    public static FileStorageService getInstance() {
        if (instance == null) {
            instance = new FileStorageService(fileStorageDao);
        }
        return instance;
    }

    public FileStorageService(FileStorageDao dao) {
        super(dao);
        createUploadingFolders();
    }


    public void create(Part file, UploadsDTO dto) {
        ThreadPoolExecutorConfig.submit(() -> copyFile(file, dto.getGeneratedName()));
    }




    private void copyFile(Part is, String filename) {
        try {
            Files.copy(is.getInputStream(), rootPath.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Uploads create(UploadsDTO uploadsDTO) {
        Uploads uploads = toDomain.apply(uploadsDTO);
        dao.create(uploads);
        return uploads;
    }

    public Uploads getOneTemplateCover() {
        return dao.getOneTemplateCover().orElseThrow(() -> {
            throw new BadRequestException("Template Not Found");
        });
    }

    private final Function<UploadsDTO, Uploads> toDomain = Uploads::toDomain;

    private void createUploadingFolders() {
        if (!Files.exists(FileStorageService.rootPath)) {
            try {
                Files.createDirectories(FileStorageService.rootPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
