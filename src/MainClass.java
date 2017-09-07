import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arkan on 07.09.2017.
 */
public class MainClass {
    public static void main(String[] argc) throws IOException {
        StorageOfSmallPictures small = new StorageOfSmallPictures();
        List<BufferedImage> tmp = new ArrayList<BufferedImage>();

        tmp = small.readPictureFromDirectoryToList();
        System.out.println(tmp.size());

        System.out.println(small.getNumberOfLoadedPictures());

        
    }
}
