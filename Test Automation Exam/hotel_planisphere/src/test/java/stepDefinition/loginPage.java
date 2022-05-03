package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class loginPage extends helpers {
    @Given("I am in Hotel Planisphere login page")
    public void i_am_in_hotel_planisphere_login_page() {
        goToLoginPage();

    }

    @When("I enter test@test.com in email field")
    public void i_enter_test_test_com_in_email_field() {
        enterTextToInputField(By.cssSelector("input[id='email']"), "name@name.com");
    }

    @When("I enter Password1234 in password field")
    public void i_enter_password1234_in_password_field() {
        enterTextToInputField(By.cssSelector("input[id='password']"), "Pasword1234");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        clickElement(By.cssSelector("button[id='login-button']"));
    }

    @Then("I am unable to login")
    public void i_am_unable_to_login() {
        //Check if still on the same page
        Assert.assertEquals(driver.getCurrentUrl(), "https://hotel.testplanisphere.dev/ja/login.html");
    }

    @Then("all the error messages are correct")
    public void the_error_message_is_correct() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getElementText(By.cssSelector("div[id='email-message']")), "メールアドレスまたはパスワードが違います。");
        softAssert.assertEquals(getElementText(By.cssSelector("div[id='password-message']")), "メールアドレスまたはパスワードが違います。");
        softAssert.assertAll();
    }

    @Then("the error message is correct for blank email input")
    public void the_error_message_is_correct_for_blank_email_input() {
        Assert.assertEquals(getElementText(By.cssSelector("div[id='email-message']")), "このフィールドを入力してください。");
    }

    @Then("the error message is correct for blank password input")
    public void the_error_message_is_correct_for_blank_password_input() {
        Assert.assertEquals(getElementText(By.cssSelector("div[id='password-message']")), "このフィールドを入力してください。");
    }

    @And("I get each of the element text displayed in the login page")
    public void I_get_each_of_the_element_text_displayed_in_the_login_page() {
        //Get login header
        loginElements.put("loginHeader", getElementText(By.cssSelector("h2")));

        //Get email label
        loginElements.put("emailLabel", getElementText(By.cssSelector("label[for='email']")));

        //Get password label
        loginElements.put("passwordLabel", getElementText(By.cssSelector("label[for='password']")));

        //Get login button text
        loginElements.put("loginButtonText", getElementText(By.cssSelector("button[id='login-button']")));
    }

    @Then("the login page elements are displayed correctly")
    public void the_login_page_elements_are_displayed_correctly() {
        SoftAssert softAssert = new SoftAssert();
        loginElements.forEach((key, value) -> {
            switch(key) {
                case "loginHeader" :
                    checkElementDisplay(By.cssSelector("h2"));
                    softAssert.assertEquals(value, "ログイン");
                    break;
                case "emailLabel" :
                    checkElementDisplay(By.cssSelector("label[for='email']"));
                    softAssert.assertEquals(value, "メールアドレス");
                    break;
                case "passwordLabel" :
                    checkElementDisplay(By.cssSelector("label[for='password']"));
                    softAssert.assertEquals(value, "パスワード");
                    break;
                case "loginButtonText" :
                    checkElementDisplay(By.cssSelector("button[id='login-button']"));
                    softAssert.assertEquals(value, "ログイン");
                    break;
            }
        });
        softAssert.assertAll();
    }

    @When("I get the header element text")
    public void I_get_the_header_element_text() {
        headerText = getElementText(By.cssSelector("h1"));
    }

    @Then("the header should be displayed correctly")
    public void the_header_should_be_displayed_correctly() {
        Assert.assertEquals(headerText, "Hotel Planisphere");
    }

    @When("I check each navbar element")
    public void i_check_each_navbar_element() {
        //Get home text
        loginElements.put("homeText", getElementText(By.xpath("//div[@id='navbarNav']/descendant::a[1]")));

        //Get plans text
        loginElements.put("plansText", getElementText(By.xpath("//div[@id='navbarNav']/descendant::a[2]")));

        //Get signup text
        loginElements.put("signupText", getElementText(By.xpath("//div[@id='navbarNav']/descendant::a[3]")));

        //Get login text
        loginElements.put("loginText", getElementText(By.xpath("//div[@id='navbarNav']/descendant::a[4]")));
    }

    @Then("the navbar elements should be displayed correctly")
    public void the_navbar_elements_should_be_displayed_correctly() {
        SoftAssert softAssert = new SoftAssert();
        loginElements.forEach((key, value) -> {
            switch(key) {
                case "loginHeader" :
                    softAssert.assertEquals(value, "ホーム");
                    break;
                case "emailLabel" :
                    softAssert.assertEquals(value, "宿泊予約");
                    break;
                case "passwordLabel" :
                    softAssert.assertEquals(value, "会員登録");
                    break;
                case "loginButtonText" :
                    softAssert.assertEquals(value, "ログイン");
                    break;
            }
        });
        softAssert.assertAll();
    }

    @When("I check the footer Github element text")
    public void i_check_the_footer_github_element_text() {
        footerLinkText = getElementText(By.xpath("//footer/descendant::a"));
    }

    @Then("the footer Github element text should be displayed correctly")
    public void the_footer_github_element_text_should_be_displayed_correctly() {
        Assert.assertEquals(footerLinkText, "GitHub");
    }

    @When("I check each copyright text")
    public void i_check_each_copyright_text() {
        footerCopyrightText = getElementText(By.xpath("//footer/descendant::p"));
    }

    @Then("the copyright text should be displayed correctly")
    public void the_copyright_text_should_be_displayed_correctly() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(footerCopyrightText, "© 2020 Test Planisphere");
    }

    @When("I click the footer link")
    public void i_click_the_footer_link() {
        clickElement(By.xpath("//footer/descendant::a"));
    }

    @Then("I should be redirected to the GitHub page")
    public void i_should_be_redirected_to_the_GitHub_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/testplanisphere/hotel-example-site");
    }

    @When("I click the Home link")
    public void i_click_the_home_link() {
        clickElement(By.xpath("//div[@id='navbarNav']/descendant::a[1]"));
    }

    @Then("I should be redirected to the Home page")
    public void i_should_be_redirected_to_the_home_page() {
        waitUntilElementIsVisible(By.cssSelector("h2"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://hotel.testplanisphere.dev/ja/index.html");
    }

    @When("I go back to the previous page")
    public void i_go_back_to_the_previous_page() {
        waitUntilElementIsVisible(By.cssSelector("h2"));
        driver.navigate().back();
    }

    @When("I click the Plans link")
    public void i_click_the_plans_link() {
        clickElement(By.xpath("//div[@id='navbarNav']/descendant::a[2]"));
    }

    @Then("I should be redirected to the Plans page")
    public void i_should_be_redirected_to_the_plans_page() {
        waitUntilElementIsVisible(By.cssSelector("h2"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://hotel.testplanisphere.dev/ja/plans.html");
    }

    @When("I click the Signup link")
    public void i_click_the_signup_link() {
        clickElement(By.xpath("//div[@id='navbarNav']/descendant::a[3]"));
    }

    @Then("I should be redirected to the Signup page")
    public void i_should_be_redirected_to_the_signup_page() {
        waitUntilElementIsVisible(By.cssSelector("h2"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://hotel.testplanisphere.dev/ja/signup.html");
    }

    @When("I click the Login button")
    public void i_click_the_login_button() {
        clickElement(By.xpath("//div[@id='navbarNav']/descendant::a[4]"));
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        waitUntilElementIsVisible(By.cssSelector("h2"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://hotel.testplanisphere.dev/ja/login.html");
    }

    @And("the browser should close")
    public void the_browser_should_close() {
        driver.quit();
    }
}
