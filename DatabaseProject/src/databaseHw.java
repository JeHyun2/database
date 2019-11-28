import java.sql.*;
import java.util.Scanner;

public class databaseHw
{
	private static void init() throws Exception {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
			Statement stmt=con.createStatement();
		}catch(Exception e){ System.out.println(e);}
	}
public static void main(String[] args) throws Exception
{
	init();
	Scanner menu = new Scanner(System.in);
	Scanner id_string = new Scanner(System.in);

	int number = 0;
	String instance_id;

	while (true) {
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("------------------------------------------------------------");
		System.out.println(" Movie Reservation ");
		System.out.println(" ");
		System.out.println(" DATABASE, Computer Science Department ");
		System.out.println(" at Chungbuk National University ");
		System.out.println("------------------------------------------------------------");
		System.out.println(" 1.  2. available zones ");
		System.out.println(" 3. start instance 4. available regions ");
		System.out.println(" 5. stop instance 6. create instance ");
		System.out.println(" 7. reboot instance 8. list images ");
		System.out.println(" 9. Delete instance 10. Exit ");
		System.out.println("------------------------------------------------------------");
		System.out.print("Enter an integer:");

		number = menu.nextInt();
		
		switch (number) {
		case 1:
			System.out.println("whktjr별 영화검색 : ");
			instance_id=id_string.next();
			listCustomer(instance_id);
			break;

		}
	}
}
public static void listCustomer(String instance_id) {
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select MovieName from Movie where MovieNum =(select TheaterNum from Screening where MovieNum =(select TheaterNum from Theater where T_Name = \"" + "Chungju_CBNU"+"\" ))");
		//sql.append("Select * From Screen where SeatNum <"+ instance_id +" ");
		ResultSet rs=stmt.executeQuery(sql.toString());
		
		while(rs.next())
		System.out.println(rs.getString(1));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
}

}