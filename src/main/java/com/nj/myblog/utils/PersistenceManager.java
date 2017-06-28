/**
 * 
 */
package com.nj.myblog.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Siva
 *
 */
public class PersistenceManager 
{
	private static final EntityManagerFactory emFactory;
	private PersistenceManager()
	{
		
	}
	static
	{
		emFactory = Persistence.createEntityManagerFactory("myblog");
	}
	public static EntityManager getEntityManager()
	{
		return emFactory.createEntityManager();
	}
	public static void close()
	{
		emFactory.close();
	}
}
