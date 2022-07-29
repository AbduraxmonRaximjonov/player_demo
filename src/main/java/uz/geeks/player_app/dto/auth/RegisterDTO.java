package uz.geeks.player_app.dto.auth;

import lombok.*;
import uz.geeks.player_app.domains.AuthUser;
import uz.geeks.player_app.util.Utils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RegisterDTO {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;

    public AuthUser toDomain() {
        return AuthUser.builder()
                .username(this.username)
                .password(Utils.encodePassword(this.password))
                .build();
    }
}
