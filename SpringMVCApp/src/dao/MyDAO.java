package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import bean.EmployeeBean;
import bean.LoginBean;
import db.DBConnect;

public class MyDAO {

	
	public int checkLogin(String uid,String pwd)
	{
		 int x=0;
		 SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		Session ss=sf.openSession();
		Criteria ct=ss.createCriteria(LoginBean.class);
		//select * from Login
		ct.add(Restrictions.eq("uid", uid));
		ct.add(Restrictions.eq("password", pwd));
		//select * from Login where uid=? and password=?
		List list=ct.list();
		if(!list.isEmpty())
			x=1;
		ss.close();		
		 
		/* try {
				DBConnect d=new DBConnect();	
			   Connection con= d.start();
		PreparedStatement ps=con.prepareStatement("select * from Login where uid=? and password=?");
		ps.setString(1,uid);
		ps.setString(2,pwd);
		     ResultSet rs=ps.executeQuery();
		     if(rs.next())
		        x=1;
		   con.close();		
				}catch( SQLException e)
				{
					System.out.println(e);
				}*/
			 return x;
	}
	
	public int insertEmp(EmployeeBean e)
	{
		int x=0;
SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
	Session ss=sf.openSession();
	Transaction tt=ss.beginTransaction();

//DML= Insert/Update/Delete
	   Object o=ss.save(e); //ss.update(e);ss.delete(e);
	    if(o!=null)
	    	x=1;
	   tt.commit();
	   ss.close();
/*		try {
			DBConnect d=new DBConnect();	
			   Connection con= d.start();
	PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?)");
	ps.setInt(1,e.getEid());
	ps.setString(2,e.getEname());
	ps.setDouble(3,e.getSalary());
	ps.setString(4,e.getCity());
	ps.setString(5,e.getAddress());
	 x= ps.executeUpdate();
	     con.close();		
			}catch(SQLException ex)
			{
				System.out.println(ex);
			}
	*/
		return x;
	}
	
	public ArrayList<EmployeeBean> viewAllEmp()
	{
		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		Session ss=sf.openSession();
		
		Criteria ct=ss.createCriteria(EmployeeBean.class);
		ArrayList<EmployeeBean> list=(ArrayList<EmployeeBean>)ct.list();
		
		ss.close();	
		
		
	/*	ArrayList<EmployeeBean> list=new ArrayList<>();
		try {
			DBConnect d=new DBConnect();	
			Connection con= d.start();
			PreparedStatement ps=con.prepareStatement("select * from Employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmployeeBean e=new EmployeeBean();
				e.setEid(rs.getInt("eid"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getDouble("salary"));
				e.setCity(rs.getString("city"));
				e.setAddress(rs.getString("address"));
				System.out.println(e);//e.toString()
				list.add(e);
			}
			con.close();		
					}catch( SQLException e)
					{
						System.out.println(e);
					}*/
	return list;				
	}
	
	
	 public int deleteEmployee(int eid)
	  {
		  
		 int x=0;
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
			Session ss=sf.openSession();
			Transaction tt=ss.beginTransaction();
	//	String sql="delete from Employee where eid=?";
		String hql="delete from EmployeeBean where eid=:empid";
		Query q=ss.createQuery(hql);
		q.setInteger("empid" ,eid);
		x=q.executeUpdate();
			tt.commit();
			ss.close();	 
		/*	try {
				DBConnect d=new DBConnect();	
				   Connection con= d.start();
		PreparedStatement ps=con.prepareStatement("delete from employee where eid=?");
		ps.setInt(1,eid);
		 x= ps.executeUpdate();
		     con.close();		
				}catch(SQLException ex)
				{
					System.out.println(ex);
				}
			*/
		 return x;
		  
	  }
	 
	 public EmployeeBean getEmployeeByEmpID(int eid)
	 {
		 //EmployeeBean e=new EmployeeBean();
		// try {
			 
				SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
				Session ss=sf.openSession();
				EmployeeBean e=(EmployeeBean) ss.get(EmployeeBean.class, eid);
				ss.close();	 	 
			 
		 
			/*	DBConnect d=new DBConnect();	
				Connection con= d.start();
				PreparedStatement ps=con.prepareStatement("select * from Employee where eid=?");
				ps.setInt(1, eid);	
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					
					e.setEid(rs.getInt("eid"));
					e.setEname(rs.getString("ename"));
					e.setSalary(rs.getDouble("salary"));
					e.setCity(rs.getString("city"));
					e.setAddress(rs.getString("address"));
					System.out.println(e);//e.toString()
					
				}
				con.close();		
						}catch( SQLException ex)
						{
							System.out.println(ex);
						}
		*/	 
		 return e;
		 
	 }

	public int updateEmp(EmployeeBean e) {
		int x=0;
		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		Session ss=sf.openSession();
		Transaction tt=ss.beginTransaction();

	//DML= Insert/Update/Delete
		   ss.update(e); //ss.save(e);ss.delete(e);
		   x=1;
		   tt.commit();
		   ss.close();
		/*try {
			DBConnect d=new DBConnect();	
			   Connection con= d.start();
	PreparedStatement ps=con.prepareStatement("update Employee set ename=?,salary=?,city=?,address=? where eid=?");
	ps.setInt(5,e.getEid());
	ps.setString(1,e.getEname());
	ps.setDouble(2,e.getSalary());
	ps.setString(3,e.getCity());
	ps.setString(4,e.getAddress());
	 x= ps.executeUpdate();
	     con.close();		
			}catch(SQLException ex)
			{
				System.out.println(ex);
			}*/
		return x;
	}
	 
	public int checkEidExists(int eid)
	{
		int x=0;
		 try {
				DBConnect d=new DBConnect();	
				Connection con= d.start();
				PreparedStatement ps=con.prepareStatement("select * from Employee where eid=?");
				ps.setInt(1, eid);	
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
			      x=1;
				}
				con.close();		
						}catch( SQLException ex)
						{
							System.out.println(ex);
						}
		return x;
	}
	 
	public static void main(String[] args) {
		System.out.println(new MyDAO().checkEidExists(7698698));
	}
	 
	
	
	
	
}
