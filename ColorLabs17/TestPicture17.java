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
import java.awt.Color;

public class TestPicture17
{

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
     //Know it, Love it, Live it!!!
     //relative path                    dir/folder/file
     Picture white = new Picture("images\\white.correct.jpg");
     Picture radience1 = new Picture("images\\radience.jpg");
     Picture radience2 = new Picture("images\\radience.jpg");
     Picture radience3 = new Picture("images\\radience.jpg");
     Picture radience4 = new Picture("images\\radience.jpg");
     Picture radience5 = new Picture("images\\radience.jpg");
     Picture radience6 = new Picture("images\\radience.jpg");
     
     //apic.explore();
     //ferris1.explore();
     //moto.explore();
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = white.getPixels();
   
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );

/*
    /**/
        //access each index

        System.out.println(pixels[17]);
    //access each pixel
    Pixel spot = white.getPixel(100,100);
    Pixel spot2 = white.getPixel(433,283);
    /*Pixel ferr17 = pixels[17];
   
   
    ferr17.setRed(240);
    ferr17.setGreen(160);
    ferr17.setBlue(200);  
    Color newColor = new Color(255,99,71);
    spot.setColor(newColor);
   
   
    //ferris1.explore();
   
   
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    for (int i = 0; i<10000; i++){
        Pixel yuck = ferris1.getPixel((int)Math.random()*1000, (int)Math.random()*1000);
        yuck.setColor(Color.green);
    }
    //ferris1.explore();
 */  
   
   
    Pixel[] Mpixels;
    Mpixels = radience1.getPixels();
    Pixel[] Mpixels2;
    Mpixels2 = radience2.getPixels();
    Pixel[] Mpixels3;
    Mpixels3 = radience3.getPixels();
    Pixel[] Mpixels4;
    Mpixels4 = radience4.getPixels();
    Pixel[] Mpixels5;
    Mpixels5 = radience5.getPixels();
    Pixel[] Mpixels6;
    Mpixels6 = radience6.getPixels();
   // pixels[17].setColor(Color.blue);
   // spot.setColor(new Color(252,252,252));
    //pixels[500034].setColor(Color.blue);

    //ferris1.explore();

   // loop to access indexes of array or collection
//red
   //for each loop spot  is a ?
    for (Pixel spot1 : Mpixels){
    //System.out.println( spot );
    int red=spot1.getRed();
    red=(int)(red*2);
    spot1.setRed(red);
   
}
//ferris1.explore();

//blue
 
for (Pixel spot1 : Mpixels2){
    //System.out.println( spot );
    int blue=spot1.getBlue();
    blue=(int)(blue*2);
    spot1.setBlue(blue);
   
}
//ferris2.explore();  

//green

for (Pixel spot1 : Mpixels3){
    //System.out.println( spot );
    int green=spot1.getGreen();
    green=(int)(green*2);
    spot1.setGreen(green);
   
}
//ferris3.explore();  



for (Pixel spot1 : Mpixels4){
    int red=spot1.getRed();
    int blue=spot1.getBlue();
    int green=spot1.getGreen();
    int avg=(red+blue+green)/3;
    spot1.setGreen(avg);
    spot1.setBlue(avg);
    spot1.setRed(avg);
}
//ferris4.explore();
for (Pixel spot1 : Mpixels5){
    int red=spot1.getRed();
    int blue=spot1.getBlue();
    int green=spot1.getGreen();
    int avg=(red+blue+green)/3;
    spot1.setGreen(255-green);
    spot1.setBlue(255-blue);
    spot1.setRed(255-red);
}
//ferris5.explore();


for (Pixel spot1 : Mpixels6){
    int red=spot1.getRed();
    int blue=spot1.getBlue();
    int green=spot1.getGreen();
    spot1.setGreen(green+50);
    spot1.setBlue(blue-50);
    spot1.setRed(green+50);
}
//ferris6.explore();
 /*
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
    radience1.write("images/radience.jpg");
    mirrorVertical(radience2);
    radience2.explore();
    //copytoCanvas(ferris1,640x480);

    /**/
  }//main
  
  public static void mirrorVertical(Picture source){
      int width = source.getWidth();
      int mirrorPoint = 276;//source.getWidth/2
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      //loop through all the rows
      for(int y=0; y<156; y++){//source.getHeight
          //loop from 0 to the middle (mirror point)
          for(int x = 0; x<mirrorPoint; x++){
              leftPixel = source.getPixel(x,y);
              rightPixel = source.getPixel(width-1-x,y);
              rightPixel.setColor(leftPixel.getColor());
          }
      }
  }//mirrorVertical
  
  //add two ints to params to place the picture you want on the target
  //to make it smaller, do sourceX+=2
  //to make it bigger sourceX+=.5  larger, copies every pixel twice but you have to cast as int in the getPix and setColor
  public static void copytoCanvas(Picture source, Picture target){
      Pixel sourcePix = null;
      Pixel targetPix = null;
     
      //loop thru jcolumns(targetX is starting point on canvas)
     
      for (int sourceX=0,targetX=0; sourceX<source.getWidth();sourceX++,targetX++)
      {
          //loops thru rows, also needs to be sourceY+=2 to make it smaller, skips every other pixel
          //sourceY+=0.5 to make it copy every pixel twice, bigger
          for (int sourceY=0,targetY=0; sourceY<source.getHeight();sourceY++,targetY++){
              sourcePix = source.getPixel(sourceX,sourceY);
              targetPix = target.getPixel(targetX,targetY);
              targetPix.setColor(sourcePix.getColor());
          }
      }
  }
  
  // recursion
  /**
 * Method to recursively copy the picture onto itself
 * Each recursive call makes the copy smaller
 */
public static void recursiveCopy(Picture source, int startX, int startY, int width, int height)
{
    // base case: stop when the area gets too small
    if (width < 20 || height < 20)
    {
        return;
    }
    
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // copy the top-left portion of the current area to the rest of the picture
    for (int y = startY; y < startY + height; y = y + 2)
    {
        for (int x = startX; x < startX + width; x = x + 2)
        {
            if (x < source.getWidth() - width/2 && y < source.getHeight() - height/2)
            {
                sourcePixel = source.getPixel(x, y);
                targetPixel = source.getPixel(x + width/2, y + height/2);
                targetPixel.setColor(sourcePixel.getColor());
            }
        }
    }
    
    // recursive call with smaller dimensions
    recursiveCopy(source, startX, startY, width/2, height/2);
}
  public static void grayscale(Picture source)
{
    Pixel[] pixels = source.getPixels();
    for (Pixel p : pixels)
    {
        int avg = (int)((p.getRed() + p.getGreen() + p.getBlue()) / 3.0);
        p.setRed(avg);
        p.setGreen(avg);
        p.setBlue(avg);
    }
}

/**
 * Method to negate all colors in a picture
 * @param source the picture to negate
 */
public static void negate(Picture source)
{
    Pixel[] pixels = source.getPixels();
    for (Pixel p : pixels)
    {
        p.setRed(255 - p.getRed());
        p.setGreen(255 - p.getGreen());
        p.setBlue(255 - p.getBlue());
    }
}

/**
 * Method to apply sepia tint to a picture
 * @param source the picture to tint
 */
public static void sepiaTint(Picture source)
{
    Pixel[] pixels = source.getPixels();
    
    for (Pixel p : pixels)
    {
        int red = p.getRed();
        int green = p.getGreen();
        int blue = p.getBlue();
        
        int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
        int newGreen = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
        int newBlue = (int)(0.272 * red + 0.534 * green + 0.131 * blue);
        
        if (newRed > 255) newRed = 255;
        if (newGreen > 255) newGreen = 255;
        if (newBlue > 255) newBlue = 255;
        
        p.setRed(newRed);
        p.setGreen(newGreen);
        p.setBlue(newBlue);
    }
}

/**
 * Method to posterize a picture (reduce number of colors)
 * @param source the picture to posterize
 * @param levels the number of color levels
 */
public static void posterize(Picture source, int levels)
{
    int rangeSize = 256 / levels;
    Pixel[] pixels = source.getPixels();
    
    for (Pixel p : pixels)
    {
        int red = p.getRed() / rangeSize * rangeSize;
        int green = p.getGreen() / rangeSize * rangeSize;
        int blue = p.getBlue() / rangeSize * rangeSize;
        
        p.setRed(red);
        p.setGreen(green);
        p.setBlue(blue);
    }
}

/**
 * Method to do edge detection on a picture
 * @param source the picture to detect edges on
 * @param amount the threshold amount
 */
public static void edgeDetection(Picture source, double amount)
{
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    for (int y = 0; y < source.getHeight() - 1; y++)
    {
        for (int x = 0; x < source.getWidth(); x++)
        {
            topPixel = source.getPixel(x, y);
            bottomPixel = source.getPixel(x, y + 1);
            
            double topAvg = (topPixel.getRed() + topPixel.getGreen() + topPixel.getBlue()) / 3.0;
            double bottomAvg = (bottomPixel.getRed() + bottomPixel.getGreen() + bottomPixel.getBlue()) / 3.0;
            
            if (Math.abs(topAvg - bottomAvg) < amount)
            {
                topPixel.setColor(Color.WHITE);
            }
            else
            {
                topPixel.setColor(Color.BLACK);
            }
        }
    }
}

/**
 * Method to mirror a picture horizontally
 * @param source the picture to mirror
 */
public static void mirrorHorizontal(Picture source)
{
    int width = source.getWidth();
    int height = source.getHeight();
    int mirrorPoint = height / 2;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    for (int y = 0; y < mirrorPoint; y++)
    {
        for (int x = 0; x < width; x++)
        {
            topPixel = source.getPixel(x, y);
            bottomPixel = source.getPixel(x, height - 1 - y);
            bottomPixel.setColor(topPixel.getColor());
        }
    }
}

/**
 * Method to blend two pictures together (50% each)
 * @param source1 the first picture
 * @param source2 the second picture
 */
public static void blend(Picture source1, Picture source2)
{
    int width = Math.min(source1.getWidth(), source2.getWidth());
    int height = Math.min(source1.getHeight(), source2.getHeight());
    
    for (int y = 0; y < height; y++)
    {
        for (int x = 0; x < width; x++)
        {
            Pixel pixel1 = source1.getPixel(x, y);
            Pixel pixel2 = source2.getPixel(x, y);
            
            int red = (int)(pixel1.getRed() * 0.5 + pixel2.getRed() * 0.5);
            int green = (int)(pixel1.getGreen() * 0.5 + pixel2.getGreen() * 0.5);
            int blue = (int)(pixel1.getBlue() * 0.5 + pixel2.getBlue() * 0.5);
            
            pixel1.setRed(red);
            pixel1.setGreen(green);
            pixel1.setBlue(blue);
        }
    }
}

}