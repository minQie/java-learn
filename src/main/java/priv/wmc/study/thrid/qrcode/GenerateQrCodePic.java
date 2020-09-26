package priv.wmc.study.thrid.qrcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 需要引入：com.google.zxing.core-2.2.jar
 * 
 * 生成指定信息或Url的二维码图片（可以添加中心图片、下方的文字）
 * ps：java画图的坐标可以理解为从一个点出发，从左至右为X轴，由上至下为Y轴
 * 
 * @author Wang Mincong
 * @date 2019-06-21 14:36
 */
public class GenerateQrCodePic {
    
    public static void main(String[] args) {
        File qrCode = new File("d:/1.png");
        String qrContent = "我是吴第广!";
        File qrCenterPic = new File("d:/wdg.png");
        String qrWord = "123123123123123123";
        try {
            new GenerateQrCodePic().generateQRCode(qrCode, qrContent, qrCenterPic, qrWord);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 全局最终生成的图片文件
     */
    private BufferedImage image;
    
    /**
	 * 全局最终生成图片的宽高（其中二维码部分是正方形，只需要一个边长：width）
	 */
    private Integer width = 400;
    private Integer height = 400;
    private Integer heightPlus = 45;
    
    /**
     * 画二维码
     * @param qrCode 指定生成的二维码图片的存储路径
     * @param qrContent 二维码包含的数据（普通文本直接显示，Url则访问）
     * @throws WriterException
     * @throws IOException
     */
    public void generateQRCode(File qrCode, String qrContent) throws WriterException, IOException {
    	this.generateQRCode(qrCode, qrContent, null, null);
    }
    
    /**
     * 画二维码、二维码中间的自定义图片
     * @param qrCode 指定生成的二维码图片的存储路径
     * @param qrContent 二维码包含的数据（普通文本直接显示，Url则访问）
     * @param qrCenterPic 二维码中间的图片
     * @throws WriterException
     * @throws IOException
     */
	public void generateQRCode(File qrCode, String qrContent, File qrCenterPic) throws WriterException, IOException {
		this.generateQRCode(qrCode, qrContent, qrCenterPic, null);
    }
	
	/**
	 * 画二维码、二维码下面的文字
	 * @param qrCode 指定生成的二维码图片的存储路径
	 * @param qrContent 二维码包含的数据（普通文本直接显示，Url则访问）
	 * @param qrWord 二维码下方的文字
	 * @throws WriterException
	 * @throws IOException
	 */
	public void generateQRCode(File qrCode, String qrContent, String qrWord) throws WriterException, IOException {
		this.generateQRCode(qrCode, qrContent, null, qrWord);
    }
	
    /**
     * 画二维码、二维码中间的自定义图片、二维码下面的文字
     * 
     * @param qrCode 指定生成的二维码图片的存储路径
     * @param qrContent 二维码包含的数据（普通文本直接显示，Url则访问）
     * @param qrCenterPic 二维码中间的图片
     * @param qrWord 二维码下方的文字
     * @throws WriterException 
     * @throws IOException
     */
	public void generateQRCode(File qrCode, String qrContent, File qrCenterPic, String qrWord) throws WriterException, IOException {
        // 如果要绘制二维码下方的文字，需要修改画板的大小
    	if (qrWord != null) {
    		height = height + heightPlus;
    	}
    	
    	// 创建图片画板
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        // 1、根据要存储的数据内容绘制二维码图片
        this.drawCode(qrContent);
        
        // 2、在二维码中间绘制长宽为二维码图片四分之一的自定义图片
        if (Objects.nonNull(qrCenterPic) && qrCenterPic.exists()) {
        	this.drawCenterPic(qrCenterPic);
        }

        // 3、在二维码下方绘制文字
        if (qrWord != null) {
        	this.drawWord(qrWord);
        }
        
        // 将内存中的图片写到硬盘中
        image.flush();
        ImageIO.write(image, "png", qrCode);
    }
	
	
	
	/**
	 * 绘制核心的二维码
	 * @param image
	 * @param bm
	 * @throws WriterException 
	 */
	private void drawCode(String qrContent) throws WriterException {
	   	 Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
	   	 /**
	   	  * 开题：一维条形码通常具有校验功能以防止错读，一旦条形码发生污损将被拒读。而二维条形码不仅能防止错误，而且能纠正错误，即使条形码部分损坏，也能将正确的信息还原出来
	   	  * 将一个张logo图片放置在二维码的中间，可以将logo图片理解为二维码上的污渍，二维码中的有效像素点越多容错率就越高
	   	  * 
	   	  * 设置QR二维码的纠错级别（H为最高级别，从源码注释可以看到最高级别H的容错率大约在30%）
	   	  */
	   	hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
	   	// 设置编码方式
	   	hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
	   	
	   	// 参数说明：生成图片中包含的数据，生成图片的类型，图片的宽度，图片的高度，其他参数
	   	BitMatrix bm = new MultiFormatWriter().encode(qrContent, BarcodeFormat.QR_CODE, width, width, hints);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < width; y++) {
            	Color color = bm.get(x, y)? Color.BLACK: Color.WHITE;
            	image.setRGB(x, y, this.colorToRGB(color));
            }
            // 底部画白（不做的话，底部就是黑的）
            for (int y = width; y < height; y++) {
            	image.setRGB(x, y, this.colorToRGB(Color.WHITE));
            }
        }
    }
	
	/**
	 * 绘制二维码中的自定义图片
	 * @param image
	 * @param qrCenterPic
	 * @throws IOException
	 */
    private void drawCenterPic(File qrCenterPic) throws IOException {
        Graphics2D pen = image.createGraphics();
        BufferedImage centerPic = ImageIO.read(qrCenterPic);
        pen.drawImage(centerPic, width * 2 / 5, width * 2 / 5, width * 2 / 10, width * 2 / 10, null);
        pen.dispose();
        centerPic.flush();
    }
    
    /**
     * 绘制二维码区域下方的文字
     * @param image
     * @param qrWord
     */
    private void drawWord(String qrWord) {
        Graphics2D pen = image.createGraphics();
        pen.setColor(Color.BLACK);
        pen.setFont(new Font("楷体", Font.BOLD, 30));
        // 文字实际绘制出来的长度
        int wordWidth = pen.getFontMetrics().stringWidth(qrWord);
        pen.drawString(qrWord, width / 2 - wordWidth / 2, height - heightPlus / 2 + 12);
        // 文字的长度不能大于画板的宽度处理
        // while (WordWidth > width - 1) {}
        pen.dispose();
    }
	
	/**
	 * Color parse to RGB Integer
	 * @param color Color.BLACK...
	 * @return 16进制RGB的颜色
	 * */
	private Integer colorToRGB(Color color) {
		String r, g, b;
		StringBuilder su = new StringBuilder();
		r = Integer.toHexString(color.getRed());
		g = Integer.toHexString(color.getGreen());
		b = Integer.toHexString(color.getBlue());
		r = r.length() == 1? ("0" + r): r;
		g = g.length() ==1? ("0" + g): g;
		b = b.length() == 1? ("0" + b): b;
		r = r.toUpperCase();
		g = g.toUpperCase();
		b = b.toUpperCase();
		su.append("FF");
		su.append(r);
		su.append(g);
		su.append(b);
		return Integer.parseUnsignedInt(su.toString(), 16);
	}
}
