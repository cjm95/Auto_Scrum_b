package bespin;
import bespin.ConnectDB;

public class test {
	public static void main(String[] args) {
		ConnectDB conn = ConnectDB.getInstance();
		
		String returns = conn.selectdb();
		System.out.println(returns);
	}
}
