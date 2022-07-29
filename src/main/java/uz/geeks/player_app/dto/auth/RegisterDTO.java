package uz.geeks.player_app.dto.auth;

import lombok.*;
import uz.jl.java_ee.domains.AuthUser;
import uz.jl.java_ee.util.Utils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RegisterDTO {
    private String username;
    private String password;
    private String confirmPassword;

    public AuthUser toDomain() {
        return AuthUser.builder()
                .username(this.username)
                .password(Utils.encodePassword(this.password))
                .build();
    }
}
