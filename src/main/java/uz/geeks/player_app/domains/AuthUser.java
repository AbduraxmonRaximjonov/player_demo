package uz.geeks.player_app.domains;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    private String phoneNumber;

    public enum Role {
      USER, ADMIN;

        public static Role findByRoleName(String role) {
            for (Role userRole : values()) {
                if (userRole.name().equalsIgnoreCase(role)) {
                    return userRole;
                }
            }
            return USER;
        }
    }

}
