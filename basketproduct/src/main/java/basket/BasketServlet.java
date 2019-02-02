package basket;


import article.Article;
import article.ArticleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "Basket", value = "/basket")
public class BasketServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Map<Long, BigDecimal> basket = (Map<Long, BigDecimal>) request.getSession(false).getAttribute("basket");


        PrintWriter writer = response.getWriter();


        writer.println("<html>" +
                "<body>" +
                "<p> Basket content>" +
                "<table>" +
                "<tr>" +
                "<th> Article name </th>" +
                "<th>Quantity" +
                "</tr>" +


                "<body>"
                + "</html>");


    }

    //dopisac tworzenie htmla lini do tablicy z artykulami
//    private String getArticleHTML(Map<Long, BigDecimal> basket){
//
//        return basket.entrySet().stream()
//                .map(x -> "<tr><th>" + ArticleService.fi + "</tr><tr>" +  "<th>")
//                .collect(Collectors.joining());
//    }



}
