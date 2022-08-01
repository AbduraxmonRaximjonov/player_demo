package uz.geeks.player_app.dto;

import lombok.*;
import uz.geeks.player_app.util.Utils;

import javax.servlet.http.Part;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;

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
    private long musicPlayerId;


    @SneakyThrows
    public static UploadsDTO toDTO(Part part) {
        String originalName = part.getSubmittedFileName();
        String extension = originalName.substring(originalName.lastIndexOf("."));
        String generatedName = System.currentTimeMillis() + extension;
        return UploadsDTO.builder()
                .originalName(originalName)
                .contentType(part.getContentType())
                .size(part.getSize())
                .generatedName(generatedName)
                .build();
    }
}
