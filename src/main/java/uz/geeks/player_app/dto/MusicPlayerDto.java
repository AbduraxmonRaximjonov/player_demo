package uz.geeks.player_app.dto;

import jakarta.persistence.OneToOne;
import uz.geeks.player_app.domains.MusicPlayer;
import uz.geeks.player_app.domains.Uploads;

public class MusicPlayerDto {
    private Long id;
    private String name;
    private String author;
    private int pageCount;
    private MusicPlayer.Genre genre;
    private String seconds;
    private Uploads file;
    private Uploads cover;
}
