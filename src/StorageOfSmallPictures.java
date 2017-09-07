import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arkan on 07.09.2017.
 */
public class StorageOfSmallPictures {
    private List<BufferedImage> im;
    private int numberOfLoadedPictures;
    private double[] widthOfSmallPicture;
    private double[] heightOfSmallPicture;
    private double finalWidthOfSmallPicture;
    private double finalHeightOfSmallPicture;
    List<BufferedImage> images;

    public StorageOfSmallPictures(){

    }
/*
    void readPictureFromDirectoryToList(List<BufferedImage> images) throws IOException {
        images = new ArrayList<BufferedImage>();
        File dir = new File("D:\\zrodlo\\");
        for(File file : dir.listFiles()){
            if(file.getName().toLowerCase().endsWith(".jpg")){
                images.add(ImageIO.read(file));
            }
        }
    } */

    ArrayList<BufferedImage> readPictureFromDirectoryToList() throws IOException {
        images = new ArrayList<BufferedImage>();
        File dir = new File("D:\\zrodlo\\");
        for(File file : dir.listFiles()){
            if(file.getName().toLowerCase().endsWith(".jpg")){
                images.add(ImageIO.read(file));
            }
        }
        this.setNumberOfLoadedPictures();
        return (ArrayList<BufferedImage>) (ArrayList<BufferedImage>) images;
    }

    void Scaling(){

    }
    public void setNumberOfLoadedPictures(){numberOfLoadedPictures = images.size();}
    public int getNumberOfLoadedPictures(){return this.numberOfLoadedPictures;}
}
