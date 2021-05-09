<%@ page import="java.util.List" %>
<%@ page import="kr.mjc.dong.web.dao.Article" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 목록</h3>
<%
  List<Article> articleList = (List<Article>) request.getAttribute("articleList");
  for (Article article : articleList) {%>
<p><a href="/mvc/article/articleInfo/<%= article.getArticleId()%>"><%= article %></a>
</p>
<%
  }
%>
</body>
</html>
