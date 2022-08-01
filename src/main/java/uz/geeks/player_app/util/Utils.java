package uz.geeks.player_app.util;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.mindrot.jbcrypt.BCrypt;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;

/**
 * @author "Elmurodov Javohir"
 * @since 26/07/22/14:10 (Tuesday)
 * java-ee/IntelliJ IDEA
 */
public class Utils {

    public static String ROOT_PATH = "/home/ubuntu/player_app/src/main/resources/downloads";
    public static String COVER_EXTENSION = "jpg";
    public static final String COVER_CONTENT_TYPE = "image/" + COVER_EXTENSION;

    public static boolean isDigit(@NonNull String character) {
        if (character.isBlank())
            return false;
        for (char ch : character.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    @SneakyThrows
    public static double getDurationOfMusic(String generatedName){
        File file = new File(ROOT_PATH+generatedName);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        AudioFormat format = audioInputStream.getFormat();
        long frames = audioInputStream.getFrameLength();
        return (frames+0.0) / format.getFrameRate();
    }

    public static String generateUniqueFileName() {
        return generateSerialId() + ".pdf";
    }

    public static String generateUniqueCoverName() {
        return generateSerialId() + "." + COVER_EXTENSION;
    }

    public static String getCoverFileName(@NonNull String filename) {
        return filename.substring(0, filename.indexOf(".")) + "." + COVER_EXTENSION;
    }

    private static String generateSerialId() {
        return "" + System.currentTimeMillis();
    }


    public static String encodePassword(@NonNull final String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static boolean matchPassword(@NonNull final String plainPassword, @NonNull final String encodedPassword) {
        return BCrypt.checkpw(plainPassword, encodedPassword);
    }


}
