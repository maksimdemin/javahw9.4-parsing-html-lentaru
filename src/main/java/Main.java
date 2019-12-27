import com.deminmax.DownloadImages;
import com.deminmax.ImageParser;
import java.nio.file.Path;

public class Main {

    private static final String URL_LENTARU = "https://lenta.ru";

    public static void main(String[] args) {

        try {
            Path pathDestinationFromUser = DownloadImages.pathFromUser();
            ImageParser imageParser = new ImageParser(URL_LENTARU);
            DownloadImages.downloadsImages(imageParser.parseHTMLFromURL(), pathDestinationFromUser);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
