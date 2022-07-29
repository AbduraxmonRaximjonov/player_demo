package uz.geeks.player_app.dto;

import lombok.*;
import uz.geeks.player_app.util.Utils;

import javax.servlet.http.Part;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UploadsDTO {
    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;
    private long MusicPlayerId;


    public static UploadsDTO toDTO(Part part) {
        return UploadsDTO.builder()
                .originalName(part.getSubmittedFileName())
                .contentType(part.getContentType())
                .size(part.getSize())
                .generatedName(Utils.generateUniqueFileName())
                .build();
    }
}
