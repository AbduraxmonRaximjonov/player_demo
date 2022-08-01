package uz.geeks.player_app.domains;

import jakarta.persistence.*;
import lombok.*;
import uz.geeks.player_app.dto.MusicPlayerDto;

/**
 * @Author :  Asliddin Ziyodullaev
 * @Date :  17:31   29/07/22
 * @Project :  player_app
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class MusicPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private double duration;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @Column(columnDefinition = "varchar default 'https://music.amazon.com/'")
    private String chrome_url;
    @Column(columnDefinition = "varchar default 'https://www.youtube.com/c/MagicMusicGroup'")
    private String youTube_url;
    private int onClick;
    @OneToOne
    private Uploads file;

    @OneToOne
    private Cover cover;


    public static MusicPlayer toDomain(MusicPlayerDto dto) {
        return MusicPlayer.builder()
                .name(dto.getName())
                .author(dto.getAuthor())
                .genre(Genre.findGenreByName(dto.getGenre()))
                .chrome_url(dto.getChrome_url())
                .youTube_url(dto.getYouTube_url())
                .file(dto.getFile())
                .cover(dto.getCover())
                .build();
    }


    public enum Genre {
        CLASSIC,
        POPULAR_MUSIC,
        ROCK,
        POP,
        HIP_HOP,
        JAZZ,
        ELECTRONIC,
        EDM,
        MAQOM,
        NASHIDA,
        DISCO,
        MOTIVATION,
        OTHER;

        public static Genre findGenreByName(String genreName) {
            for (Genre genre : values()) {
                if (genre.name().equalsIgnoreCase(genreName)) {
                    return genre;
                }
            }
            return OTHER;
        }
    }
}
