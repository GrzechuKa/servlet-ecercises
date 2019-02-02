package article;

import article.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "ArticleController", value = "/articles")
public class ArticleController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Article> products = new ArticleService().getAvailableArticles();

        String collect = products.stream()
                .map(article -> "<option value=" + article.getId() + ">" + article.getName() +  "</option>\n")
                .collect(Collectors.joining());

        response.getWriter().println("<!DOCTYPE html>\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Basket</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<form method=\"post\" action=\"articles\">\n" +
                        "    <label for=\"articleID\">article.Article</label>\n" +
                        "    <select name=\"articleID\">\n" +
                        collect +
                        "    </select>\n" +
                        "    <label for=\"quantity\"> Quantity</label>\n" +
                        "    <input type=number name=quantity id=quantity min=1 >\n" +
                        "    <input type=\"submit\" value=\"Add\">\n" +
                        "</form>\n" +
                        "<a href = \"basket\"> Go to basket</a>\n" +
                        "</body>\n" +
                        "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long articleId = Long.parseLong(request.getParameter("articleID"));
        BigDecimal quantity = new BigDecimal(request.getParameter("quantity"));

        HttpSession session = request.getSession();
        Map<Long, BigDecimal> basket = (Map<Long, BigDecimal>) session.getAttribute("basket");
        if (basket == null){
            basket = new HashMap<>();
            basket.put(articleId, quantity);
        }else{
            basket.compute(articleId, (k,v) -> (v == null) ? quantity : v.add(quantity));
        }
        session.setAttribute("basket", basket);

        response.sendRedirect("/articles");

    }
}
