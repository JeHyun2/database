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
		System.out.println(" 1. 극장별 예매  2. 영화별 예매  ");
		System.out.println(" 3. 개봉일 보기  4. 시간별 예매 ");
		System.out.println(" 5. 배우별 출연작 6. create instance ");
		System.out.println(" 7. reboot instance 8. list images ");
		System.out.println(" 9. Delete instance 10. Exit ");
		System.out.println("------------------------------------------------------------");
		System.out.print("Enter an integer:");

		number = menu.nextInt();
		
		switch (number) {
		case 1:
			MovieList();
			break;
		case 2:
			System.out.println("영화별 예매 : ");
			instance_id=id_string.next();
			listCustomer(instance_id);
			break;
		case 3:
			//System.out.println("개봉일 보기 : ");
			//instance_id=id_string.next();
			OpeningDate("20191121");
			break;
		case 4:
			System.out.print("시간별 예매 : ");
			instance_id=id_string.next();
			Time_res(instance_id);
		case 5:
			System.out.print("배우 입력 : ");
			instance_id=id_string.next();
			ActorMovielist(instance_id);

		}
	}
}
public static void MovieList() {

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from Theater");
		//sql.append("Select * From Screen where SeatNum <"+ instance_id +" ");
		ResultSet rs=stmt.executeQuery(sql.toString());
		System.out.println("Number Movie_name RunningTime Actor OpeningDate");
		while(rs.next())
		System.out.println(rs.getInt(1) +" " + rs.getString(3));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
	
}
public static void listCustomer(String instance_id) {
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();

		sql.append("Select * From Screen where SeatNum <"+ instance_id +" ");
		ResultSet rs=stmt.executeQuery(sql.toString());
		
		while(rs.next())
		System.out.println(rs.getString(1) +" " + rs.getString(2) +" " + rs.getString(3) +" " + rs.getString(4));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
}
public static void OpeningDate(String instance_id) {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();

		sql.append("select MovieNum, MovieName, OpeningDate from Movie");
		ResultSet rs=stmt.executeQuery(sql.toString());
		
		while(rs.next())
		System.out.println(rs.getString(1) +" " + rs.getString(2)+" " + rs.getString(3));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
}

public static void Time_res(String instance_id) {

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from Screen where Time= '" + instance_id +" '");
		ResultSet rs=stmt.executeQuery(sql.toString());
		
		while(rs.next())
		System.out.println(rs.getString(1)+" " + rs.getString(2)+" " + rs.getString(3) +" " + rs.getString(4));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
	
}

public static void ActorMovielist(String instance_id) {

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM Movie WHERE Actor IN ('" + instance_id + " ') " );
		ResultSet rs=stmt.executeQuery(sql.toString());
		
		while(rs.next())
		System.out.println(rs.getString(1)+" " + rs.getString(2)+"     " + rs.getString(3) +"     " + rs.getString(4));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
	
}

}