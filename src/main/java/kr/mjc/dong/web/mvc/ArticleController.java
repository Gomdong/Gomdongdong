package kr.mjc.dong.web.mvc;

import kr.mjc.dong.web.dao.Article;
import kr.mjc.dong.web.dao.ArticleDao;
import kr.mjc.dong.web.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class ArticleController {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void articleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleList", articleDao.listArticles(0, 100));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }

    public void articleInfo(HttpServletRequest request, HttpServletResponse response, int articleId)
            throws ServletException, IOException {
        request.setAttribute("article", articleDao.getArticle(articleId));
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleInfo.jsp")
                .forward(request, response);
    }

    public void articleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleForm.jsp")
                .forward(request, response);
    }

    public void addArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Article article = new Article();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");

        int userId = user.getUserId();
        String name = user.getName();

        article.setTitle(request.getParameter("Title"));
        article.setContent(request.getParameter("Content"));

        article.setName(name);
        article.setUserId(userId);

        articleDao.addArticle(article);
        response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");

    }
    public void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Article article = new Article();

        article.setTitle(request.getParameter("Title"));
        article.setContent(request.getParameter("Content"));

        int updatedRows = articleDao.updateArticle(article);
        if (updatedRows > 0) {
            response.sendRedirect(request.getContextPath() + "/mvc/article/updateArticle");
        } else {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleForm?msg=Wrong ");
        }
    }
}




