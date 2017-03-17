import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 17.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        URL url= new URL("http://lib.ru");
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        String ct=conn.getHeaderField("Content-type");
        System.out.println(ct);
        try (InputStream is=conn.getInputStream()){
            ByteArrayOutputStream bos= new ByteArrayOutputStream();
            while (true) {
                int c = is.read();
                if (c < 0)
                    break;
                bos.write(c);
            }
            System.out.println(bos.toString("Cp1251"));
        }
        conn.disconnect();
    }
}
