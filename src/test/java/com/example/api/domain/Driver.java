package com.example.api.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	private long id;
	private String driverName;
	private String email;
	private String msisdn;
	private int status;	
	
    public Driver() {
		super();
	}

	public Driver(long id, String driverName, String email, String msisdn, int status) {
		super();
		this.id = id;
		this.driverName = driverName;
		this.email = email;
		this.msisdn = msisdn;
		this.status = status;
	}

	public static String createAc(Driver acc) {
        try{
            PreparedStatement st = Connection.connectDB().prepareStatement(
                    "insert into driver (driver_id,driver_name,email,msisdn,status) values(?,?,?,?,?)");
            st.setLong(1, acc.id);
            st.setString(2, acc.driverName);
            st.setString(3, acc.email);
            st.setString(4, acc.msisdn);
            st.setDouble(5, acc.status);
            st.execute();
            Connection.connectDB().close();
            return "Driver created";
        }catch(Exception ex) {
            throw new RuntimeException(""+ex.getMessage());
        }
    }
	
	   public static String updateDriver(Driver driver) {
	        try{
	            PreparedStatement st = Connection.connectDB().prepareStatement(
	                    "update driver set driver_name =?, email = ?, "
	                            + "msisdn =?, status =? where msisdn=?");
	      
	            st.setString(1, driver.driverName);
	            st.setString(2, driver.email);
	            st.setString(3, driver.msisdn);
	            st.setInt(4, driver.status);
	            st.setString(5, driver.msisdn);
	            int q = st.executeUpdate();    
	            Connection.connectDB().close();
	            if(q == 0)
	                throw new RuntimeException("No row(s) affected");
	            else
	                return "Driver updated";
	        }catch(Exception ex) {
	            throw new RuntimeException("Failed to update: "+ex.getMessage());
	        }
	    }
	   
	    public static String delete(Driver driver) {
	        try{
	            PreparedStatement st = Connection.connectDB().prepareStatement(
	                    "delete from driver where msisdn =?");
	            st.setString(1, driver.msisdn);
	            int q = st.executeUpdate();
	            Connection.connectDB().close();
	            if(q == 0)
	                throw new RuntimeException("No row(s) affected");
	            else 
	                return "Driver deleted";
	        }catch(Exception ex) {
	            throw new RuntimeException("Failed to delete: "+ex.getMessage());
	        }
	    }
	    
	    public static List<Driver> findAll() {
	        List<Driver> list = new ArrayList<>();
	        try{
	                PreparedStatement st = Connection.connectDB().prepareStatement(
	                        "select * from driver");
	                ResultSet rs = st.executeQuery();
	                while(rs.next()) {
	                    list.add(new Driver(rs.getLong(1),rs.getString(3), rs.getString(4), 
	                            rs.getString(6), rs.getInt(7)));
	                }
	                Connection.connectDB().close();
	                return list;
	        }catch(Exception ex) {
	            throw new RuntimeException(""+ex.getMessage());
	        }
	    }
	
	
}
