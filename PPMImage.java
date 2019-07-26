import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
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
*/



public class PPMImage {
	private String typeOfFile; 
	private int width;
	private int colour;
	private int height;
	private int maxShade;
	private short[][][] pixels;
	

public PPMImage(String filename) {
	try {
		Scanner s = new Scanner(new File(filename));
		typeOfFile = s.next();
		width = s.nextInt();
		height = s.nextInt();
		colour = 3;
		maxShade = s.nextInt();
		pixels = new short [height][width][colour];
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				for (int k=0; k<colour; k++) {
					pixels[i][j][k] = s.nextShort();

				}
			}
			
		}
		s.close();
	
	}
	catch (IOException e) {
		System.out.println("File No1t Found");
		typeOfFile = "P3";
		width = 0;
		height = 0;
		colour = 0;
		maxShade = 0;
		pixels = new short [height][width][colour];
	}
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;

}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}
public int getColour() {
	return colour;
}

public void setColour(int colour) {
	this.colour = colour;
}


public int getMaxShade() {
	return maxShade;
}

public void setMaxShade(int maxShade) {
	this.maxShade = maxShade;
}

public String getTypeOfFile() {
	return typeOfFile;
}

public void setTypeOfFile(String typeOfFile) {
	this.typeOfFile = typeOfFile;
}

public short[][][] getPixels() {
	return pixels;
}

public void setPixels(short[][][] pixels) {
	this.pixels = pixels;
}

public short[][] makeGrey(String filename){
	short [][]grey = new short[height] [width];
	try {
		BufferedWriter out =
				new BufferedWriter (new FileWriter(filename));
		out.write("P2" + "\n");
		out.write((getWidth())+ " " + (getHeight()) + "\n");
		out.write(getMaxShade() + "\n");
		
				for  (int i=0;i<getHeight();i++) {
					for (int j = 0; j<getWidth(); j++) {
						int sum = 0;
						for (int k=0; k<getColour(); k++) {
							sum += getPixels()[i][j][k];
						}
						short greyPixel = (short) (sum/3);
						grey[i][j] = greyPixel;
						out.write(String.valueOf(greyPixel)+ "\n");
						
					}
				}
				
	
		out.close();
	
	}
	catch (IOException e) {
		System.out.println("File Not Found");
	}
		
	return grey;

}

	public static void main (String [] args) {
		PPMImage greyim = new PPMImage("src/ComputerScienceSmall.ppm");
		greyim.makeGrey ("src/ComputerScienceSmall2.ppm");
	}
}


