package pl.sdacademy.registration;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/newUser")
public class RegisterController extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("user", new UserDTO());
        request.getRequestDispatcher("WEB-INF/userCreate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String houseNo = request.getParameter("houseNo");

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(city);
        addressDTO.setStreet(street);
        addressDTO.setHouseNo(houseNo);

        userDTO.setAddress(addressDTO);

        userService.saveUser(userDTO);

        request.getRequestDispatcher("WEB-INF/userSaved.jsp").forward(request, response);
    }

}
