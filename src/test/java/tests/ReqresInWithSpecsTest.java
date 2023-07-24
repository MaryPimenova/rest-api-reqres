package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.lombok.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.*;
import static constantData.ErrorMessages.*;
import static constantData.UsersData.*;
import static constantData.ResponseData.*;
import static constantData.ColorsData.*;
import static constantData.IDs.*;

@DisplayName("Tests of API for service Reqres.in")
@Owner("maryPimenova")
@Feature("API tests for reqres.in service")
@Story("ReqresIn")
@Tag("api")
public class ReqresInWithSpecsTest {

    @Test
    @DisplayName("User login is successful")
    void successfulLoginWithSpecsTest() {
        UserLoginAndRegistrationRequestModel requestBody = new UserLoginAndRegistrationRequestModel();
        requestBody.setEmail(USER_FIRST_EMAIL.getValue());
        requestBody.setPassword(USER_FIRST_PASSWORD.getValue());

        UserLoginResponseModel loginResponse = step("Make request", () ->
                given(requestSpec)
                        .body(requestBody)
                        .when()
                        .post("login")
                        .then()
                        .spec(responseWithCode200Spec)
                        .extract().as(UserLoginResponseModel.class));
        step("Check token in response", () ->
                assertEquals(EXPECTED_TOKEN.getValue(), loginResponse.getToken()));
    }

    @Test
    @DisplayName("User login and password are invalid (missing json format, error 400)")
    void negativeLoginAndPassword400WithSpecsTest() {
        UserLoginAndRegistrationRequestModel requestBody = new UserLoginAndRegistrationRequestModel();
        requestBody.setEmail(USER_FIRST_EMAIL.getValue());
        requestBody.setPassword(USER_FIRST_PASSWORD.getValue());

        UserLoginResponseModel loginResponse = step("Make request", () ->
                given(loginRequestWithoutJsonFormatSpec)
                        .body(requestBody)
                        .when()
                        .post("login")
                        .then()
                        .spec(responseWithCode400Spec)
                        .extract().as(UserLoginResponseModel.class));
        step("Check error message in response", () ->
                assertEquals(MISSING_EMAIL_OR_USERNAME.getValue(), loginResponse.getError()));
    }

    @Test
    @DisplayName("User login is unsuccessful as password is missed (error 400)")
    void negativePassword400WithSpecsTest() {
        UserLoginAndRegistrationRequestModel requestBody = new UserLoginAndRegistrationRequestModel();
        requestBody.setEmail(USER_SECOND_EMAIL.getValue());

        UserLoginResponseModel loginResponse = step("Make request", () ->
                given(requestSpec)
                        .body(requestBody)
                        .when()
                        .post("login")
                        .then()
                        .spec(responseWithCode400Spec)
                        .extract().as(UserLoginResponseModel.class));

        step("Check error message in response", () ->
                assertEquals(MISSING_PASSWORD.getValue(), loginResponse.getError()));
    }

    @Test
    @DisplayName("User registration is successful")
    void successfulRegistrationWithSpecsTest() {
        UserLoginAndRegistrationRequestModel requestBody = new UserLoginAndRegistrationRequestModel();
        requestBody.setEmail(USER_FIRST_EMAIL.getValue());
        requestBody.setPassword(USER_SECOND_PASSWORD.getValue());

        UserRegistrationResponseModel registrationResponse = step("Make request", () ->
                given(requestSpec)
                        .body(requestBody)
                        .when()
                        .post("register")
                        .then()
                        .spec(responseWithCode200Spec)
                        .extract().as(UserRegistrationResponseModel.class));
        step("Check ID value in response", () ->
                assertEquals(EXPECTED_ID.getValue(), registrationResponse.getID()));
        step("Check token in response", () ->
                assertEquals(EXPECTED_TOKEN.getValue(), registrationResponse.getToken()));
    }

    @Test
    @DisplayName("User registration is unsuccessful (password is missed, error 400)")
    void negativeRegistrationTest() {
        UserLoginAndRegistrationRequestModel requestBody = new UserLoginAndRegistrationRequestModel();
        requestBody.setEmail(USER_THIRD_EMAIL.getValue());

        UserRegistrationResponseModel registrationResponse = step("Make request", () ->
                given(requestSpec)
                        .body(requestBody)
                        .when()
                        .post("register")
                        .then()
                        .spec(responseWithCode400Spec)
                        .extract().as(UserRegistrationResponseModel.class));
        step("Check error message in response", () ->
                assertEquals(MISSING_PASSWORD.getValue(), registrationResponse.getError()));
    }

    @Test
    @DisplayName("Test of delete option")
    void deleteWithSpecsTest() {
        step("Make request", () ->
                given(requestSpec)
                        .when()
                        .delete("users/2")
                        .then()
                        .spec(responseWithCode204Spec));

    }

    @Test
    @DisplayName("Test of patch option")
    void patchWithSpecsTest() {

        CreatePatchPutRequestModel requestBody = new CreatePatchPutRequestModel();
        requestBody.setName(USER_NAME.getValue());
        requestBody.setJob(USER_FIRST_JOB.getValue());

        CreatePatchPutResponseModel patchResponse = step("Make request", () ->
                given(requestSpec)
                        .body(requestBody)
                        .when()
                        .patch("users/2")
                        .then()
                        .spec(responseWithCode200Spec)
                        .extract().as(CreatePatchPutResponseModel.class));
        step("Check name in response", () ->
                assertEquals(USER_NAME.getValue(), patchResponse.getName()));
        step("Check job in response", () ->
                assertEquals(USER_FIRST_JOB.getValue(), patchResponse.getJob()));
        step("Check date of information updating in response", () ->
                patchResponse.getUpdatedAt().startsWith("2023"));

    }

    @Test
    @DisplayName("Test of put option")
    void putWithSpecsTest() {
        CreatePatchPutRequestModel requestBody = new CreatePatchPutRequestModel();
        requestBody.setName(USER_NAME.getValue());
        requestBody.setJob(USER_FIRST_JOB.getValue());

        CreatePatchPutResponseModel putResponse = step("Make request", () ->
                given(requestSpec)
                        .body(requestBody)
                        .when()
                        .put("users/2")
                        .then()
                        .spec(responseWithCode200Spec)
                        .extract().as(CreatePatchPutResponseModel.class));
        step("Check name in response", () ->
                assertEquals(USER_NAME.getValue(), putResponse.getName()));
        step("Check job in response", () ->
                assertEquals(USER_FIRST_JOB.getValue(), putResponse.getJob()));
        step("Check date of information updating in response", () ->
                putResponse.getUpdatedAt().startsWith("2023"));
    }

    @Test
    @DisplayName("Test of creation via POST option")
    void creationWithSpecsTest() {
        CreatePatchPutRequestModel requestBody = new CreatePatchPutRequestModel();
        requestBody.setName(USER_NAME.getValue());
        requestBody.setJob(USER_SECOND_JOB.getValue());

        CreatePatchPutResponseModel createResponse = step("Make request", () ->
                given(requestSpec)
                        .body(requestBody)
                        .when()
                        .post("users")
                        .then()
                        .spec(responseWithCode201Spec)
                        .extract().as(CreatePatchPutResponseModel.class));
        step("Check name in response", () ->
                assertEquals(USER_NAME.getValue(), createResponse.getName()));
        step("Check job in response", () ->
                assertEquals(USER_SECOND_JOB.getValue(), createResponse.getJob()));
        step("Check ID is not null in response", () ->
                assertThat(createResponse.getId()).isNotNull());
        step("Check date of information creating in response", () ->
                createResponse.getCreatedAt().startsWith("2023"));

    }

    @Test
    @DisplayName("Display user list page №2 and check its scheme")
    void getUsersListSchemeWithSpecsTest() {
        step("Make request", () ->
                given(requestSpec)
                        .when()
                        .get("users?page=2")
                        .then()
                        .spec(responseWithCode200Spec)
                        .body(matchesJsonSchemaInClasspath("schemes/users-list-response-scheme.json")));

    }

    @Test
    @DisplayName("Check users list by IDs and names")
    void getUsersListIDsAndNamesWithSpecsTest() {

        UsersListResponseModel response = step("Make request", () ->
                given(requestSpec)
                        .when()
                        .get("users?page=2")
                        .then()
                        .spec(responseWithCode200Spec)
                        .extract().as(UsersListResponseModel.class));
        step("Check ID of the first user in response", () ->
                assertThat(response.getData().getFirst().getID()).isEqualTo(EXPECTED_FIRST_USER_ID.getValue()));
        step("Check ID of the last user in response", () ->
                assertThat(response.getData().getLast().getID()).isEqualTo(EXPECTED_LAST_USER_ID.getValue()));
        step("Check name of the first user in response", () ->
                assertThat(response.getData().getFirst().getLast_name()).isEqualTo(EXPECTED_LAST_NAME_OF_FIRST_USER.getValue()));
        step("Check name of the last user in response", () ->
                assertThat(response.getData().getLast().getLast_name()).isEqualTo(EXPECTED_LAST_NAME_OF_LAST_USER.getValue()));

    }

    @Test
    @DisplayName("Test of sending an unknown request (single user №23 doesn't exist)")
    void getNonExistentUserWithSpecsTest() {
        step("Make request", () ->
                given(requestSpec)
                        .when()
                        .get("unknown/23")
                        .then()
                        .spec(responseWithCode404Spec));
    }

    @Test
    @DisplayName("Test of single user data content")
    void getSingleUserDataWithSpecsTest() {

        SingleUserResponseModel response = step("Make request", () ->
                given(requestSpec)
                        .when()
                        .get("users/2")
                        .then()
                        .spec(responseWithCode200Spec)
                        .extract().as(SingleUserResponseModel.class));
        step("Check ID of the single user in response", () ->
                assertThat(response.getData().getID()).isEqualTo(EXPECTED_SINGLE_USER_ID.getValue()));
        step("Check the last name of the single user in response", () ->
                assertThat(response.getData().getLast_name()).isEqualTo(EXPECTED_SINGLE_USER_LAST_NAME.getValue()));
    }

    @Test
    @DisplayName("Test of checking IDs and names in color list")
    void getColorListIdsNamesWithSpecsTest() {
        ColorsResponseModel response = step("Make request", () ->
                given(requestSpec)
                        .when()
                        .get("unknown")
                        .then()
                        .spec(responseWithCode200Spec)
                        .extract().as(ColorsResponseModel.class));
        step("Check ID of the first user in response", () ->
                assertThat(response.getData().getFirst().getID()).isEqualTo(EXPECTED_FIRST_COLOR_ID.getValue()));
        step("Check ID of the last user in response", () ->
                assertThat(response.getData().getLast().getID()).isEqualTo(EXPECTED_LAST_COLOR_ID.getValue()));
        step("Check name of the first user in response", () ->
                assertThat(response.getData().getFirst().getName()).isEqualTo(EXPECTED_NAME_OF_FIRST_COLOR.getValue()));
        step("Check name of the last user in response", () ->
                assertThat(response.getData().getLast().getName()).isEqualTo(EXPECTED_NAME_OF_LAST_COLOR.getValue()));
    }


}
