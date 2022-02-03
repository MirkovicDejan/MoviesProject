package MyQueries;

public class MyQueryForUserRepository {

    public String createQueryForExistUserName(String userName) {
        String queryForUserName = "SELECT userName from User u where u.userName = :userName";
        return queryForUserName;
    }

    public static String createQueryForExistsByEmail(String email) {
        String queryForEmail = "SELECT email from User u where u.email = :email";
        return queryForEmail;
    }

    public String createQueryForExistsByPassword(String password) {
        String queryForPassword = "SELECT password from User u where u.password = :password";
        return queryForPassword;
    }

    public String createQueryForExistsByPhoneNumber(String phoneNumber) {
        String queryForPhoneNumber = "SELECT phoneNumber from User u where u.phoneNumber = :phoneNumber";
        return queryForPhoneNumber;
    }
}
