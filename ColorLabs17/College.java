/**
 * College Project for AP Computer Science A
 * Creates a collage with 6 versions of an image
 * including filters, mirroring, and recursive manipulation
 */
public class College
{
    public static void main(String[] args)
    {
        String imagePath = "images/beach.jpg";
        Picture original = new Picture(imagePath);
        
        int w = original.getWidth();
        int h = original.getHeight();
        
        Picture canvas = new Picture(w * 3, h * 2);
        
        Picture gray = new Picture(imagePath);
        gray.grayscale();
        canvas.copyPicture(gray, 0, 0);
        
        Picture neg = new Picture(imagePath);
        neg.negate();
        canvas.copyPicture(neg, w, 0);
        
        canvas.copyPicture(original, w * 2, 0);
        
        Picture sepia = new Picture(imagePath);
        sepia.sepiaTint();
        canvas.copyPicture(sepia, 0, h);
        
        Picture poster = new Picture(imagePath);
        poster.posterize(4);
        canvas.copyPicture(poster, w, h);
        
        Picture mirror = new Picture(imagePath);
        mirror.mirrorVertical();
        canvas.copyPicture(mirror, w * 2, h);
        
        mirrorVerticalFull(canvas);
        
        canvas.write("finalCollege.jpg");
        canvas.explore();
    }
    
    /**
     * Method to mirror the entire canvas vertically
     * @param source the picture to mirror
     */
    public static void mirrorVerticalFull(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int y = 0; y < source.getHeight(); y++)
        {
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = source.getPixel(x, y);
                rightPixel = source.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
}