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
	String Iname;
	String Ibirth;
	String Iphone;
	String Iaddress;
	String Inum;
	while (true) {
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("------------------------------------------------------------");
		System.out.println(" Movie Reservation ");
		System.out.println(" ");
		System.out.println(" DATABASE, Computer Science Department ");
		System.out.println(" at Chungbuk National University ");
		System.out.println("------------------------------------------------------------");
		System.out.println(" 1. 극장 검색     2. 영화 검색 ");
		System.out.println(" 3. 개봉일 보기   4. 시간별 예매 ");
		System.out.println(" 5. 배우별 출연작 6. 회원가입");
		System.out.println(" 		99. Exit");
		System.out.println("------------------------------------------------------------");
		System.out.print("Enter an integer:");

		number = menu.nextInt();
		
		switch (number) {
		case 1:
			System.out.println("극장 검색");
			TheaterList();
			break;
		case 2:
			movieList();
			break;
		case 3:
			OpeningDate();
			break;
		case 4:
			System.out.print("시간 입력 : ");
			Iname=id_string.next();
			Time_res(Iname);
			break;
		case 5:
			System.out.print("배우 입력 : ");
			Iname=id_string.next();
			ActorMovielist(Iname);
			break;
		case 6:
			System.out.print("순서 입력: ");
			Inum=id_string.next();
			System.out.print("이름 입력: ");
			Iname=id_string.next();
			System.out.print("생년월일 입력 : ");
			Ibirth=id_string.next();
			System.out.print("핸드폰번호 입력 : ");
			Iphone=id_string.next();
			System.out.print("주소 입력 : ");
			Iaddress=id_string.next();
			
			Join(Inum, Iname, Ibirth, Iphone,Iaddress);
			
			break;
		case 99:
			System.out.println("The program will now exit!\n"
					+ "Bye Bye");
			System.exit(0);
			break;	
			
		}
	}
}
public static void TheaterList() {

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from Theater");
		
		ResultSet rs=stmt.executeQuery(sql.toString());

		while(rs.next())
		System.out.println(rs.getInt(1) +" " + rs.getString(2)+" " + rs.getString(3)+" " + rs.getString(4));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
	
}

public static void movieList() {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from Movie");
		//sql.append("Select * From Screen where SeatNum <"+ Iname +" ");
		ResultSet rs=stmt.executeQuery(sql.toString());
		System.out.println("Movie_name				RunningTime			 Actor			 OpeningDate");
		while(rs.next())
		System.out.println(rs.getString(2)+"				" + rs.getString(3)+"				 " + rs.getString(4)+" 				" + rs.getString(5));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
}
public static void listCustomer(String Iname) {
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();

		sql.append("Select * From Screen where MovieName ='" + Iname +"' ");
		ResultSet rs=stmt.executeQuery(sql.toString());
		
		while(rs.next())
		System.out.println(rs.getString(1) +" " + rs.getString(2) +" " + rs.getString(3) +" " + rs.getString(4)+" " + rs.getString(5));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
}
public static void OpeningDate() {
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

public static void Time_res(String Iname) {

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from Screen where Time= '" + Iname +" '");
		ResultSet rs=stmt.executeQuery(sql.toString());
		
		while(rs.next())
		System.out.println(rs.getString(1)+" " + rs.getString(2)+" " + rs.getString(3) +" " + rs.getString(4));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
	
}

public static void ActorMovielist(String Iname) {

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM Movie WHERE Actor IN ('" + Iname + " ') " );
		ResultSet rs=stmt.executeQuery(sql.toString());
		
		while(rs.next())
		System.out.println(rs.getString(1)+" " + rs.getString(2)+"     " + rs.getString(3) +"     " + rs.getString(4));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
}


public static void Join(String Inum, String Iname, String Ibirth, String Iphone, String Iaddress) {

	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
		"jdbc:mysql://192.168.56.105:4567/Moive_res", "jehyun" , "gusdl156");
		Statement stmt=con.createStatement();
		
		StringBuffer sql = new StringBuffer();
		StringBuffer sql2 = new StringBuffer();
		sql.append("INSERT INTO Customer( Cus_Num, Cus_name, Birth, PhoneNum, Address)" +
				"VALUES ("+ Inum +" ,' " + Iname + " ' ,'"+ Ibirth + " ' ,' " + Iphone + " ', '" + Iaddress + " ' )");
		
		stmt.executeUpdate(sql.toString());
		sql2.append("select * from Customer ");
		ResultSet rs=stmt.executeQuery(sql2.toString());
		while(rs.next())
		System.out.println(rs.getString(1)+" " + rs.getString(2)+"     " + rs.getString(3) +"     " + rs.getString(4));
		
		con.close();
		
	}catch(Exception e){ System.out.println(e);}
}


}