package uz.geeks.player_app.service;

import lombok.NonNull;
import uz.jl.java_ee.container.ApplicationContext;
import uz.jl.java_ee.dao.AuthUserDao;
import uz.jl.java_ee.dao.Dao;
import uz.jl.java_ee.domains.AuthUser;
import uz.jl.java_ee.dto.auth.RegisterDTO;
import uz.jl.java_ee.exceptions.BadRequestException;
import uz.jl.java_ee.util.Utils;

import java.util.Objects;

public class AuthUserService extends Service<AuthUserDao> {

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
