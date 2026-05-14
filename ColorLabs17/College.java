public class College
{
    public static void main(String[] args)
    {
        String basePath = "images/radience.JPG";
        Pic source = new Pic(basePath);

        int tileW = source.getWidth();
        int tileH = source.getHeight();

        Pic canvas = new Pic(tileW * 3, tileH * 2);

        // original image
        canvas.copy(source, 0, 0);

        // vertical mirror
        Pic mirrored = new Pic(basePath);
        mirrored.mirrorVertical();
        canvas.copy(mirrored, tileW, 0);

        // grayscale effect
        Pic gray = new Pic(basePath);
        gray.grayscale();
        canvas.copy(gray, 2 * tileW, 0);

        // fractal inset effect
        Pic fractal = new Pic(basePath);
        fractal.recursiveInset();
        canvas.copy(fractal, 0, tileH);

        // negative effect (inverse)
        Pic neg = new Pic(basePath);
        neg.negate();
        canvas.copy(neg, tileW, tileH);

        // edge detection
        Pic edge = new Pic(basePath);
        edge.edgeDetection(12.5);
        canvas.copy(edge, 2 * tileW, tileH);

        canvas.write("images/final_collage.jpg");
        canvas.explore();
    }
}