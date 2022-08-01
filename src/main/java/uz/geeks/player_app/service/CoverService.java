package uz.geeks.player_app.service;

import uz.geeks.player_app.configs.ThreadPoolExecutorConfig;
import uz.geeks.player_app.dao.Dao;
import uz.geeks.player_app.dao.FileStorageDao;
import uz.geeks.player_app.domains.Cover;
import uz.geeks.player_app.dto.CoverDto;
import uz.geeks.player_app.exceptions.BadRequestException;

import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.function.Function;

public class CoverService implements Dao<FileStorageDao> {

    public static final Path rootPath = Paths.get("/home/ubuntu/player_app/src/main/webapp/images");

//    public static final CoverDao dao = CoverDao.getInstance();
    private static CoverService instance;
    private static final FileStorageDao dao = FileStorageDao.getInstance();

    public static CoverService getInstance() {
        if (instance == null) {
            instance = new CoverService(dao);
        }
        return instance;
    }

    public CoverService(FileStorageDao dao) {
        super();
        createUploadingFolders();
    }


    public void create(Part file, CoverDto dto) {
        ThreadPoolExecutorConfig.submit(() -> copyFile(file, dto.getGeneratedName()));
    }




    private void copyFile(Part is, String filename) {
        try {
            Files.copy(is.getInputStream(), rootPath.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Cover create(CoverDto coversDTO) {
        Cover covers = toDomain.apply(coversDTO);
        dao.create(covers);
        return covers;
    }

    private final Function<CoverDto, Cover> toDomain = Cover::toDomain;

    private void createUploadingFolders() {
        if (!Files.exists(FileStorageService.rootPath)) {
            try {
                Files.createDirectories(FileStorageService.rootPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public FileStorageDao create(FileStorageDao entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<FileStorageDao> findAll() {
        return null;
    }

    @Override
    public FileStorageDao findOne(Long id) {
        return null;
    }
}
