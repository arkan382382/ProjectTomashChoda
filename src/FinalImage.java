import java.awt.*;
import java.awt.image.BufferedImage;

public class FinalImage {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double widthOfScreenOnPC = screenSize.getWidth();
    private double heightOfScreenOnPC = screenSize.getHeight();
    private int widthOfFinalPicture = (int) (widthOfScreenOnPC * 0.8);
    private int heightOfFinalPicture = (int) (heightOfScreenOnPC * 0.8);
    BufferedImage result;
    int cellsHorizontally = 0;
    int cellsVertically = 0;

    BufferedImage createFinalWorkingArea(){
        result = new BufferedImage(widthOfFinalPicture, heightOfFinalPicture, BufferedImage.TYPE_INT_RGB);
        return result;
    }

    void checkNumberOfSocketsInRowsAndColumns(int numberOfSmallPhotos){
        do{
            cellsVertically++;
            {
                if((cellsHorizontally * cellsVertically) < numberOfSmallPhotos){
                    cellsHorizontally++;
                }
            }
        } while ((cellsHorizontally * cellsVertically) < numberOfSmallPhotos);
    }

    public int getWidthOfFinalPicture(){
        return this.widthOfFinalPicture;
    }
    public int getHeightOfFinalPicture(){
        return this.heightOfFinalPicture;
    }
}
