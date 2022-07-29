package uz.geeks.player_app.domains;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 26/07/22/15:10 (Tuesday)
 * java-ee/IntelliJ IDEA
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Uploads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private String url;
    private long size;
    private LocalDateTime uploaded_at;

    @Column(columnDefinition = "boolean default false")
    private boolean template;

}
