import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by arkan on 07.09.2017.
 */
public class FinalImage {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double widthOfScreenOnPC = screenSize.getWidth();
    private double heightOfScreenOnPC = screenSize.getHeight();
    private int widthOfFinalPicture = (int) (widthOfScreenOnPC * 0.8);
    private int heightOfFinalPicture = (int) (heightOfScreenOnPC * 0.8);
    BufferedImage result;
    int cellsHorizontally = 0;
    int cellsVertically = 0;

    BufferedImage CreateFinalWorkingArea(){
        result = new BufferedImage(widthOfFinalPicture, heightOfFinalPicture, BufferedImage.TYPE_INT_RGB);
        return result;
    }

    void checkNumberOfSocketsInRowsAndColumns(int numberOfSmallPhotos, StorageOfSmallPictures small){
      //  numberOfSmallPhotos = small.getNumberOfLoadedPictures();
        do{
            cellsVertically++;
            {
                if((cellsHorizontally * cellsVertically) < numberOfSmallPhotos){
                    cellsHorizontally++;
                }
            }
        } while ((cellsHorizontally * cellsVertically) < numberOfSmallPhotos);
    }
    
}
