package www.autohero.com.de.additional;

import java.io.File;

public class GeckoDriver {

    private static final String PATH_TO_GECKO = "lib\\geckodriver.exe";

    public static String getPathToGeckoService() {
        File file = new File(PATH_TO_GECKO);
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
            return file.getAbsolutePath();
        }
        return null;
    }
}
