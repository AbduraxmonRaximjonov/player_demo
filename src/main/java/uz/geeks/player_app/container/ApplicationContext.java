    package uz.geeks.player_app.container;


    import uz.geeks.player_app.dao.AuthUserDao;
    import uz.geeks.player_app.dao.FileStorageDao;
    import uz.geeks.player_app.dao.MusicPlayerDao;
    import uz.geeks.player_app.service.AuthUserService;
    import uz.geeks.player_app.service.FileStorageService;
    import uz.geeks.player_app.service.MusicPlayerService;

    public class ApplicationContext {

        private static MusicPlayerService MusicPlayerService() {
            return new MusicPlayerService(MusicPlayerDao());
        }

        private static MusicPlayerDao MusicPlayerDao() {
            return new MusicPlayerDao();
        }

        private static FileStorageDao fileStorageDao() {
            return new FileStorageDao();
        }

        private static FileStorageService fileStorageService() {
            return new FileStorageService(fileStorageDao());
        }

        private static AuthUserDao authUserDao() {
            return new AuthUserDao();
        }
        private static AuthUserService authUserService() {
            return new AuthUserService(authUserDao());
        }

        @SuppressWarnings("raw_types")
        public static <T> T getBean(Class<T> clazz) {
            return switch (clazz.getSimpleName()) {
                case "MusicPlayerDao" -> (T) MusicPlayerDao();
                case "MusicPlayerService" -> (T) MusicPlayerService();
                case "FileStorageService" -> (T) fileStorageService();
                case "FileStorageDao" -> (T) fileStorageDao();
                case "AuthUserDao" -> (T) authUserDao();
                case "AuthUserService" -> (T) authUserService();
                default -> throw new RuntimeException("Bean not found");
            };
        }
    }
