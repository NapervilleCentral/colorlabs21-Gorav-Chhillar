
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{
    //Picture apic = new Picture("images\\koala2.jpg");
    //Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
    
    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /**/
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //relative path
     Picture apic = new Picture("images\\koala2.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     //Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
     //Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");

     
     //apic.explore();
     //ferris1.explore();
     
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
    
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


    /**/
        //access each index
    System.out.println(pixels[17]);
    //access each pixel
    Pixel spot = ferris1.getPixel(100,100);
    
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/*
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    for (Pixel spot : pixels)
    System.out.println( spot );


   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    ferris1.write("images/ferris11.jpg");

    /**/
  }//main
  
  /** 
   * method to mirror an a vertical line in the midde
   * of the picture based on the width 
   */
  public static void mirrorVertical(Picture source){
      int width = source.getWidth();
      int mirrorPoint = width/2;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      
      // loop through all the rows
      for(int y = 0; y < source.getHeight(); y++){
          //loop from 0 to the middle(mirror Point)
          for(int x = 0; x < mirrorPoint; x++){
              leftPixel = source.getPixel(x, y);
              rightPixel = source.getPixel(width - 1 - x. y);
              rightPixel.setColor(leftPixel.getColor());
          }
      }
  } // mirrorVertical
  
  /**
   * copy one picture to another picture/canvas
   * add two ints to params to place you want picture on the target
   */
  public static void copytoCanvas(Picture source, Picture target){
      Pixel sourcePix = null;
      Pixel targetPix = null;
      
      //loop through collums (target is the starting point on Canvas)
      for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++){
          //loop through the rows
          for (int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY++, targetY++){
              sourcePix = source.getPixel(sourceX, sourceY);
              targetPix = target.getPixel(targetX, targetY);
              targetPix.setColor(sourcePix.getColor());
            }
      }
  }
  
  
}//class
