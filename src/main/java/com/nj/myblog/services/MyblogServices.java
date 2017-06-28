package com.nj.myblog.services;
import java.util.List;

import com.nj.myblog.dao.MyblogDAO;
import com.nj.myblog.entities.Comment;
import com.nj.myblog.entities.Post;
import com.nj.myblog.entities.Role;
import com.nj.myblog.entities.User;

public class MyblogServices 
{
	MyblogDAO myblogDAO = new MyblogDAO();
	
	public List<User> getAllUsers()
	{
		return myblogDAO.getAllUsers();
	}
	
	public User login(String email, String password)
	{
		return myblogDAO.login(email, password);
	}
	
	List<User> getExistingUser(String email)
	{
		return myblogDAO.getExistingUser(email);
	}
	
	public User getUserById(int id)
	{
		return myblogDAO.getUserById(id);
	}
	
	public User createUser(User user)
	{
		return myblogDAO.createUser(user);
	}
	public User updateUser(User user) 
	{
		return myblogDAO.updateUser(user);
	}
	public void deleteUser(int userId) 
	{
		myblogDAO.deleteUser(userId);
	}
	public List<Role> getAllRoles() 
	{
		return myblogDAO.getAllRoles();
	}
	public List<Post> getAllPost()
	{
		return myblogDAO.getAllPost();
	}
	public List<Post> getPostByUserId(int userId)
	{
		return myblogDAO.getPostByUserId(userId);
	}
	public Post getPostById(int postId)
	{
		return myblogDAO.getPostById(postId);
	}
	public Post createPost(Post post)
	{
		return myblogDAO.createPost(post);
	}
	public Post updatePost(Post post) 
	{
		return myblogDAO.updatePost(post);
	}
	public void deletePost(int postId) 
	{
		myblogDAO.deletePost(postId);
	}
	public Comment getCommentById(int commentId)
	{
		return myblogDAO.getCommentById(commentId);
	}
	public Comment createComment(int postId,Comment comment)
	{
		return myblogDAO.createComment(postId,comment);
	}
	public Comment updateComment(Comment comment)
	{
		return myblogDAO.updateComment(comment);
	}
	public void deleteComment(int commentId)
	{
		myblogDAO.deleteComment(commentId);
	}
	
}
