package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by User on 4/18/2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes format)
    {
        if (format == ImageTypes.BMP)
            return new BmpReader();
        if (format == ImageTypes.JPG)
            return new JpgReader();
        if (format == ImageTypes.PNG)
            return new PngReader();
        else
        {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }

}
