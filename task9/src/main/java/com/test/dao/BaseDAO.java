package com.test.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(BaseDAO.class);
	private static BaseDAO instance=null;
	public BaseDAO(){
		instance=this;
	}
	protected void initDao() {
		// do nothing
	}
	/**
	 * 插入新实例
	 * @param transientInstance
	 */
	public void save(Object transientInstance) {
		log.debug("saving "+transientInstance.getClass().getName()+" instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/**
	 * 删除一实例
	 * @param persistentInstance
	 */
	public void delete(Object persistentInstance) {
		log.debug("saving "+persistentInstance.getClass().getName()+" instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	/**
	 * 通过主键查询，得到唯一实例
	 * @param type
	 * @param id
	 * @return
	 */
	public Object findById(Class type, java.lang.Integer id) {
		log.debug("getting "+type.getName()+" instance with id: " + id);
		try {
			Object instance = getHibernateTemplate().get(
					type.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/**
	 * 查找typ类型所有实例
	 * @param type
	 * @return
	 */
	public List findAll(Class type) {
		log.debug("finding all "+type.getName()+ " instances");
		try {
			String queryString = "from "+type.getName();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 更新实例，保证实例中id为已有
	 * @param detachedInstance
	 * @return
	 */
	public Object merge(Object detachedInstance) {
		log.debug("saving "+detachedInstance.getClass().getName()+" instance");
		try {
			Object result = getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	/*

	public List findByExample(BaseEntity instance) {
		log.debug("finding BaseEntity instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BaseEntity instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BaseEntity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}





	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}*/

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
}
