# PPMImage-To-Gray

---------------------------------------------------------
Coloured pictures are represented in PPM (Portable PixMap) format of type P3. The PPM file contains for each pixel 3 values,
the RGB values (each between 0 and 255, inclusively) for the colours red, green, and blue
separately. The corresponding image can then be represented by a three-dimensional array
of type short[][][] image = new short[height][width][colour], in which the
three values for the three colours are stored in indices 0, 1, and 2 in the third dimension
corresponding to the three colours red, green, and blue, respectively.
The method public short[][] makeGrey(String filename) returns an array of type short[][]
of suitable size containing the corresponding grey values so that each grey value is the
rounded average of the corresponding three colour values. If the filename is not the
empty string the method should also save the image in the corresponding file as a PGM
image.
-----------------------------------------------------------
