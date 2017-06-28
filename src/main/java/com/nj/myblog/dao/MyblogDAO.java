package com.nj.myblog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import com.nj.myblog.entities.Comment;
import com.nj.myblog.entities.Post;
import com.nj.myblog.entities.Role;
import com.nj.myblog.entities.User;
import com.nj.myblog.utils.PersistenceManager;

public class MyblogDAO {

	public List<User> getAllUsers() {
		EntityManager em = PersistenceManager.getEntityManager();
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	public User login(String email, String password) {
		
		User user=null;
		try
		{
			EntityManager em = PersistenceManager.getEntityManager();
			
			user = em.createQuery("select u from User u where u.email=:email AND u.password=:password", User.class)
					.setParameter("email", email).setParameter("password", password).getSingleResult();
		}
		catch (NoResultException nre) {
			 // Code for handling NoResultException
			 } catch (NonUniqueResultException nure) {
			 // Code for handling NonUniqueResultException
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(user != null)
			return user;
		else
			return null;
	}

	public List<User> getExistingUser(String email) {
		EntityManager em = PersistenceManager.getEntityManager();
		return em.createQuery("select u from  u where u.email=:email", User.class).setParameter("email", email)
				.getResultList();
	}
	
	public User getUserById(int id)
	{
		EntityManager em = PersistenceManager.getEntityManager();
		return em.find(User.class, id);
	}

	public User createUser(User user) {
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User updateUser(User user) 
	{
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();
			User savedUser = em.find(User.class, user.getId());
			savedUser.setName(user.getName());
			savedUser.setPassword(user.getPassword());
			savedUser.setRole(user.getRole());
			savedUser.setActive(user.isActive());
			em.merge(savedUser);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void deleteUser(int userId) 
	{
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();
			User deleteUser = em.find(User.class, userId);
			deleteUser.setActive(false);
			em.merge(deleteUser);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Role> getAllRoles() {
		EntityManager em = PersistenceManager.getEntityManager();
		List<Role> roles = em.createQuery("select r from Role r", Role.class).getResultList();
		return roles;
	}
	
	public List<Post> getAllPost() {
		EntityManager em = PersistenceManager.getEntityManager();
		return em.createQuery("select p from Post p", Post.class).getResultList();
	}
	
	public List<Post> getPostByUserId(int userId)
	{
		List<Post> post = null;
		EntityManager em = PersistenceManager.getEntityManager();		
		post = em.createQuery("select p from Post p where p.createdBy =:userId",Post.class).setParameter("userId", userId).getResultList();
		return post;
	}
	
	public Post getPostById(int postId)
	{
		EntityManager em = PersistenceManager.getEntityManager();		
		Post post = (Post) em.createQuery("select p from Post p where p.id =:postId",Post.class).setParameter("postId", postId).getSingleResult();
		return post;
	}
	
	public Post createPost(Post post) {
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();		
			em.merge(post);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	
	public Post updatePost(Post post) 
	{
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();
			Post savedPost = em.find(Post.class, post.getId());
			savedPost.setTitle(post.getTitle());
			savedPost.setContent(post.getContent());
			em.merge(savedPost);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	
	public void deletePost(int postId) 
	{
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();
			Post deletePost = em.find(Post.class, postId);
			em.remove(deletePost);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Comment getCommentById(int commentId)
	{
		EntityManager em = PersistenceManager.getEntityManager();		
		Comment comment = (Comment) em.createQuery("select c from Comment c where c.id =:commentId",Comment.class).setParameter("commentId", commentId).getSingleResult();
		return comment;
	}
	public Comment createComment(int postId,Comment comment) {
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();
			Post post= em.find(Post.class,postId);
			post.getComments().add(comment);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	}

	public Comment updateComment(Comment comment) 
	{
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();
			Comment savedComment = em.find(Comment.class, comment.getId());
			savedComment.setContent(comment.getContent());
			em.merge(savedComment);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	}
	
	public void deleteComment(int commentId) 
	{
		try {
			EntityManager em = PersistenceManager.getEntityManager();
			em.getTransaction().begin();
			Comment deleteComment = em.find(Comment.class, commentId);
			em.remove(deleteComment);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
