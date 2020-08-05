package com.hrms.steps;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.*;

public class IsciEkle extends CommonMethods{
	
	@Given("login to the application")
	public void login_to_the_application() {
	   login.adminLogin();
	}


	@When("user click on add employee")
	public void user_click_on_add_employee() {
	    dashboard.navigateToAddEmployee();
	}

	@When("user enters {string} and user enters {string}")
	public void user_enters_and_user_enters(String string, String string2) {
	    sendText(addEmp.firstName, "Niran");
	    sendText(addEmp.lastName, "Unsal");
	}

	@Then("user clicks on save button")
	public void user_clicks_on_save_button() {
	   jsClick(addEmp.saveBtn);
	}

}
