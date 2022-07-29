package uz.geeks.player_app.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import uz.geeks.player_app.configs.ThreadPoolExecutorConfig;
import uz.geeks.player_app.dao.FileStorageDao;
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
    public static final Path rootPath = Paths.get("home/asliddin/uploads");

//    public static final BookDao bookDao = ApplicationContext.getBean(BookDao.class);

    public FileStorageService(FileStorageDao dao) {
        super(dao);
        createUploadingFolders(rootPath);
    }


    public void create(Part file, UploadsDTO dto) {
        ThreadPoolExecutorConfig.submit(() -> copyFile(file, dto.getGeneratedName()));
        ThreadPoolExecutorConfig.submit(() -> generateCoverAndUpdateInitialCover(file, dto));
    }

    private void generateCoverAndUpdateInitialCover(Part is, UploadsDTO dto) {
        try {
            PDDocument document = PDDocument.load(is.getInputStream());
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage bufferedImage = pdfRenderer.renderImage(0, 10, ImageType.RGB);
            UploadsDTO coverUploadsDto = getCoverUploadsDto(dto);
            Uploads uploads = create(coverUploadsDto);
//            bookDao.updateCoverId(dto.getBookId(), uploads.getId());
            ImageIOUtil.writeImage(bufferedImage, rootPath.resolve(coverUploadsDto.getGeneratedName()).toString(), 10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UploadsDTO getCoverUploadsDto(UploadsDTO dto) {
        return UploadsDTO.builder()
                .originalName(Utils.getCoverFileName(dto.getOriginalName()))
                .generatedName(Utils.generateUniqueCoverName())
                .size(0)
                .contentType(Utils.COVER_CONTENT_TYPE)
                .build();
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

    private void createUploadingFolders(Path rootPath) {
        if (!Files.exists(rootPath)) {
            try {
                Files.createDirectories(rootPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
