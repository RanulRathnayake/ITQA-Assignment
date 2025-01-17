package starter.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import starter.actions.CheckoutYourInformationActions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

public class CheckoutYourInformationStepDefinitions {

    @Steps
    CheckoutYourInformationActions checkoutActions;

    @Given("the user is on the Sauce Demo login page - checkout")
    public void theUserIsOnLoginPage() {
        checkoutActions.openLoginPage();
        waitFor(2);
    }

    @When("the user enters {string} as username and {string} as password - checkout")
    public void theUserEntersCredentials(String username, String password) {
        checkoutActions.enterLoginCredentials(username, password);
        waitFor(2);
    }

    @And("the user clicks the login button - checkout")
    public void theUserClicksLoginButton() {
        checkoutActions.clickLoginButton();
        waitFor(2);
    }

    @Then("the user should be successfully logged in - checkout")
    public void theUserShouldBeLoggedIn() {
        assertThat(checkoutActions.isLoggedIn())
                .as("Verify the user is logged in")
                .isTrue();
        waitFor(2);
    }

    @Given("the user navigates to the checkout page")
    public void theUserNavigatesToCheckoutPage() {
        checkoutActions.openCheckoutPage();
        waitFor(2);
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        checkoutActions.openCheckoutPage();
        waitFor(2);
    }

    @When("the user enters valid {string}, {string}, and {string}")
    public void theUserEntersValidDetails(String firstName, String lastName, String postalCode) {
        checkoutActions.enterUserDetails(firstName, lastName, postalCode);
        waitFor(2);
    }

    @Then("the user should successfully proceed to the next step")
    public void theUserShouldSuccessfullyProceedToNextStep() {
        assertThat(checkoutActions.isNextPageLoaded())
                .as("Verify the user proceeded to the next step")
                .isTrue();
        waitFor(2);
    }

    @When("the user leaves the {string} field empty and enters {string} and {string}")
    public void userLeavesFirstNameEmpty(String firstName, String lastName, String postalCode) {
        checkoutActions.enterUserDetails("", lastName, postalCode);
        waitFor(2);
    }

    @And("the user clicks the continue button")
    public void userClicksContinueButton() {
        checkoutActions.clickContinueButton();
        waitFor(2);
    }

    @Then("an error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String expectedMessage) {
        assertThat(checkoutActions.getErrorMessage())
                .as("Verify the error message is displayed")
                .isEqualTo(expectedMessage);
        waitFor(2);
    }

    @Then("the Last Name field should be editable")
    public void theLastNameFieldShouldBeEditable() {
        String lastName = "Doe";
        boolean isEditable = checkoutActions.isLastNameFieldEditable();
        assertThat(isEditable)
                .as("The Last Name field should be editable")
                .isTrue();
    }


    @Then("the Last Name field should accept the value {string}")
    public void theLastNameFieldShouldAcceptTheValue(String expectedLastName) {
        String enteredLastName = checkoutActions.getLastNameValue();
        assertThat(enteredLastName)
                .as("The Last Name field should accept the entered value")
                .isEqualTo(expectedLastName);
    }

    @When("the user enters {string} in the Last Name field")
    public void theUserEntersInTheLastNameField(String lastName) {
        checkoutActions.enterLastName(lastName);
        waitFor(2);
    }
    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
