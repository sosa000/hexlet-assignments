package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPath(int page) {
        return postsPath() + "?page=" + page;
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    public static String postPath(long id) {
        String strId = String.valueOf(id);
        return postPath(strId);
    }
    // END
}
