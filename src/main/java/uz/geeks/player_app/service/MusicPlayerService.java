package uz.geeks.player_app.service;

import uz.geeks.player_app.container.ApplicationContext;
import uz.geeks.player_app.dao.MusicPlayerDao;
import uz.geeks.player_app.domains.Cover;
import uz.geeks.player_app.domains.MusicPlayer;
import uz.geeks.player_app.domains.Uploads;
import uz.geeks.player_app.dto.CoverDto;
import uz.geeks.player_app.dto.MusicPlayerDto;
import uz.geeks.player_app.dto.UploadsDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@MultipartConfig
public class MusicPlayerService extends Service<MusicPlayerDao> {
    private static MusicPlayerService instance;

    private static final CoverService coverService = CoverService.getInstance();
    private static final MusicPlayerDao musicPlayerDao = MusicPlayerDao.getInstance();

    public static MusicPlayerService getInstance() {
        if (instance == null) {
            instance = new MusicPlayerService(musicPlayerDao);
        }
        return instance;
    }

    private final static FileStorageService fileStorageService = FileStorageService.getInstance();

    public MusicPlayerService(MusicPlayerDao dao) {
        super(dao);
    }


    public void create(HttpServletRequest req) throws IOException, ServletException {
        Part cover = req.getPart("cover");
        System.out.println(cover);
        Part audio = req.getPart("music");

        MusicPlayerDto musicDTO = toDTO.apply(req);

        UploadsDTO uploadsDTO = toUploadsDTO.apply(audio);
        CoverDto coverDto = toCoverDTO.apply(cover);
        MusicPlayer music = toMusicPlayerDomain.apply(musicDTO);
        Uploads uploadedFile = fileStorageService.create(uploadsDTO);
        Cover cover1 = coverService.create(coverDto);

//        Uploads templateCover = fileStorageService.getOneTemplateCover();
        music.setFile(uploadedFile);
        music.setCover(cover1);
        dao.create(music);
        uploadsDTO.setMusicPlayerId(music.getId());
        coverDto.setMusicPlayerId(music.getId());
        fileStorageService.create(audio, uploadsDTO);
        coverService.create(cover, coverDto);

//        if (!Objects.isNull(cover)) {
//            UploadsDTO coverDTO = toUploadsDTO.apply(cover);
//            coverDTO.setMusicPlayerId(music.getId());
//            fileStorageService.create(cover, uploadsDTO);
//        }
    }

    private static final Function<HttpServletRequest, MusicPlayerDto> toDTO = MusicPlayerDto::toDTO;
    private static final Function<MusicPlayerDto, MusicPlayer> toMusicPlayerDomain = MusicPlayer::toDomain;
    private static final Function<Part, UploadsDTO> toUploadsDTO = UploadsDTO::toDTO;
    private static final Function<Part, CoverDto> toCoverDTO = CoverDto::toDTO;

}
