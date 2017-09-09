import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by arkan on 07.09.2017.
 */
public class Shower {
    void savePicture(int positionX, int positionY, StorageOfSmallPictures small, FinalImage finalImage) throws IOException {
        BufferedImage[] socket;
        positionX = 0;
        positionY = 0;
        int newW, newH;
        socket = new BufferedImage[small.getNumberOfLoadedPictures()];
        for(int i=0; i<small.getNumberOfLoadedPictures(); i++){
            socket[i] = small.images.get(i);
            //socket[i] = small.resize(socket[i], 10, 10); -> w miejsce 10, 10 wstawić przeskalowane wartości wys/szer
            newW = ((finalImage.getWidthOfFinalPicture() / finalImage.cellsVertically) / socket[i].getWidth()) * socket[i].getWidth();
            //newH = ((finalImage.getHeightOfFinalPicture() / finalImage.cellsHorizontally) / socket[i].getHeight()) * socket[i].getHeight();
            newH = (newW/socket[i].getWidth()) * socket[i].getHeight();
            socket[i] = small.resize(socket[i], newW/3, newH/3); //socket[i].getWidth(), socket[i].getHeight());
        }
        BufferedImage result = finalImage.createFinalWorkingArea();
        Graphics g = result.getGraphics();
        int licznik = 0;
        for(int i=0; i<small.getNumberOfLoadedPictures(); i++){
            g.drawImage(socket[i], positionX, positionY, null);
            //change positionX and positionY with values after scaling

            //positionX = positionX + small.images.get(i).getWidth();
            positionX = positionX + socket[i].getWidth();
            licznik = finalImage.cellsHorizontally;
            if(((i+1) % (licznik)) == 0 && i != 0) {             //(i%(f.cellsHorizontally-1))==0)   (i==(f.cellsHorizontally-1))
                positionX = 0;
              //  positionY = positionY + small.images.get(i).getHeight();
                positionY = positionY + socket[i].getHeight();
            }
        }
        ImageIO.write(result, "jpg", new File("D:\\zrodlo\\result.jpg"));
    }
}
