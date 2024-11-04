package vn.iotstar.controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.Services.IUserService;
import vn.iotstar.Services.impl.UserService;
import vn.iotstar.entity.User;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 507572562622801492L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
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
     

        // Kiểm tra tài khoản và mật khẩu không được để trống
        if (username.isEmpty() || password.isEmpty()) {
            req.setAttribute("alert", "Tài khoản hoặc mật khẩu không được rỗng");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }
     // Gọi dịch vụ người dùng để xác thực
        IUserService service = new UserService();
        User user = service.login(username, password);

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
}