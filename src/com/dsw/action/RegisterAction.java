package com.dsw.action;

import java.io.Serializable;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dsw.form.RegisterForm;
import com.dsw.service.UserService;
import com.dsw.util.ImageUtil;
import com.dsw.util.RegexValidation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("request")
@Controller("registerAction")
public class RegisterAction extends ActionSupport implements Serializable{
	private static final long serialVersionUID = 11111L;
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	private RegisterForm registerForm;
	
	public RegisterForm getRegisterForm() {
		return registerForm;
	}
	public void setRegisterForm(RegisterForm registerForm) {
		this.registerForm = registerForm;
	}
	@Override
	public String execute(){
		if(RegexValidation.checkEmail(registerForm.getEmail()) && RegexValidation.checkPassword(registerForm.getPassword(), registerForm.getConformPassword())){
			String photoPath = ImageUtil.upload(registerForm.getFile(), registerForm.getFileFileName(), registerForm.getEmail().replace('.', '_'), "/photo");
			registerForm.setNewFile(photoPath);
			userService.addUser(registerForm.mappeToUser());
			ActionContext.getContext().getSession().put("username",registerForm.getEmail());
			String contextPath = ServletActionContext.getServletContext().getRealPath("/photo");
			ActionContext.getContext().getSession().put("photo",contextPath+"\\"+photoPath);
		}else{
			ActionContext.getContext().getSession().put("errorMessage","�����ʽ��������벻һ�£�");
			return ERROR;
		}
		return SUCCESS;
	}
}