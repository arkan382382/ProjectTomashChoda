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
        System.out.println(tmp.size());

        System.out.println(small.getNumberOfLoadedPictures());

            FinalImage f = new FinalImage();
            BufferedImage tmp2 = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
            tmp2 = f.createFinalWorkingArea();
        System.out.println(tmp2.getWidth() + " " + tmp2.getHeight());

        System.out.println(f.cellsHorizontally + " " + f.cellsVertically);
        f.checkNumberOfSocketsInRowsAndColumns(small.getNumberOfLoadedPictures(), small);
        System.out.println(f.cellsHorizontally + " " + f.cellsVertically);
            Shower show = new Shower();
            show.savePicture();

            // test zapisu
        BufferedImage[] socket = new BufferedImage[small.getNumberOfLoadedPictures()];
        int positionX = 0;
        int positionY = 0;

        for(int i=0; i<small.getNumberOfLoadedPictures(); i++){
            socket[i] = small.images.get(i);
        }
        BufferedImage result = f.createFinalWorkingArea();
        Graphics g = result.getGraphics();
        int licznik = 0;
        for(int i=0; i<small.getNumberOfLoadedPictures(); i++){
            g.drawImage(socket[i], positionX, positionY, null);
            //change positionX and positionY with values after scaling
            positionX = positionX + small.images.get(i).getWidth();
            licznik = f.cellsHorizontally;
            if((i % licznik) == 0 && i != 0){             //(i%(f.cellsHorizontally-1))==0)   (i==(f.cellsHorizontally-1))
                positionX = 0;
                positionY = positionY + small.images.get(i).getHeight();
            }
           // positionY = positionY + small.images.get(i).getHeight();
           // if(i==(f.cellsVertically-1)){
           //     positionY = 0;
           // }
        }
        ImageIO.write(result, "jpg", new File("D:\\zrodlo\\result.jpg"));
    }
}
