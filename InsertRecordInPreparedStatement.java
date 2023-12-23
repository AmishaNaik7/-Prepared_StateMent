import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecordInPreparedStatement {
  
	static int cid;
   static String studentName;
   static String courseName;
   static String city;
   static int pin;
   
   public static void main(String[] args) throws Exception {
	   
	   Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Load");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sp", "root", "root");
		System.out.println("Connection Done Succcccccccessssfullllllly");
		
		
      Scanner sc=new Scanner(System.in);
           
      for(int i=1;i<=3;i++) {
         input(sc);
         PreparedStatement pstmt = con.prepareStatement("INSERT INTO CourseDemo(cid, studentName, courseName, city, pin)" + "VALUES (?, ?, ?, ?, ?)");
         pstmt.setInt(1, cid);
         pstmt.setString(2, studentName);
         pstmt.setString(3, courseName);
         pstmt.setString(4, city);
         pstmt.setInt(5, pin);
         
         pstmt.executeUpdate();
         
         System.out.println("Record is inserted successfully !!!");
      
      }
   }
    
   		public static void input(Scanner sc) {
	      
	      System.out.println("Enter the course id:");
	      cid = sc.nextInt();
	      System.out.println("Enter the Student Name:");
	      studentName = sc.next();
	      System.out.println("Enter the Course Name:");
	      courseName = sc.next();
	      System.out.println("Enter the City Name:");
	      city = sc.next();
	      System.out.println("Enter the PIN NO:");
	      pin = sc.nextInt();
	      
   }
    
}