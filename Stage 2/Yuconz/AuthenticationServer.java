import java.util.HashMap;
public class AuthenticationServer {
    private static HashMap<String,String> employeeLogins = new HashMap<>();
    private static HashMap<String,String> HREmployeeLogins = new HashMap<>();
    private static HashMap<String,String> directorLogins = new HashMap<>();
    private static HashMap<String,String> reviewerLogins = new HashMap<>();

    public AuthenticationServer() {
        employeeLogins.put("abc100", "hello");
        HREmployeeLogins.put("ghi300", "hello1");
        directorLogins.put("def200", "hello2");
        employeeLogins.put("jkl1400", "hello3");
        HREmployeeLogins.put("mno500", "hello4");
        directorLogins.put("pqr600", "hello5");
        reviewerLogins.put("stu700", "hello6");
        reviewerLogins.put("vwx800", "hello7");
    }

    public static boolean login (String username, String password, int accessLevel) 
    {
        if(accessLevel == 1) 
        {
            if(employeeLogins.containsKey(username)) {
                if(employeeLogins.get(username).contentEquals(password)) 
                {
                    return true;
                } else {return false;}
            } else {return false;}
        }
        if(accessLevel == 2) 
        {
            if(HREmployeeLogins.containsKey(username)) {
                if(HREmployeeLogins.get(username).contentEquals(password)) 
                {
                    return true;
                } else {return false;}
            } else {return false;}
        }
        if(accessLevel == 3) 
        {
            if(directorLogins.containsKey(username)) {
                if(directorLogins.get(username).contentEquals(password)) 
                {
                    return true;
                } else {return false;}
            }  else {return false;}
        } 
        if(accessLevel == 4) 
        {
            if(reviewerLogins.containsKey(username)) {
                if(reviewerLogins.get(username).contentEquals(password)) 
                {
                    return true;
                } else {return false;}
            }  else {return false;}
        } 

        return false;
    }

}
