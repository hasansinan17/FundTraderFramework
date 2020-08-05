package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.*;



public class Tarlaci extends CommonMethods {

	@Given("I logged in HRMS application")
	public void i_logged_in_HRMS_application() {
	   login.adminLogin();
	}

	@Given("I navigated to Employee List page")
	public void i_navigated_to_Employee_List_page() {
	    jsClick(dashboard.PIM);
	}

	@And("I navigated to Personal Details page")
	public void i_navigated_to_Personal_Details_page() {
	   jsClick(dashboard.empListPage);
	}

	@When("I click on edit button")
	public void i_click_on_edit_button() {
	    jsClick(viewEmp.saveButton);
	}

	@When("I click on Smoker")
	public void i_click_on_Smoker() {
	   jsClick(viewEmp.smoker);
	}

	@When("I modify other employee details")
	public void i_modify_other_employee_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> ModifyEmp = dataTable.asMaps();
		for (Map<String, String> map : ModifyEmp) {
			String licExpDate = map.get("licExpDate");
			String SSN = map.get("SSN");
			String SIN = map.get("SIN");
			String Gender = map.get("Gender");
			String Marital = map.get("Marital");
			String Nationality = map.get("Nationality");
			String DOB = map.get("DOB");
			String NickName = map.get("NickName");
			String Military = map.get("Military");
			sendText(viewEmp.LicenceExp, licExpDate);
			sendText(viewEmp.ssn, SSN);
			sendText(viewEmp.SIN, SIN);
			sendText(viewEmp.radioGender, Gender);
			sendText(viewEmp.maritialStatusDD, Marital);
			sendText(viewEmp.nationalityDD, Nationality);
			sendText(viewEmp.dobDD, DOB);
			sendText(viewEmp.nickName, NickName);
			sendText(viewEmp.militaryStatus, Military);
		}
	}

	@When("I click on save button")
	public void i_click_on_save_button() {
	    jsClick(viewEmp.saveButton);
	}

	@Then("I validate that employee details has been modified")
	public void i_validate_that_employee_details_has_been_modified() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}




}


