
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
     Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris4 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris5 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris6 = new Picture("images/2000 ferris wheel2.jpg");
     Picture temple = new Picture("images/temple.jpg");
     //apic.explore();
     //ferris1.explore();
     //moto.explore();
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
   
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );

/*
    /**/
        //access each index

        System.out.println(pixels[17]);
    //access each pixel
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(433,283);
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
    Mpixels = ferris1.getPixels();
    Pixel[] Mpixels2;
    Mpixels2 = ferris2.getPixels();
    Pixel[] Mpixels3;
    Mpixels3 = ferris3.getPixels();
    Pixel[] Mpixels4;
    Mpixels4 = ferris4.getPixels();
    Pixel[] Mpixels5;
    Mpixels5 = ferris5.getPixels();
    Pixel[] Mpixels6;
    Mpixels6 = ferris6.getPixels();
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
    ferris1.write("images/ferris11.jpg");
    mirrorVertical(temple);
    temple.explore();
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
}