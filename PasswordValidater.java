package Level2;
import java.util.Scanner;
import java.util.HashSet;

public class PasswordValidater {
	Scanner scanner;
	String password;
	HashSet<Character> specialCharacterset;
	private PasswordValidater() {
		specialCharacterset=new HashSet<Character>();
		specialCharacterset.add('!');
		specialCharacterset.add('@');
		specialCharacterset.add('$');
		specialCharacterset.add('%');
		specialCharacterset.add('&');
		specialCharacterset.add('(');
		specialCharacterset.add(')');
		specialCharacterset.add('*');
		specialCharacterset.add('+');
		specialCharacterset.add('-');
		specialCharacterset.add('.');
		specialCharacterset.add('_');
		scanner=new Scanner(System.in);
		password=getPassword();
		if(password!=null && !password.isEmpty()) {
			validatePassword();
		}else {
			System.out.println("Kindly enter a valid form of password ");
		}
	}
	private String getPassword() {
		System.out.println("Enter your password to be validated : ");
		return scanner.nextLine();
	}
	private void validatePassword() {
		    if (!(password.length() >= 8)) {
		        System.out.println("Password must be longer than 10 characters.");
		    } else if (!Character.isUpperCase(password.charAt(0))) {
		        System.out.println("Password must contain atleast an uppercase letter.");
		    } else if(!containsNumber()) {
		        System.out.println("Password must contain numbers");
		    } else if (!containsSpecialcharacter()) {
		        System.out.println("Password must contain at least one special character such as (!, @, #) etc ");
		    }else {
		    	System.out.println("Password Strong good to go !");
		    }
	}
	private boolean containsNumber() {
		int count=0;
		for(char character:password.toCharArray()) {
			if(Character.isDigit(character)) {
				count++;
			}
		}
		return count>=1;
	}
	private boolean containsSpecialcharacter() {
		 int count=0;
		for(char character:password.toCharArray()) {
			if(!Character.isDigit(character) && !Character.isLetter(character)) {
				if(specialCharacterset.contains(character)) {
					count++;
				}
			}
		}
		return count>=1;
	}
	public static void main(String[] args) {
		new PasswordValidater();
	}

}
