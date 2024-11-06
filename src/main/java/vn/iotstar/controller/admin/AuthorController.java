package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.entity.Author;
import vn.iotstar.Services.IAuthorService;
import vn.iotstar.Services.impl.AuthorServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/authors", "/admin/author/insert", "/admin/author/add", "/admin/author/update",
		"/admin/author/delete", "/admin/author/search" })
public class AuthorController extends HttpServlet {
	public IAuthorService authorservice = new AuthorServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		 if (url.contains("authors")) {
		 List<Author> list = authorservice.findAll();
		 req.setAttribute("listauthor", list);
			req.getRequestDispatcher("/views/admin/author-list.jsp").forward(req, resp);
		} else if (url.contains("insert") || url.contains("add")) {
			req.getRequestDispatcher("/views/admin/author-add.jsp").forward(req, resp);
		} else if (url.contains("update") || url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Author author = authorservice.findById(id);
			req.setAttribute("author", author);
			req.getRequestDispatcher("/views/admin/author-update.jsp").forward(req, resp);
		} else if (url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println(id);
			try {
				authorservice.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/authors");
		 }
		
		  else if (url.contains("search")) { 
			  String name = req.getParameter("name");
		  
			  List<Author> searchResults=null; 
			  try { 
				  searchResults = authorservice.findByName(name); 
			  } 
			  catch (Exception e) { 
			   e.printStackTrace(); 
			  } // Thực hiện tìm kiếm
			  req.setAttribute("listauthor1", searchResults);
			  req.getRequestDispatcher("/views/admin/author-search.jsp").forward(req,
			  resp); // Chuyển tiếp để hiển thị kết quả tìm kiếm 
		  }
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/admin/author/update")) {
			int id = Integer.parseInt(req.getParameter("author_id"));
			String name = req.getParameter("author_name");
			String dayString = req.getParameter("date_of_birth");
			java.util.Date dayUtil = null;
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày theo yêu cầu
				dayUtil = formatter.parse(dayString);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Chuyển đổi từ java.util.Date sang java.sql.Date
			java.sql.Date day = (dayUtil != null) ? new java.sql.Date(dayUtil.getTime()) : null;

			Author author = new Author();
			author.setAuthor_id(id);
			author.setAuthor_name(name);
			author.setDate_of_birth(day);

			authorservice.update(author);
			resp.sendRedirect(req.getContextPath() + "/admin/authors");
		} else if (url.contains("/admin/author/insert")) {
			Author author = new Author();
			String name = req.getParameter("author_name");
			String dayString = req.getParameter("date_of_birth");
			java.util.Date dayUtil = null;
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày theo yêu cầu
				dayUtil = formatter.parse(dayString);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Chuyển đổi từ java.util.Date sang java.sql.Date
			java.sql.Date day = (dayUtil != null) ? new java.sql.Date(dayUtil.getTime()) : null;

			author.setAuthor_name(name);
			author.setDate_of_birth(day);
			authorservice.insert(author);
			resp.sendRedirect(req.getContextPath() + "/admin/authors");
		} else if (url.contains("/admin/author/search")) {
			String name = req.getParameter("name");
			List<Author> searchResults = null;
			try {
				searchResults = authorservice.findByName(name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Thực hiện tìm kiếm
			req.setAttribute("listauthor1", searchResults);
			System.out.println(searchResults);

			resp.sendRedirect(req.getContextPath() + "/admin/author/search");
		} else if (url.contains("/searchpaginated")) {

		    // Lấy tham số từ request
		    String name = req.getParameter("name"); // Lấy tham số "name"
		    String pageParam = req.getParameter("page"); // Lấy tham số "page"
		    String sizeParam = req.getParameter("size"); // Lấy tham số "size"

		    // Chuyển đổi các tham số sang Integer với Optional và xử lý lỗi
		    Optional<Integer> page = Optional.empty();
		    Optional<Integer> size = Optional.empty();
		    try {
		        page = Optional.ofNullable(pageParam).map(Integer::parseInt);
		        size = Optional.ofNullable(sizeParam).map(Integer::parseInt);
		    } catch (NumberFormatException e) {
		        // Log lỗi và thiết lập giá trị mặc định nếu cần
		        e.printStackTrace();
		    }

		    Long count = authorservice.count(); // Giả sử bạn có phương thức này trong service

		    // Lấy thông tin trang và kích thước trang
		    int currentPage = page.orElse(1); // Mặc định là 1
		    int pageSize = size.orElse(6); // Mặc định là 6

		    Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("name")); // Sắp xếp theo tên tác giả
		    Page<Author> resultPage;

		    if (name != null && !name.trim().isEmpty()) {
		        resultPage = authorservice.findByNameContaining(name, pageable);
		        req.setAttribute("name", name); // Lưu trữ tên để hiển thị lại
		    } else {
		        resultPage = authorservice.findAll(pageable); // Lấy tất cả nếu không có tìm kiếm
		    }

		    int totalPages = resultPage.getTotalPages();
		    List<Integer> pageNumbers = new ArrayList<>();

		    if (totalPages > 0) {
		        int start = Math.max(1, currentPage - 2);
		        int end = Math.min(currentPage + 2, totalPages);

		        // Điều chỉnh số trang khi số trang hiện tại nhỏ hơn hoặc bằng tổng số trang
		        if (totalPages > 5) { // 5 là số lượng trang muốn hiển thị tối đa
		            if (end == totalPages) {
		                start = end - 4;
		            } else if (start == 1) {
		                end = start + 4;
		            }
		        }

		        pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
		    }

		    // Đặt thuộc tính cho JSP
		    req.setAttribute("pageNumbers", pageNumbers);
		    req.setAttribute("authorPage", resultPage);

		    // Chuyển tiếp tới JSP
		    req.getRequestDispatcher("/views/admin/author-search.jsp").forward(req, resp);
		}

	}
}
