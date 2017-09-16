import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        FinalImage f = new FinalImage();
        BufferedImage tmp2 = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        tmp2 = f.createFinalWorkingArea();
        f.checkNumberOfSocketsInRowsAndColumns(small.getNumberOfLoadedPictures());
        Shower show = new Shower();

        show.savePicture(0,0, small, f);
    }
}
