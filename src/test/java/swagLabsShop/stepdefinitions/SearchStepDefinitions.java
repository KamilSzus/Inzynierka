package swagLabsShop.stepdefinitions;

import helpers.CsvDataReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Browser;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.AssertionsForClassTypes;
import swagLabsShop.authentication.LoginAction;
import swagLabsShop.authentication.LoginPageObject;
import swagLabsShop.authentication.User;
import swagLabsShop.cart.CartItem;
import swagLabsShop.inventory.InventoryAction;
import swagLabsShop.inventory.ProductList;
import swagLabsShop.inventory.ViewProductDetailsAction;
import swagLabsShop.menuBar.MenuAction;
import swagLabsShop.navigation.NavigateTo;
import swagLabsShop.product.ProductAction;
import swagLabsShop.sorting.SortAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {
    @Steps
    NavigateTo navigateTo;
    @Steps
    LoginAction loginAction;
    @Steps
    InventoryAction inventoryAction;
    @Steps
    LoginPageObject loginPageObject;
    @Steps
    MenuAction menuAction;
    @Steps
    SortAction sortAction;
    @Steps
    ProductList productList;
    @Steps
    ViewProductDetailsAction viewProductDetails;
    @Steps
    ProductAction productAction;

    CsvDataReader csvDataReader;


    @Before
    public void setUp() {
        csvDataReader = new CsvDataReader();
    }

    @Given("User open the shop page")
    public void i_am_on_the_shop_page() {
        navigateTo.theSourceHomePage();
    }

    @When("User insert correct credential and try login")
    public void i_am_sucesfully_login_to_the_page_shop() {
        loginAction.loginAS(User.STANDARD_USER);
    }

    @When("User insert incorrect {string} and try login")
    public void i_am_see_error_message_on_login_page(String data) {
        User user;

        switch (data) {
            case "username" -> user = User.INCORRECT_USERNAME_USER;
            case "password" -> user = User.INCORRECT_PASSWORD_USER;
            default -> user = User.INCORRECT_USER;
        }

        loginAction.loginAS(user);
    }

    @Then("User should see main page")
    public void i_am_sucesfully() {
        Serenity.reportThat("Check if heading is equal to \"Products\" ", () ->
                AssertionsForClassTypes.assertThat(inventoryAction.getHeading()).isEqualToIgnoringCase("Products"));
    }

    @Then("User see error message on login page that contains this message {string}")
    public void i_am_see_error(String errorMessage) {
        Serenity.reportThat("Check if error message is equal to \"" + errorMessage + "\" ", () ->
                AssertionsForClassTypes.assertThat(loginPageObject.getErrorMessageText()).isEqualToIgnoringCase(errorMessage));
    }

    @When("Clicks login button")
    public void clicksLoginButton() {
        loginAction.clickLoginButton();
    }

    @When("User insert {string}")
    public void userInsert(String action) {
        if (action.equals("password")) {
            loginAction.insertPassword(User.STANDARD_USER);
        } else if (action.equals("username")) {
            loginAction.insertUsername(User.STANDARD_USER);
        }
    }

    @When("User insert incorrect credential")
    public void userInsertIncorrectCredential() {
        loginAction.loginAS(User.INCORRECT_USER);
    }

    @When("Get error message")
    public void getErrorMessage() {
        assertThat(LoginPageObject.getErrorMessage()).isNotNull();
    }

    @When("Try close this message")
    public void tryCloseThisMessage() {
        loginAction.closeErrorMessage();
    }

    @Then("Error message should disappear")
    public void errorMessageShouldDisappear() {
        assertThat(loginAction.isErrorMessageDisplayed()).isFalse();
    }

    @Given("User is login on the main page")
    public void userIsLoginOnTheMainPage() {
        navigateTo.theSourceHomePage();
        loginAction.loginAS(User.STANDARD_USER);
        Serenity.reportThat("Check if heading is equal to \"Products\" ", () ->
                AssertionsForClassTypes.assertThat(inventoryAction.getHeading()).isEqualToIgnoringCase("Products"));
    }

    @Given("Click on hamburger menu")
    public void clickOnHamburgerMenu() {
        menuAction.openMenu();
    }

    @Then("Click on {string} button in menu")
    public void clickOnLogout(String buttonName) {
        menuAction.clickOn(buttonName);
    }

    @When("Refresh browser")
    public void refreshBrowser() {
        Browser.refreshPage();
    }

    @Given("Click on dropdown list")
    public void clickOnDropdownList() {
        sortAction.clickOnDropdown();
    }

    @When("Select {string}")
    public void select(String sortingType) {
        sortAction.selectSortingBy(sortingType);
    }

    @Then("All products should be sorted reverse alphabetical order")
    public void allProductShouldBeSortedReverseAlphabeticalOrder() {
        var currentProductList = productList.getListOfProductsNameOnPage();
        List<String> sortedWords = new ArrayList<>(currentProductList);
        sortedWords.sort(Collections.reverseOrder());
        boolean isSorted = currentProductList.equals(sortedWords);

        Serenity.reportThat("Check if product list is sorted in correctly order after change", () ->
                assertThat(isSorted).isTrue());
    }

    @Then("All products should be sorted alphabetical")
    public void allProductsShouldBeSortedAlphabetical() {
        var currentProductList = productList.getListOfProductsNameOnPage();
        List<String> sortedWords = new ArrayList<>(currentProductList);
        Collections.sort(sortedWords);
        boolean isSorted = currentProductList.equals(sortedWords);

        Serenity.reportThat("Check if product list is sorted in correctly order after change", () ->
                assertThat(isSorted).isTrue());
    }

    @Then("All products should be sorted by lowest price")
    public void allProductsShouldBeSortedByLowestPrice() {
        var currentProductList = productList.getListOfAllProductsObject();
        List<CartItem> sortedItem = new ArrayList<>(currentProductList);
        Collections.sort(sortedItem);
        boolean isSorted = currentProductList.equals(sortedItem);

        Serenity.reportThat("Check if product list is sorted in correctly order after change", () ->
                assertThat(isSorted).isTrue());
    }

    @Then("All products should be sorted by highest price")
    public void allProductsShouldBeSortedByHighestPrice() {
        var currentProductList = productList.getListOfAllProductsObject();
        List<CartItem> sortedItem = new ArrayList<>(currentProductList);
        sortedItem.sort(Collections.reverseOrder());
        boolean isSorted = currentProductList.equals(sortedItem);

        Serenity.reportThat("Check if product list is sorted in correctly order after change", () ->
                assertThat(isSorted).isTrue());
    }

    @When("Click on {string}")
    public void clickOn(String arg0) {
        productAction.forProductWithName(arg0);
    }

    @Then("All data included {string} should be the same as on main page")
    public void allDataIncludedShouldBeTheSameAsOnMainPage(String productName) {
        String path = "src/test/resources/test-data/ProductsData.csv";
        try {
            List<List<String>> data = csvDataReader.readDataFromCSV(path);
            data.forEach(row -> {
                String name = row.get(0);
                if (!productName.equals(name)) {
                    return;
                }
                String description = row.get(1);
                String price = row.get(2);

                Serenity.reportThat("Check if product name is correct", () ->
                        assertThat(name).isEqualTo(productAction.productName()));

                Serenity.reportThat("Check if product price is correct", () ->
                        assertThat(price).isEqualTo(productAction.productPrice().replace("$", "")));

                Serenity.reportThat("Check if product description is correct", () ->
                        assertThat(description).isEqualTo(productAction.productDescription()));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @When("Back to all products")
    public void backToAllProducts() {
        productAction.backToMainMenu();
    }

    @When("Click on image of {string}")
    public void clickOnImageOf(String productName) {
        productAction.imageForProductWithName(productName);
    }

    @Then("Image is equal as previous one")
    public void imageIsEqualAsPreviousOne() {
    }

    @When("User adding all products to cart")
    public void userAddingAllProductsToCart() {
    }

    @Then("User click on cart icon")
    public void userClickOnCartIcon() {
    }

    @Then("All products should be in cart")
    public void allProductsShouldBeInCart() {
    }

    @Then("Number of products should be visible on cart icon")
    public void numberOfProductsShouldBeVisibleOnCartIcon() {
    }

    @When("User add {string} to cart from product details page")
    public void userAddToCartFromProductDetailsPage(String arg0) {
    }

    @Then("Cart should contains {string}")
    public void cartShouldContains(String arg0) {
    }

    @When("User add {string} to cart from main page")
    public void userAddToCartFromMainPage(String arg0) {
    }

    @When("User delete this product from cart using button in main page")
    public void userDeleteThisProductFromCartUsingButtonInMainPage() {
    }

    @Then("Cart should be empty")
    public void cartShouldBeEmpty() {
    }

    @When("User delete this product from cart using button in product details page")
    public void userDeleteThisProductFromCartUsingButtonInProductDetailsPage() {
    }
}

