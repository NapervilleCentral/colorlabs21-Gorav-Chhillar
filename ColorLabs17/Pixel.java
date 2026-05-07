import java.awt.*;
import java.awt.image.*;

/**
 * Pixel class for AP Computer Science A
 * Represents a single pixel in an image
 */
public class Pixel
{
    private BufferedImage image;
    private int x;
    private int y;
    
    public Pixel(BufferedImage image, int x, int y)
    {
        this.image = image;
        this.x = x;
        this.y = y;
    }
    
    public int getRed()
    {
        int rgb = image.getRGB(x, y);
        return (rgb >> 16) & 0xFF;
    }
    
    public int getGreen()
    {
        int rgb = image.getRGB(x, y);
        return (rgb >> 8) & 0xFF;
    }
    
    public int getBlue()
    {
        int rgb = image.getRGB(x, y);
        return rgb & 0xFF;
    }
    
    public void setRed(int value)
    {
        Color c = new Color(image.getRGB(x, y));
        image.setRGB(x, y, new Color(value, c.getGreen(), c.getBlue()).getRGB());
    }
    
    public void setGreen(int value)
    {
        Color c = new Color(image.getRGB(x, y));
        image.setRGB(x, y, new Color(c.getRed(), value, c.getBlue()).getRGB());
    }
    
    public void setBlue(int value)
    {
        Color c = new Color(image.getRGB(x, y));
        image.setRGB(x, y, new Color(c.getRed(), c.getGreen(), value).getRGB());
    }
    
    public void setColor(Color color)
    {
        image.setRGB(x, y, color.getRGB());
    }
    
    public Color getColor()
    {
        return new Color(image.getRGB(x, y));
    }
}