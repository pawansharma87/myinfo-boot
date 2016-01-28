package net.org.myinfo.api;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.org.myinfo.model.Classified;

public interface ClassifiedApi {
	@RequestMapping(value = "**/classifieds", method = RequestMethod.GET)
	String getAllClassified(Model model);

	@RequestMapping("**/classifiedByType/{type}")
	String getAllClassifiedByType(@PathVariable String type, Model model);

	@RequestMapping("/user/myclassifieds")
	String getAllClassifiedByUserId(Model model);

//	@RequestMapping("/user/organization/{id}")
	String getClassifiedById(@PathVariable Long id, Model model);

	@RequestMapping(value = "/**/classifiedview", method = RequestMethod.GET)
	String getClassifiedView(Model model);
	
	@RequestMapping("/user/classifieds/{id}")
	String getClassifiedDetail(@PathVariable Long id, Model model);

	@RequestMapping(value = "/user/addclassifieds", method = RequestMethod.POST)
	String save(@Valid Classified Classified, BindingResult bindingResult, Model model);

	@RequestMapping("/user/classifieds/edit/{id}")
	String update(@PathVariable Long id, Model model);

	@RequestMapping("/user/classifieds/delete/{id}")
	String delete(@PathVariable Long id);

}
