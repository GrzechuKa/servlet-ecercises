package pl.sdacademy.registration;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserProfileController" , value = "/userProfile")
public class UserProfileController extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("userId"));

        UserDTO userById = userService.getUserById(id);

        request.setAttribute("userProfile", userById);

        request.getRequestDispatcher("WEB-INF/userProfile.jsp").forward(request, response);

    }
}
