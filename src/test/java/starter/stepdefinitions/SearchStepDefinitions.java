package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.authentication.LoginAction;
import starter.authentication.User;
import starter.navigation.NavigateTo;
import starter.search.SearchFor;
import starter.search.SearchResult;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    SearchFor searchFor;

    @Steps
    SearchResult searchResult;

    @Steps
    LoginAction loginAction;

    @Given("^(?:.*) is researching things on the internet")
    public void i_am_on_the_Wikipedia_home_page() {
        navigateTo.theHomePage();
    }

    @When("she/he looks up {string}")
    public void i_search_for(String term) {
        searchFor.term(term);
    }

    @Then("she/he should see information about {string}")
    public void all_the_result_titles_should_contain_the_word(String term) {
        assertThat(searchResult.displayed()).contains(term);
    }

    @Given("User open the shop page")
    public void i_am_on_the_shop_page(){
        navigateTo.theSourceHomePage();
    }

    @When("User insert correct credential and try login")
    public void i_am_sucesfully_login_to_the_page_shop(){
        loginAction.loginAS(User.STANDARD_USER);
    }

    @Then("User should see main page")
    public void i_am_sucesfully(){
        loginAction.loginAS(User.STANDARD_USER);
    }

}

