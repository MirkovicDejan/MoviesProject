package MyQueries;

import com.moviesproject.moviesproject.model.User;

public class MyQueryForUserRoleRepository {

    public String queryForExistsByUser(Integer id){
        String query = "SELECT user FROM UserRole ur where ur.userRoleId = :id";
        return query;
    }

}
