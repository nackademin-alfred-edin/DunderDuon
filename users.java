import java.util.List;

class users {

    static List<String> user;
    static String username;
    static String email;
    static String number;
	static String password;
	
	public void createUser() {
		user = login.getUserInfo();
		username = user.get(0);
		email = user.get(1);
		number = user.get(2);
		password = login.passwordLoop();
	}
	
	public static void main(String[] args) {
		
		users user_1 = new users();
		user_1.createUser();
		System.out.println(user_1);

		users user_2 = new users();
		user_2.createUser();
		System.out.println(user_2);

		users user_3 = new users();
		user_3.createUser();
		System.out.println(user_3);
	}



}
