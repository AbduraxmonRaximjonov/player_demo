package uz.geeks.player_app.domains;

import jakarta.persistence.*;
import lombok.*;
import uz.geeks.player_app.dto.CoverDto;
import uz.geeks.player_app.dto.UploadsDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Cover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalName;
    @Column(unique = true, nullable = false)
    private String generatedName;
    private String contentType;

    private long size;
    private LocalDateTime uploaded_at;

    @Column(columnDefinition = "boolean default false")
    private boolean template;

    public static Cover toDomain(CoverDto dto) {
        return Cover.builder()
                .originalName(dto.getOriginalName())
                .generatedName(dto.getGeneratedName())
                .contentType(dto.getContentType())
                .size(dto.getSize())
                .uploaded_at(LocalDateTime.now())
                .build();
    }

}

