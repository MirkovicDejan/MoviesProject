package MyQueries;

public enum MyQUERIES {

    EXISTS_BY_USER("SELECT user FROM UserRole ur where ur.userRoleId = :id"),
    EXIST_BY_USERNAME("SELECT userName from User u where u.userName = :userName"),
    EXIST_BY_EMAIL("SELECT email from User u where u.email = :email"),
    EXIST_BY_PASSWORD("SELECT password from User u where u.password = :password"),
    EXIST_BY_PHONE_NUMBER("SELECT phoneNumber from User u where u.phoneNumber = :phoneNumber"),
    EXIST_BY_NAME("SELECT name from Role r where r.name = :name");

    private final String query;

    MyQUERIES(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
