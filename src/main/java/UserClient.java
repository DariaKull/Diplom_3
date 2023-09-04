import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {
    private static final String USER_REGISTER_PATH = "/api/auth/register";
    private static final String USER_LOGIN_PATH = "/api/auth/login";
    private static final String USER_DELETE_PATH = "/api/auth/user";

    public ValidatableResponse createUser(User user){
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(USER_REGISTER_PATH)
                .then();
    }

    public ValidatableResponse loginUser(UserCredentials userCredentials){
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .when()
                .post(USER_LOGIN_PATH)
                .then();
    }

    public void deleteUser(String accessToken){
        given()
                .header(new Header("Authorization",accessToken))
                .spec(getBaseSpec())
                .when()
                .delete(USER_DELETE_PATH)
                .then();
    }
}
