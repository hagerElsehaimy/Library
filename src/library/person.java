/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hager mohamed
 */
public class person {
    
    public static int SignUp(String fname,String lname,String phone,String mail,String password,String address){
		int status=0;
 
		try{
			
                        Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO `users` (`id`, `user_type_id`, `fname`, `lname`, `phone`, `email`, `paswordd`, `address`) VALUES ('1', '1', 'hager', 'mohamed', '01254', 'gogo@gmail', '12345', '12yhfgtdfrs');");
                        /*ps.setString(1,"5");
                        ps.setString(2,"2");
                        ps.setString(3,fname);
                        ps.setString(4,lname);
                        ps.setString(5,phone);
			ps.setString(6,mail);
                        ps.setString(7,password);
			ps.setString(8,address);*/
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
     public static boolean CheckIfAlready(String mail)
    {
        boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user where mail=?");
			ps.setString(1,mail);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
        
    }
}
