package uz.geeks.player_app.util;

import lombok.NonNull;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author "Elmurodov Javohir"
 * @since 26/07/22/14:10 (Tuesday)
 * java-ee/IntelliJ IDEA
 */
public class Utils {
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
