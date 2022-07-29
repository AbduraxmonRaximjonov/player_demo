package uz.geeks.player_app.domains;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * @Author :  Asliddin Ziyodullaev
 * @Date :  17:31   29/07/22
 * @Project :  player_app
 */
public class MusicPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private int pageCount;
    private Genre genre;
    private String seconds;
    @OneToOne
    private Uploads file;

    @OneToOne
    private Uploads cover;


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
