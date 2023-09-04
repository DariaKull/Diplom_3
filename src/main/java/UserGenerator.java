import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User getRandomUser(){
        return new User(UserGenerator.getRandomEmail(),UserGenerator.getRandomPassword(),UserGenerator.getRandomName());
    }

    public static String getRandomEmail(){
        return RandomStringUtils.randomAlphanumeric(10)+"@mail.ru";
    }

    public static String getRandomPassword(){
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public static String getRandomName(){
        return RandomStringUtils.randomAlphanumeric(10);
    }

}
