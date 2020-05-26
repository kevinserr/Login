package login_application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FilesHandler {
	
	private ArrayList<String> users = new ArrayList<String>();
	private ArrayList<String> passwords = new ArrayList<String>(); 
	
	static File file = new File("C:\\Users\\ks255\\eclipse-workspace-java\\Graphical User Interface Projects\\src\\login_application\\SignUpInformation.txt");
	
	public FilesHandler() {
	
	}
	
	public boolean authenticate(String u, String p) throws Exception {
		BufferedReader b = new BufferedReader(new FileReader(file));
		String readLine = "";
		while ((readLine = b.readLine()) != null) {
			String user = readLine.substring(0, readLine.indexOf("\\"));
			String pass = readLine.substring(readLine.indexOf("\\")+1);
			if(user.equals(u) && pass.equals(p)) {
				return true;
			}
        }
		return false;
		
	}
	
	public void print() {
		for(String s: users) {
			System.out.println(s);
		}
		for(String p: passwords) {
			System.out.println(p);
		}
		
	}
	public static void main(String[] args) throws Exception {
		
	}

}
