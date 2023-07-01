package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MyForkSignUpPage extends BaseMain{
    public MyForkSignUpPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements
    private WebElement jobTitleDropdownElement;

    //Dropdown
    private Select jobTitleDropdown;

    //List of dropdown options
    private List<WebElement> dropdownOptions;

    //List of expected roles from requirements
    private List<String> jobTitles = new ArrayList<>();

    //List of roles that are not implemented
    private List<String> notImplementedRoles = new ArrayList<>();

    //List of roles that implemented and are not matched with requirements
    private List<String> notValidJobTitles = new ArrayList<>();

    //Assign dropdown element and get the list of dropdown options
    private void setDropdownValues() {
        jobTitleDropdownElement = driver.findElement(By.id("job-title"));
        jobTitleDropdown = new Select(jobTitleDropdownElement);
        dropdownOptions = jobTitleDropdown.getOptions();
    }

    //Get and print all dropdown options (HOMEWORK)
    public void getJobTitleDropdownValues() {
        setDropdownValues();
        for (WebElement dropdownOption: dropdownOptions) {
            System.out.println("Role name: " + dropdownOption.getText());
        }
    }

    //Verify what has been implemented correctly (ADDITIONAL IMPLEMENTATION)
    public void validateCorrectnessOfImplementation() {
        setDropdownValues();
        setExpectedRoleValues();
        setNewListWithDropdownOptions();
        //Fill the additional list with requirements values
        notImplementedRoles.addAll(jobTitles);

        //Verify if there are values are not implemented from requirements
        for (WebElement dropdownOption: dropdownOptions) {
            for(int i = 0; i < notImplementedRoles.size(); i++){
                if(dropdownOption.getText().equals(notImplementedRoles.get(i))){
                    notImplementedRoles.remove(i);
                }
            }
        }

        //Verify if there are values are implemented and are not matched with the requirements
        for(String jobTitle: jobTitles) {
            for(int i = 0; i < notValidJobTitles.size(); i++){
                if(jobTitle.equals(notValidJobTitles.get(i))){
                    notValidJobTitles.remove(i);
                }
            }
        }

        //Print the results
        if(notImplementedRoles.size() == 0){
            System.out.println("Success! All dropdown options have been implemented correctly");
        }else {
            System.out.println("List of roles that are not implemented: " + notImplementedRoles);
        }


        if(notValidJobTitles.size() == 0){
            System.out.println("Success! There are no values that are not matched with requirements in the dropdown");
        }else{
            System.out.println("List of roles that implemented and are not matched with requirements: " + notValidJobTitles);
        }
    }

    //Fill the new list with requirements values
    private void setExpectedRoleValues() {
        jobTitles.add("Junior level Developer");
        jobTitles.add("Middle level Developer");
        jobTitles.add("Senior level Developer");
        jobTitles.add("Leading Developer");
        jobTitles.add("QA Analyst");
        jobTitles.add("Software Tester");
        jobTitles.add("QA Engineer");
        jobTitles.add("Senior QA Engineer");
        jobTitles.add("Automation QA Engineer");
        jobTitles.add("Test Lead");
        jobTitles.add("Automation Test Lead");
        jobTitles.add("Business Analyst");
        jobTitles.add("Senior Business Analyst");
        jobTitles.add("Designer");
    }

    //Fill the new list with implemented dropdown values
    private void setNewListWithDropdownOptions() {
        for (WebElement dropdownOption: dropdownOptions) {
            notValidJobTitles.add(dropdownOption.getText());
        }
    }
}