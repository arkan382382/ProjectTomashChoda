import javafx.scene.transform.Scale;

import javax.imageio.ImageIO;
import java.awt.image.AffineTransformOp;
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
    private int[] widthOfSmallPictureAfterScalling = new int[this.numberOfLoadedPictures];
    private int[] heightOfSmallPictureAfterScalling = new int[this.numberOfLoadedPictures];
    List<BufferedImage> images;

    public StorageOfSmallPictures(){
    }

    ArrayList<BufferedImage> readPictureFromDirectoryToList() throws IOException {
        images = new ArrayList<BufferedImage>();
        File dir = new File("D:\\zrodlo\\");
        for(File file : dir.listFiles()){
            if((file.getName().toLowerCase().endsWith(".jpg")) && !file.getName().endsWith("result.jpg")){
                images.add(ImageIO.read(file));
            }
        }
        this.setNumberOfLoadedPictures();
        return (ArrayList<BufferedImage>) (ArrayList<BufferedImage>) images;
    }

    FinalImage finalImage = new FinalImage();

    public BufferedImage resize(BufferedImage src, int resizedW, int resizedH){
        BufferedImage img = new BufferedImage(resizedW, resizedH, BufferedImage.TYPE_INT_RGB);
        int i, j;
        int wSource = src.getWidth();
        int hSource = src.getHeight();
        for(i = 0; i < resizedW; i++){
            for(j = 0; j < resizedH; j++){
                int temporary = src.getRGB(i*wSource/resizedW, j*hSource/resizedH);
                img.setRGB(i, j, temporary);
            }
        }
        return img;
    }

    public void setNumberOfLoadedPictures(){numberOfLoadedPictures = images.size();}
    public int getNumberOfLoadedPictures(){return this.numberOfLoadedPictures;}
    public int getWidthOfSmallPicturesAfterScalling(int counter){
        return this.widthOfSmallPictureAfterScalling[counter];
    }
    public int getHeightOfSmallPicturesAfterScalling(int counter){
        return this.heightOfSmallPictureAfterScalling[counter];
    }
}
