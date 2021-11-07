package mulesoft;
import java.sql.*;

public class movie {
		
	public static void main(String[] args){
		
		try{
			
			Class.forName("org.sqlite.JDBC");
			
			// creating database "mulesoft" and creating connection
			
			String url="jdbc:sqlite:G:\\mulesoft.db";
			Connection con=DriverManager.getConnection(url);
			
			if(con!=null){
				
				System.out.println("Database created");
				
				// creating table "Movies"
				
				Statement stmt=con.createStatement();
				int n=stmt.executeUpdate("create table Movies(MovieId int primary key, Name text, Actor text, Actress text, Director text, YearOfRelease int)");
				System.out.println("Table created");
				
				// inserting data into table
				
				PreparedStatement pstmt=con.prepareStatement("insert into Movies values(?,?,?,?,?,?)");
				n=0;
		
				pstmt.setInt(1,1);
				pstmt.setString(2,"Jai Bheem");
				pstmt.setString(3,"Suriya");
				pstmt.setString(4,"Lijomol Jose");
				pstmt.setString(5,"TJ Gnanavel");
				pstmt.setInt(6,2021);
				n+=pstmt.executeUpdate();
				//System.out.println(n +" record entered");
				
				pstmt.setInt(1,2);
				pstmt.setString(2,"24");
				pstmt.setString(3,"Suriya");
				pstmt.setString(4,"Samantha");
				pstmt.setString(5,"Vikram Kumar");
				pstmt.setInt(6,2016);
				n+=pstmt.executeUpdate();
				//System.out.println(n +" record entered");
				
				pstmt.setInt(1,3);
				pstmt.setString(2,"Titanic");
				pstmt.setString(3,"Leonardo DiCaprio");
				pstmt.setString(4,"Kate Winslet");
				pstmt.setString(5,"James Cameron");
				pstmt.setInt(6,1997);
				n+=pstmt.executeUpdate();
				//System.out.println(n +" record entered");
				
				pstmt.setInt(1,4);
				pstmt.setString(2,"Athadu");
				pstmt.setString(3,"Mahesh Babu");
				pstmt.setString(4,"Trisha");
				pstmt.setString(5,"Trivikram Srinivas");
				pstmt.setInt(6,2005);
				n+=pstmt.executeUpdate();
				//System.out.println(n +" record entered");
				
				pstmt.setInt(1,5);
				pstmt.setString(2,"Eega");
				pstmt.setString(3,"Nani");
				pstmt.setString(4,"Samantha");
				pstmt.setString(5,"SS Rajamouli");
				pstmt.setInt(6,2012);
				n+=pstmt.executeUpdate();
				System.out.println(n +" records entered");
		

				//retrieving all the records from table
				
				pstmt=con.prepareStatement("select * from Movies");
				ResultSet rs=pstmt.executeQuery();
				System.out.println("All records in table");
				while(rs.next()){
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6));
				}
				
				//retrieving data based on Actor's name
				
				pstmt=con.prepareStatement("select * from Movies where Actor='Suriya'");
				rs=pstmt.executeQuery();
				System.out.println("Movies with actor as Suriya");
				while(rs.next()){
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6));
				}
		
				//closing connection
				con.close();

		        }
		}
		
		catch(Exception e){
			System.out.println(e);
			}

		}
}