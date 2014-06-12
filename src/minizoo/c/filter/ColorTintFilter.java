package minizoo.c.filter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorTintFilter extends AbstractFilter {
    private final Color tintColor;

    public ColorTintFilter(Color tintColor) {
        this.tintColor = tintColor;
    }

    public Color getTintColor() {
        return tintColor;
    }

    private void mixColor(int[] inPixels) {
        int mix_r = tintColor.getRed();
        int mix_b = tintColor.getBlue();
        int mix_g = tintColor.getGreen();

        for (int i = 0; i < inPixels.length; i++) {
            int argb = inPixels[i];

            int a = argb & 0xFF000000;
            int r = (argb >> 16) & 0xFF;
            int g = (argb >>  8) & 0xFF;
            int b = (argb      ) & 0xFF;

            r = (r*mix_r)/255;
            g = (g*mix_g)/255;
            b = (b*mix_b)/255;

            inPixels[i] = a | r << 16 | g << 8 | b;
        }
    }
    @Override
    public BufferedImage filter(BufferedImage src,
                                BufferedImage dst) {
        if (dst == null) {
            dst = createCompatibleDestImage(src, null);
        }

        int width = src.getWidth();
        int height = src.getHeight();

        int[] pixels = new int[width * height];
        GraphicsUtilities.getPixels(src, 0, 0, width,
                height, pixels);
        mixColor(pixels);
        GraphicsUtilities.setPixels(dst, 0, 0, width,
                height, pixels);
        return dst;
    }
}