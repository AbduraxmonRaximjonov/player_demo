package uz.geeks.player_app.dto;

import jakarta.persistence.OneToOne;
import lombok.*;
import uz.geeks.player_app.domains.Cover;
import uz.geeks.player_app.domains.MusicPlayer;
import uz.geeks.player_app.domains.Uploads;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MusicPlayerDto {
    private Long id;
    private String name;
    private String author;
    private String genre;
    private Uploads file;
    private Cover cover;
    private String chrome_url;
    private String youTube_url;

    public static MusicPlayerDto toDTO(HttpServletRequest request) {
        return MusicPlayerDto.builder().name(request.getParameter("name"))
                .author(request.getParameter("author"))
                .genre(request.getParameter("genre"))
                .chrome_url(request.getParameter("chrome_url"))
                .youTube_url(request.getParameter("youTube_url"))
                .build();
    }
}
