package co.jufeng.core.barcode.paint;

import java.awt.image.BufferedImage;

import co.jufeng.core.barcode.encode.BarSet;

public interface BarcodePainter {	
    
	public BufferedImage paint(BarSet [] barcode, int barWidth, int barHeight, double wideRatio);
	
}
