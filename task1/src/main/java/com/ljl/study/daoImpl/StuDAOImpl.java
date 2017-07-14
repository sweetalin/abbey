package com.ljl.study.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ljl.study.dao.StuDAO;
import com.ljl.study.entity.Stu;
import com.ljl.study.util.DBUtil;

/** 
* @author alin 
* @version 2017年6月7日
* 类说明 
*/
public class StuDAOImpl implements StuDAO {

	@Override
	public void insert(Stu stu) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into stu(name,type,school_day,gra_university,day_report,wish,check_senior,create_at) values(?,?,?,?,?,?,?,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			 
            ps.setString(1, stu.getName());
            ps.setString(2, stu.getType());
            ps.setLong(3, stu.getSchool_day());
            ps.setString(4, stu.getGra_university());
            ps.setString(5, stu.getDay_report());
            ps.setString(6, stu.getWish());
            ps.setString(7, stu.getCheck_senior());
            ps.setLong(8, stu.getCreate_at());
 
            ps.execute();
 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                stu.setId(id);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
	
    }

	@Override
	public void update(Stu stu) throws Exception {
		// TODO Auto-generated method stub
		 String sql = "update stu set wish= ? where id = ? ";
	        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	 
	            ps.setString(1, stu.getWish());
	            ps.setInt(2, stu.getId());
	            ps.execute();
	 
	        } catch (SQLException e) {
	 
	            e.printStackTrace();
	        }
	}

	@Override
	public void delete(int stuid) throws Exception {
		// TODO Auto-generated method stub
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			 
            String sql = "delete from stu where id = " + stuid;
 
            s.execute(sql);
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
	}

	@Override
	public Stu queryById(int stuid) throws Exception {
		// TODO Auto-generated method stub
		Stu stu = null;
		 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select * from stu where id = " + stuid;
 
            ResultSet rs = s.executeQuery(sql);
 
            if (rs.next()) {
            	stu = new Stu();
                String name = rs.getString("name");
                stu.setName(name);
                
                stu.setId(stuid);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return stu;
	}

	@Override
	public List<Stu> queryAll() throws Exception {
		// TODO Auto-generated method stub
		List<Stu> all = new ArrayList<Stu>();
		String sql = "select * from stu";
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
        	
            ResultSet rs = s.executeQuery(sql);
 
            while (rs.next()) {
            	Stu stu = new Stu();
            	stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setType(rs.getString("type"));
                stu.setSchool_day(rs.getLong(4));
                all.add(stu);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
		return all;
	}

}
