package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {

	private IUserService userService;

	// Spring Setter Injection
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("list", userService.listAllUsers());
		return model;
	}

	@RequestMapping(value = "/recordDateCheck", method = RequestMethod.POST)
	public ModelAndView userRegister(@ModelAttribute("user") Trading_Calendar user) throws ParseException {
		ModelAndView model = new ModelAndView("edit");
		String message = "";
		String recordDate = "";
		recordDate = user.getRecordDate();

		if (user != null) {
			String payDateMessage = "";
			payDateMessage = paymentDateCheck(user.getRecordDate(), user.getPaymentDate());
			recordDate = user.getRecordDate();

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = formatter.parse(recordDate);


			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);


			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {

				message = "Record date must be a Business Date";
				user.setPaymentDate("N");

			} else if (recordDate.equals("25/12/2018") || recordDate.equals("26/12/2018")
					|| recordDate.equals("01/01/2019"))

			{

				message = "Record date must be a Business Date";
				user.setPaymentDate("N");
			} else {

				message = "Valid Trading Date";

				user.setPaymentDate("Y");
				userService.saveUser(user);

			}
			model.addObject("user", user);
			model.addObject("checkMessage", message);

			model.addObject("payDateMessage", payDateMessage);
			model.addObject("warning", "User Registration Success");
			model.addObject("checkMessage", message);

		}

		return model;
	}

	@RequestMapping(value = "/{id}/recordDateCheck", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") long id) throws ParseException {

		String recordDate = "";
		String message = "";
		ModelAndView model = new ModelAndView("edit");
		Trading_Calendar user = userService.getUserById(id);
		recordDate = user.getRecordDate();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = formatter.parse(recordDate);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);

		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {

			message = "Record date must be a Business Date";
			user.setPaymentDate("N");

		} else if (recordDate.equals("25/12/2018") || recordDate.equals("26/12/2018")
				|| recordDate.equals("01/01/2019"))

		{

			message = "Record date must be a Business Date";
			user.setPaymentDate("N");
		} else {

			message = "Valid Trading Date";

			user.setPaymentDate("Y");

		}
		model.addObject("user", user);
		model.addObject("checkMessage", message);
		return model;
	}

	public String paymentDateCheck(String recordDate, String paymentDate) throws ParseException {

		String message = "";

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date record_Date = formatter.parse(recordDate);
		Date payment_Date = formatter.parse(paymentDate);
		if ((payment_Date.getTime() - record_Date.getTime()) / 86400000 > 1) {
			message = "Valid Payment Date";
		} else {
			message = "Payment date must be at least one day after the Record Date";
		}

		return message;
	}

}
