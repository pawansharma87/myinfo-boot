/*package net.org.myinfo.util;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import net.org.myinfo.model.user.User;
 
 
public class SimpleConvertImage {
	@RequestMapping(value = "/athenticate", method = RequestMethod.GET)
	public String userLogin(@Valid User user, BindingResult bindingResult, Model model) {
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username;
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}

		} catch (Exception e) {
			LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
			bindingResult.reject("email.exists", "Email already exists");
			return "login";
		}
		return "redirect:/user/userProfile/new";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		UserDetails userDetails = userDetailsService.loadUserByUsername("admin");
		System.out.println(userDetails.getUsername());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Example");
		model.addObject("message", "Logged In as  " + name + "!");
		model.setViewName("admin");
		return model;
	}

	@RequestMapping(value = "/super**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Example");
		model.addObject("message", "Logged In as  " + name + "!");
		model.setViewName("admin");
		return model;
	}

	
	public static void main(String[] args) throws IOException{
		String dirName="C:\\";
		ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
		BufferedImage img=ImageIO.read(new File("../../../../../resources/static/images/default_img.jpg"));
		ImageIO.write(img, "jpg", baos);
		baos.flush();
 
		String base64String=Base64.encode(baos.toByteArray());
		baos.close();
 
		byte[] bytearray = Base64.decode(base64String);
 
		BufferedImage imag=ImageIO.read(new ByteArrayInputStream(bytearray));
		ImageIO.write(imag, "jpg", new File(dirName,"snap.jpg"));
	}
}*/