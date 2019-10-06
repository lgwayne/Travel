package cn.wayne.travel.web.servlet;

import cn.wayne.travel.domain.Category;
import cn.wayne.travel.service.ICategoryService;
import cn.wayne.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "CategoryServlet", urlPatterns = "/category/*")
public class CategoryServlet extends BaseServlet {
    private ICategoryService service = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> cs = service.findAll();

        writeValue(response, cs);
    }
}
