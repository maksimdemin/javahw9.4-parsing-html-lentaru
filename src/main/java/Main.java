import com.deminmax.DownloadImages;
import com.deminmax.ImageParser;
import java.io.IOException;
import java.net.UnknownHostException;

public class Main {

    private static final String URL_LENTARU = "https://lenta.ru";

    public static void main(String[] args) throws IOException {

        try {
            DownloadImages.downloadsImages(new ImageParser().parseHTMLFromURL(URL_LENTARU));
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}
