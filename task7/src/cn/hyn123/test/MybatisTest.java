package cn.hyn123.test;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.hyn123.dao.UserDao;
import cn.hyn123.entities.User;

/** 
* @author alin 
* @version 2017年6月14日
* 类说明 
*/
public class MybatisTest {
	 private static SqlSessionFactory sqlSessionFactory;
	    private static Reader reader;
	    private static SqlSession session;

	    @Before
	    public void before() {
	        try {
	        	 URL url = getClass().getClassLoader().getResource("");
	             String strURL = url.toString();
	             if(strURL.indexOf("file:")>=0){
	                 strURL = strURL.substring(6);
	             }
	             String[] tempstr = strURL.split("/");
	             strURL = "";
	             for(int i=0; i<tempstr.length; i++){
	                 strURL += tempstr[i] + "/";
	                 if(tempstr[i].toLowerCase().equals("classes")){
	                     break;
	                 }
	             }
			String base = System.getProperty("user.dir");
			System.out.println(base + strURL);
			
			//通过配置文件获取数据库链接信息
			reader = Resources.getResourceAsReader("spring/spring-dao.xml");
			 //通过配置文件构建一个SQLSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println(sqlSessionFactory);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }catch (Exception e) {
				e.printStackTrace();
			}
	    }

	    @Test
	    public void test() {
	    	//通过SQLSessionFactory打开一个数据库会话
	    	try {
	    		session = sqlSessionFactory.openSession();
	    		System.out.println(session);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	/*对给定的映射语句，使用一个正确描述参数与返回值的接口 (如
	    	BlogMapper.class)，您就能更清晰地执行类型安全的代码，从而避免错误和异常*/
	    	UserDao userDao = session.getMapper(UserDao.class); 
	    	User user = new User();
	    	user.setUserName("test");
	    	user.setPassWord("test");
	    	try {
				userDao.insertUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	        User user = (User) session.selectOne(
//	                "cn.hyn123.dao.UserDao.findUserById", 1);
	        System.out.println(user.getId());
	        System.out.println(user.getUserName());
	    }

	    @After
	    public void after() {
	        try {
	            reader.close();
	            session.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
