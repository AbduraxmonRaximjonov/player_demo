package uz.geeks.player_app.service;

import lombok.NonNull;
import uz.geeks.player_app.container.ApplicationContext;
import uz.geeks.player_app.dao.AuthUserDao;
import uz.geeks.player_app.domains.AuthUser;
import uz.geeks.player_app.dto.auth.RegisterDTO;
import uz.geeks.player_app.exceptions.BadRequestException;
import uz.geeks.player_app.util.Utils;

import java.util.Objects;

public class AuthUserService extends Service<AuthUserDao> {

    private static AuthUserService instance;

    private static final AuthUserDao authUserDao = AuthUserDao.getInstance();
    public static AuthUserService getInstance() {
        if (instance == null) {
            instance = new AuthUserService(authUserDao);
        }
        return instance;
    }

    public AuthUserService(AuthUserDao dao) {
        super(dao);
    }


    public void create(@NonNull RegisterDTO dto) {

        if (Objects.isNull(dto.getPassword()))
            throw new BadRequestException("Password can not be null");

        if (!Objects.equals(dto.getPassword(), dto.getConfirmPassword()))
            throw new BadRequestException("Password did not match");

        AuthUser authUser = dto.toDomain();
        dao.create(authUser);
    }

    public AuthUser login(String username, String password) {
        AuthUser authUser = dao.findByUsername(username).orElseThrow(() -> {
            throw new BadRequestException("Bad credentials");
        });
        if (!Utils.matchPassword(password, authUser.getPassword())) {
            throw new BadRequestException("Bad credentials");
        }
        return authUser;
    }
}
