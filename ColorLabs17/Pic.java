import java.awt.Color;

public class Pic extends SimplePicture
{
    public Pic()
    {
        super();
    }
    
    public Pic(String fileName)
    {
        super(fileName);
    }
    
    public Pic(int width, int height)
    {
        super(width, height);
    }
    
    public Pic(Pic copy)
    {
        super(copy);
    }
    
    public Pic(java.awt.image.BufferedImage image)
    {
        super(image);
    }

    // copy picture region
    public void copy(Pic source, int targetX, int targetY)
    {
        int sourceWidth = source.getWidth();
        int sourceHeight = source.getHeight();
        
        for (int x = 0; x < sourceWidth; x++)
        {
            for (int y = 0; y < sourceHeight; y++)
            {
                int tx = targetX + x;
                int ty = targetY + y;
                
                boolean checkX = tx >= 0 && tx < this.getWidth();
                boolean checkY = ty >= 0 && ty < this.getHeight();
                
                if (checkX && checkY)
                {
                    Pixel src = source.getPixel(x, y);
                    Pixel dst = this.getPixel(tx, ty);
                    Color colorFromSrc = src.getColor();
                    dst.setColor(colorFromSrc);
                }
            }
        }
    }

    // mirror temple roof
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int startY = 27;
        int endY = 97;
        int startX = 13;

        for (int y = startY; y < endY; y++)
        {
            for (int x = startX; x < mirrorPoint; x++)
            {
                leftPixel = this.getPixel(x, y);
                int rightX = mirrorPoint + (mirrorPoint - x);
                rightPixel = this.getPixel(rightX, y);
                Color leftColor = leftPixel.getColor();
                rightPixel.setColor(leftColor);
            }
        }
    }

    // mirror vertically
    public void mirrorVertical()
    {
        int w = this.getWidth();
        int h = this.getHeight();
        int halfWidth = w / 2;
        
        for (int y = 0; y < h; y++)
        {
            for (int x = 0; x < halfWidth; x++)
            {
                Pixel left = this.getPixel(x, y);
                int rightX = w - 1 - x;
                Pixel right = this.getPixel(rightX, y);
                Color leftColor = left.getColor();
                right.setColor(leftColor);
            }
        }
    }

    // convert to grayscale
    public void grayscale()
    {
        Pixel[] pixels = this.getPixels();
        for (int i = 0; i < pixels.length; i++)
        {
            Pixel p = pixels[i];
            int red = p.getRed();
            int green = p.getGreen();
            int blue = p.getBlue();
            int sum = red + green + blue;
            int avg = sum / 3;
            Color grayColor = new Color(avg, avg, avg);
            p.setColor(grayColor);
        }
    }

    // recursively create a fractal inset effect (image goes infinitely into bottom‑right)
    public void recursiveInset()
    {
        int w = this.getWidth();
        int h = this.getHeight();

        // base case – stop when the picture is too small to divide
        if (w <= 1 || h <= 1)
        {
            return;
        }

        // make a half‑size copy by sampling every second pixel
        int newW = w / 2;
        int newH = h / 2;
        
        if (newW < 1)
        {
            newW = 1;
        }
        if (newH < 1)
        {
            newH = 1;
        }

        Pic small = new Pic(newW, newH);
        
        for (int y = 0; y < newH; y++)
        {
            for (int x = 0; x < newW; x++)
            {
                int srcX = x * 2;
                int srcY = y * 2;
                Pixel src = this.getPixel(srcX, srcY);
                Pixel dst = small.getPixel(x, y);
                Color srcColor = src.getColor();
                dst.setColor(srcColor);
            }
        }

        // apply the same effect recursively to the smaller copy
        small.recursiveInset();

        // paste the processed small picture into the bottom‑right corner of this one
        int startX = w - newW;
        int startY = h - newH;
        
        for (int y = 0; y < newH; y++)
        {
            for (int x = 0; x < newW; x++)
            {
                Pixel src = small.getPixel(x, y);
                int dstX = startX + x;
                int dstY = startY + y;
                Pixel dst = this.getPixel(dstX, dstY);
                Color srcColor = src.getColor();
                dst.setColor(srcColor);
            }
        }
    }

    // detect edges
    public void edgeDetection(double threshold)
    {
        int w = this.getWidth();
        int h = this.getHeight();
        Color[][] copy = new Color[w][h];

        for (int y = 0; y < h; y++)
        {
            for (int x = 0; x < w; x++)
            {
                Pixel currentPixel = this.getPixel(x, y);
                Color currentColor = currentPixel.getColor();
                copy[x][y] = currentColor;
            }
        }

        for (int y = 0; y < h - 1; y++)
        {
            for (int x = 0; x < w - 1; x++)
            {
                Color c1 = copy[x][y];
                Color c2 = copy[x + 1][y];
                Color c3 = copy[x][y + 1];

                double r1 = c1.getRed();
                double g1 = c1.getGreen();
                double b1 = c1.getBlue();
                double avg1 = (r1 + g1 + b1) / 3.0;
                
                double r2 = c2.getRed();
                double g2 = c2.getGreen();
                double b2 = c2.getBlue();
                double avg2 = (r2 + g2 + b2) / 3.0;
                
                double r3 = c3.getRed();
                double g3 = c3.getGreen();
                double b3 = c3.getBlue();
                double avg3 = (r3 + g3 + b3) / 3.0;

                double diff1 = Math.abs(avg1 - avg2);
                double diff2 = Math.abs(avg1 - avg3);
                
                if (diff1 > threshold || diff2 > threshold)
                {
                    this.getPixel(x, y).setColor(Color.WHITE);
                }
                else
                {
                    this.getPixel(x, y).setColor(Color.BLACK);
                }
            }
        }
    }

    // invert colors
    public void negate()
    {
        Pixel[] pixels = this.getPixels();
        
        for (int i = 0; i < pixels.length; i++)
        {
            Pixel p = pixels[i];
            int redValue = p.getRed();
            int greenValue = p.getGreen();
            int blueValue = p.getBlue();
            
            int r = 255 - redValue;
            int g = 255 - greenValue;
            int b = 255 - blueValue;
            
            Color invertedColor = new Color(r, g, b);
            p.setColor(invertedColor);
        }
    }

   
}