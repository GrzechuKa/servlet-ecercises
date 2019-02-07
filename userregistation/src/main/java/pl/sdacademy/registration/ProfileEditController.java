package pl.sdacademy.registration;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfileEditController", value = "/userProfileEdit")
public class ProfileEditController extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long userId = Long.parseLong(request.getParameter("userId"));
        UserDTO userById = userService.getUserById(userId);
        request.setAttribute("userProfile", userById);
        request.getRequestDispatcher("WEB-INF/user.jsp").forward(request, response);

    }
}
