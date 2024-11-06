package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.Services.IBookService;
import vn.iotstar.Services.impl.BookService;
import vn.iotstar.entity.Book;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/books", "/admin/book/details"})
public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IBookService sv = new BookService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		 if (url.contains("books")) {
		 List<Book> list = sv.findAll();
		 req.setAttribute("listbook", list);
			req.getRequestDispatcher("/views/admin/book-list.jsp").forward(req, resp);
		} 
		 else if (url.contains("details"))
		 { List<Book> list = sv.findAll();
		 req.setAttribute("listbook", list);
			req.getRequestDispatcher("/views/admin/detail-book.jsp").forward(req, resp);
			 
		 }
	}
}