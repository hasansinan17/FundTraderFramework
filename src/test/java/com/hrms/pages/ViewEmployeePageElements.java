package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewEmployeePageElements {

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empName;

	@FindBy(id = "empsearch_id")
	public WebElement empID;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	@FindBy(xpath = "//tr[1]//td[3]")
	public WebElement searchEmp;
	
	@FindBy (xpath="//input[@id='personal_txtLicExpDate']")
	public WebElement LicenceExp;

	@FindBy (xpath="//input[@id='personal_txtNICNo']")
	public WebElement ssn;
	
	@FindBy (xpath="//input[@id='personal_txtSINNo']")
	public WebElement SIN;
	
	@FindBy(xpath = "//input[@id='personal_optGender_1']")
	public WebElement radioGender;

	@FindBy(xpath = "//select[@id='personal_cmbMarital']")
	public WebElement maritialStatusDD;

	@FindBy(xpath = "//select[@id='personal_cmbNation']")
	public WebElement nationalityDD;

	@FindBy(xpath = "//input[@id='personal_DOB']")
	public WebElement dobDD;

	@FindBy(xpath = "//input[@id='personal_txtEmpNickName']")
	public WebElement nickName;

	@FindBy(xpath = "//input[@id='personal_chkSmokeFlag']")
	public WebElement smoker;

	@FindBy(id = "personal_txtMilitarySer")
	public WebElement militaryStatus;

	@FindBy(id = "btnSave")
	public WebElement saveButton;
	@FindBy(xpath="//table[@id='resultTable']")
    public WebElement employeesTable;
    
    @FindBy(xpath="//table[@id='resultTable']//tbody/tr/td[3]")
    public List<WebElement> tableFirstName;
    
    /**
     * this method will check if employees table is displayed
     * @return
     */
    public boolean isTableDisplayed() {
        return employeesTable.isDisplayed();
    }
    
    public List<Map<String, String>> getFirstNameFromTable(){
        List<Map<String, String>> uiName = new ArrayList<>();
        for(WebElement row :tableFirstName) {
            Map<String, String> storeUINames = new LinkedHashMap<>();
            String tableName=row.getText();
            storeUINames.put("emp_firstname", tableName);
            uiName.add(storeUINames);
        }
        return uiName;
        
    }
    
   


	public ViewEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}