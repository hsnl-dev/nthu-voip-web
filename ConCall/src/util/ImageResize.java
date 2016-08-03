package util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImageResize {
	
	private static final int IMG_HEIGHT = 200;
	
	public static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type,
			int width, int height){
		
		//System.out.println(width + "*" + height);
		double ratio = (double)width/height;
		//System.out.println("ratio = " + ratio);
		int newWidth = (int) Math.round(ratio*IMG_HEIGHT);
		//System.out.println("new width = " + newWidth);
		
		BufferedImage resizedImage = new BufferedImage(newWidth , IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, IMG_HEIGHT, null);
		g.dispose();	
		g.setComposite(AlphaComposite.Src);
	 
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
		RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
	 
		return resizedImage;
	}
	
	public static BufferedImage rotate90ToRight(BufferedImage inputImage){
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();
		BufferedImage returnImage = new BufferedImage(height, width, inputImage.getType());

		for( int x = 0; x < width; x++ ){
			for( int y = 0; y < height; y++ ) {
				returnImage.setRGB(height - y - 1, x, inputImage.getRGB(x, y));
			}
		}
		return returnImage;
	}
	
	public static BufferedImage rotate180(BufferedImage inputImage){
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();
		BufferedImage returnImage = new BufferedImage(width, height, inputImage.getType());

		for( int x = 0; x < width; x++ ){
			for( int y = 0; y < height; y++ ) {
				returnImage.setRGB(width -x -1, height - y - 1, inputImage.getRGB(x, y));
			}
		}
		return returnImage;
	}
}
