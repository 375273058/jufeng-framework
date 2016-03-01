package co.jufeng.core.barcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import co.jufeng.core.barcode.encode.CodabarEncoder;
import co.jufeng.core.barcode.encode.Code128Encoder;
import co.jufeng.core.barcode.encode.Code39Encoder;
import co.jufeng.core.barcode.encode.Code93Encoder;
import co.jufeng.core.barcode.encode.EAN13Encoder;
import co.jufeng.core.barcode.encode.EAN8Encoder;
import co.jufeng.core.barcode.encode.Interleaved2of5Encoder;
import co.jufeng.core.barcode.encode.PostNetEncoder;
import co.jufeng.core.barcode.encode.Standard2of5Encoder;
import co.jufeng.core.barcode.encode.UPCAEncoder;
import co.jufeng.core.barcode.encode.UPCEEncoder;
import co.jufeng.core.barcode.paint.BaseLineTextPainter;
import co.jufeng.core.barcode.paint.EAN13TextPainter;
import co.jufeng.core.barcode.paint.EAN8TextPainter;
import co.jufeng.core.barcode.paint.HeightCodedPainter;
import co.jufeng.core.barcode.paint.UPCATextPainter;
import co.jufeng.core.barcode.paint.UPCETextPainter;
import co.jufeng.core.barcode.paint.WideRatioCodedPainter;
import co.jufeng.core.barcode.paint.WidthCodedPainter;
import co.jufeng.core.barcode.util.ImageUtil;


public class SimpleDemo extends TestCase{
	
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public SimpleDemo(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SimpleDemo.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testSimpleDemo() {
		assertTrue(true);
	}

    public void testBarcode(){
        try{
            //Creates a JBarcode with a EAN13Encoder and a WidthCodedPainter
            JBarcode jbcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());
            
            String code = "788515004012";
            BufferedImage img = jbcode.createBarcode(code);
            saveToGIF(img, "EAN13.gif");
            
            //EAN8 Code Example
            jbcode.setEncoder(EAN8Encoder.getInstance());
            jbcode.setTextPainter(EAN8TextPainter.getInstance());
            code = "9788515";        
            img = jbcode.createBarcode(code);
            saveToPNG(img, "EAN8.png");
            
            //UPCA Code Example
            jbcode.setEncoder(UPCAEncoder.getInstance());
            jbcode.setTextPainter(UPCATextPainter.getInstance());
            code = "07567816415";        
            img = jbcode.createBarcode(code);
            saveToPNG(img, "UPCA.png");
            
            //UPCE Code Example
            jbcode.setEncoder(UPCEEncoder.getInstance());
            jbcode.setTextPainter(UPCETextPainter.getInstance());
            code = UPCAEncoder.getInstance().convertUPCAtoUPCE("07567816415");        
            img = jbcode.createBarcode(code);
            saveToPNG(img, "UPCE.png");
            
            //Codabar Code Example
            jbcode.setEncoder(CodabarEncoder.getInstance());
            jbcode.setPainter(WideRatioCodedPainter.getInstance());
            jbcode.setTextPainter(BaseLineTextPainter.getInstance());
            code = "97885150040-85";
            jbcode.setWideRatio(3.0);
            img = jbcode.createBarcode(code);
            saveToJPEG(img, "Codabar.jpg");
            
            //Code39 Code Example
            jbcode.setEncoder(Code39Encoder.getInstance());
            jbcode.setPainter(WideRatioCodedPainter.getInstance());
            jbcode.setTextPainter(BaseLineTextPainter.getInstance());
            jbcode.setShowCheckDigit(false);
            code = "JBARCODE-39";
            img = jbcode.createBarcode(code);
            saveToPNG(img, "Code39.png");
            
            //Code93 Code Example
            jbcode.setEncoder(Code93Encoder.getInstance());
            jbcode.setPainter(WidthCodedPainter.getInstance());
            jbcode.setTextPainter(BaseLineTextPainter.getInstance());
            jbcode.setShowCheckDigit(false);
            code = "JBARCODE-93";
            img = jbcode.createBarcode(code);
            saveToPNG(img, "Code93.png");
            
            //Code128 Code Example
            jbcode.setEncoder(Code128Encoder.getInstance());
            jbcode.setPainter(WidthCodedPainter.getInstance());
            jbcode.setTextPainter(BaseLineTextPainter.getInstance());
            jbcode.setShowCheckDigit(false);
            code = "JBarcode-128";
            img = jbcode.createBarcode(code);
            saveToPNG(img, "Code128.png");
            
            //Standard 2 of 5 Code Example
            jbcode.setEncoder(Standard2of5Encoder.getInstance());
            jbcode.setPainter(WideRatioCodedPainter.getInstance());
            jbcode.setTextPainter(BaseLineTextPainter.getInstance());
            jbcode.setShowCheckDigit(true);
            code = "978851500404";
            img = jbcode.createBarcode(code);
            saveToJPEG(img, "Standard2of5.jpg");
            
            //Interleaved 2 of 5 Code Example
            jbcode.setEncoder(Interleaved2of5Encoder.getInstance());
            jbcode.setPainter(WideRatioCodedPainter.getInstance());
            jbcode.setTextPainter(BaseLineTextPainter.getInstance());
            jbcode.setShowCheckDigit(true);
            code = "978851500404";        
            img = jbcode.createBarcode(code);
            saveToPNG(img, "Interleaved2of5.png");
            
            //PostNet Code Example
            jbcode.setEncoder(PostNetEncoder.getInstance());
            jbcode.setPainter(HeightCodedPainter.getInstance());
            jbcode.setBarHeight(6);
            jbcode.setXDimension(0.5291666);
            jbcode.setShowText(false);
            code = "805365961"; 
            img = jbcode.createBarcode(code);
            saveToJPEG(img, "PostNet.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    static void saveToJPEG(BufferedImage img, String fileName){
        saveToFile(img, fileName, ImageUtil.JPEG);
    }
    
    static void saveToPNG(BufferedImage img, String fileName){
       saveToFile(img, fileName, ImageUtil.PNG);
    }
    
    static void saveToGIF(BufferedImage img, String fileName){
        saveToFile(img, fileName, ImageUtil.GIF);
    }     
    
    static void saveToFile(BufferedImage img, String fileName, String format){
    	try{
    		String path = System.getProperty("user.dir") + File.separator + "images" + File.separator;
    		new File(path).mkdirs();
    		FileOutputStream fos = new FileOutputStream(path + fileName);
            ImageUtil.encodeAndWrite(img, format, fos, 96, 96);
            fos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
