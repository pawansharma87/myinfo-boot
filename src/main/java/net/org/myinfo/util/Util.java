package net.org.myinfo.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Util {
	/*public static String userName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}*/
	
	public static String getImageEncoded(byte image[]) {
		byte[] encodeBase64 ;
		String base64Encoded=new String();
		try {			
			if(image!=null){
			encodeBase64 = Base64.encodeBase64(image);			
			}
			else{
				encodeBase64 = Base64.encodeBase64(getDefaultImage().toByteArray());				
			}
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return base64Encoded;
	}
	
	public static ByteArrayOutputStream getDefaultImage() {
		ByteArrayOutputStream baos = null;
		try {
			Resource rsrc = new ClassPathResource("static");
			baos = new ByteArrayOutputStream(1000);
			BufferedImage img = ImageIO.read(new File(
					rsrc.getFile().getPath() + File.separator + "images" + File.separator + "profile.jpg"));
			ImageIO.write(img, "jpg", baos);
			baos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baos;
	}		
		
}
