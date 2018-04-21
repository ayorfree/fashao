package fashao.servlet;

import fashao.bean.ProductImage;
import fashao.bean.Property;
import fashao.dao.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fashao.util.Page;

public abstract class BaseBackServlet extends HttpServlet {

    public abstract String add(HttpServletRequest request, HttpServletResponse response, Page page);
    public abstract String delete(HttpServletRequest request, HttpServletResponse response, Page page);
    public abstract String edit(HttpServletRequest request, HttpServletResponse response, Page page);
    public abstract String update(HttpServletRequest request, HttpServletResponse response, Page page);
    public abstract String list(HttpServletRequest request, HttpServletResponse response, Page page);

    protected CategoryDAO categoryDAO = new CategoryDAO();
    protected OrderDAO orderDAO = new OrderDAO();
    protected ProductDAO productDAO = new ProductDAO();
    protected ProductImageDAO productImageDAO = new ProductImageDAO();
    protected PropertyDAO propertyDAO = new PropertyDAO();
    protected PropertyValueDAO propertyValueDAO = new PropertyValueDAO();
    protected OrderItemDAO orderItemDAO = new OrderItemDAO();
    protected UserDAO userDAO = new UserDAO();
    protected ReviewDAO reviewDAO = new ReviewDAO();

    public void service(HttpServletRequest request, HttpServletResponse response) {

        try {
            int start = 0;
            int count = 5;
            try {
                start = Integer.parseInt(request.getParameter("page.start"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                count = Integer.parseInt(request.getParameter("page.count"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Page page = new Page(start, count);

            String method = (String) request.getAttribute("method");
            Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
                    javax.servlet.http.HttpServletResponse.class, Page.class);
            String redirect = m.invoke(this, request, response, page).toString();

            if (redirect.startsWith("@"))
                response.sendRedirect(redirect.substring(1));
            else if (redirect.startsWith("%"))
                response.getWriter().print(redirect.substring(1));
            else
                request.getRequestDispatcher(redirect).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
        InputStream is = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            factory.setSizeThreshold(1024 * 10240);

            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    is = item.getInputStream();
                } else {
                    String paramName = item.getFieldName();
                    String paramValue = item.getString();
                    paramValue = new String(paramValue.getBytes("ISO-8859-1"),
                            "utf-8");
                    params.put(paramName, paramValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }
}