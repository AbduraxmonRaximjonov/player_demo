package uz.geeks.player_app.dto;

import lombok.*;

import javax.servlet.http.Part;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CoverDto {
    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;
    private long musicPlayerId;


    @SneakyThrows
    public static CoverDto toDTO(Part part) {
        String originalName = part.getSubmittedFileName();
        String extension = originalName.substring(originalName.lastIndexOf("."));
        String generatedName = System.currentTimeMillis() + extension;
        return CoverDto.builder()
                .originalName(originalName)
                .contentType(part.getContentType())
                .size(part.getSize())
                .generatedName(generatedName)
                .build();
    }
}
