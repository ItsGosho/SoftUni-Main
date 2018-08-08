package http;

public final class WebConstants {
    public static final Integer DEFAULT_SERVER_PORT = 80;

    public static final String SERVER_HTTP_VERSION = "HTTP/1.1";

    public static final String RESOURCE_FOLDER_PATH =
            System.getProperty("user.dir")
            + "\\src\\resources\\";

    public static final String ASSETS_FOLDER_PATH =
            RESOURCE_FOLDER_PATH + "assets\\";

    public static final String PAGES_FOLDER_PATH =
            RESOURCE_FOLDER_PATH + "pages\\";

    private WebConstants() { }
}
