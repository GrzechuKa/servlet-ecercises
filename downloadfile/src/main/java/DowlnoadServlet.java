import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;


@WebServlet(name = "DowlnoadServlet", value = "/download")
public class DowlnoadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"/download\">\n" +
                "    <p>Select file to download</p>\n" +
                "    <input type=\"text\" name=\"fileToDownload\">\n" +
                "    <input type=\"submit\" value=\"Download\"></input>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileToDownload = request.getParameter("fileToDownload");
        if (StringUtils.isBlank(fileToDownload)) {
            response.getWriter().println("<html>" +
                    "<body>" +
                    "<p>Brak nazwy pliku</p>" +
                    "<a href =\"/download\">Back</a>" +
                    "</body>" +
                    "<html>"
            );
        }
        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/" + fileToDownload);

        if (inputStream == null) {
            response.getWriter().println("File not available for download: " + fileToDownload);
            return;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileToDownload + "\"");

        ServletOutputStream responseOutputStream = response.getOutputStream();

        byte[] buffer = new byte [8 * 1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1){
            responseOutputStream.write(buffer, 0, bytesRead);
        }

        responseOutputStream.flush();
        responseOutputStream.close();


    }
}
