package vn.iotstar.controller;

import java.io.IOException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.configs.JpaConfig;
import vn.iotstar.entity.User;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		// Kiểm tra xem người dùng đã đăng nhập chưa
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Cấu hình mã hóa UTF-8
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lấy các tham số từ request
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			req.setAttribute("alert", "Tài khoản hoặc mật khẩu không được rỗng");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		User user = login(username, password);

		// Kiểm tra kết quả đăng nhập
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			req.setAttribute("alert", "Tài khoản hoặc mật khẩu không đúng");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

	public User login(String username, String password) {
		User user = this.findByUserName(username);
		if (user != null && password== user.getPasswd()) { // Kiểm tra mã hóa mật khẩu
			return user;
		}
		return null;
	}

	public User findByUserName(String username) {
		EntityManager em = JpaConfig.getEntityManager();
		try {
			return em.createQuery("SELECT u FROM User u WHERE u.email = :username", User.class)
					.setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			return null; // Không tìm thấy người dùng
		} catch (Exception e) {
			e.printStackTrace(); // Xem xét sử dụng logging
			return null;
		} finally {
			em.close(); // Đảm bảo đóng EntityManager
		}
	}
}
