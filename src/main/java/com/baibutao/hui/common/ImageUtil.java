/**
 * 
 */
package com.baibutao.hui.common;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author niepeng
 * 
 * @date 2012-10-16 上午11:25:34
 */
public class ImageUtil {
	
	protected final static Logger log = LoggerFactory.getLogger(ImageUtil.class);

	public static final String JPG = ".jpg";

	// max为限定图片的宽度，如果大于这个数字 就会被缩放，以宽度为基准。
	public static void zoomPicture(File inputFile, String outputPicName, double max) {
		double maxLimit = max;
		double ratio = 1.0;
		try {
			BufferedImage Bi = ImageIO.read(inputFile);
			if ((Bi.getWidth() > maxLimit)) {
				ratio = maxLimit / Bi.getWidth();
			}
			int widthdist = (int) Math.floor(Bi.getWidth() * ratio), heightdist = (int) Math.floor(Bi.getHeight() * ratio);
			BufferedImage tag = new BufferedImage(widthdist, heightdist, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(Bi.getScaledInstance(widthdist, heightdist, BufferedImage.SCALE_SMOOTH), 0, 0, null);
			File littleFile = new File(outputPicName);
			ImageIO.write(tag, "JPEG", littleFile);
		} catch (Exception ex) {
			log.error("zoomPicture error", ex);
		}
	}

}
