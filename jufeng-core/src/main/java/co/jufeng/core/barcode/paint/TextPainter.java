package co.jufeng.core.barcode.paint;

import java.awt.image.BufferedImage;

public interface TextPainter {
	
	public void paintText(BufferedImage barcode, String text, int barWidth);

}
