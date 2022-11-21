package com.cognizant.ptracker.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class InvalidClerkException {

	@ExceptionHandler(ClerkException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleResourceNotFound(final ClerkException exception, final HttpServletRequest request,
			final Model model) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("clerkLogin");
		mv.addObject("errorMessage", "Invalid Username or Password");
		return mv;
	}
}
