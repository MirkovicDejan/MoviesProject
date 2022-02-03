package MyQueries;

public class MyQueryForRoleRepository {


    public String createQueryForExistsByName(String name){
        String query = "SELECT name from Role r where r.name = :name";
        return query;
    }



}
