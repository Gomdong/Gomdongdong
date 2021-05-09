<%@ page import="kr.mjc.dong.web.dao.User" %>
<%@ page import="kr.mjc.dong.web.dao.Article" %>
<!DOCTYPE html>
<% Article article = (Article) request.getAttribute("article"); %>
<html>
<body>
<h3>게시글 상세보기</h3>
<p><%= article %>
</p>

<% User user = (User) session.getAttribute("USER"); %>
<% if (user != null)%>
<p>
    <button type="submit">수정</button>
<a href="/mvc/article/updateArticle"></a>

</p>
<p>
    <button type="delete">삭제</button>
</p>
</body>
</html>
