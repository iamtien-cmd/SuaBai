package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Author;

import vn.iotstar.services.AuthorServicesImpl;
import vn.iotstar.services.IAuthorServices;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.microsoft.sqlserver.jdbc.StringUtils;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/authors", "/admin/author/add", "/admin/author/add",
		"/admin/author/edit", "/admin/author/delete", "/admin/home"})
public class AuthorController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public IAuthorServices authorservice = new AuthorServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if (url.contains("authors")) {
			List<Author> list = authorservice.findAll();
			req.setAttribute("listauthor", list);
			req.getRequestDispatcher("/views/admin/AuthorCRUD.jsp").forward(req, resp);
		} else if (url.contains("add")) {
			
			req.getRequestDispatcher("/views/admin/add.jsp").forward(req, resp);
		} else if (url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id")); 
			Author author = authorservice.findById(id);
			req.setAttribute("author", author);
			req.getRequestDispatcher("/views/admin/edit.jsp").forward(req, resp);
		} else if (url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("id")); 
			authorservice.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/authors");
		} 
	}
}
