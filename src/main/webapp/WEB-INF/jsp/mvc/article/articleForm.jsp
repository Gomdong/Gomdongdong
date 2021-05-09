<%@ page import="java.util.Optional" %>
<%@ page import="kr.mjc.dong.web.dao.User" %>
<!DOCTYPE html>
<% User user = (User) session.getAttribute("USER"); %>
<% if (user == null)
  response.sendRedirect(request.getContextPath()+"/model2/user/loginForm?msg= Do login");
%>

<html>
<body>
<h3>게시글 작성</h3>
<form action="addArticle" method="post">
  <p><input type="Text" name="Title" placeholder="제목" required autofocus/></p>
  <p><input type="Text" name="Content" placeholder="내용" required/></p>
  <p>
    <button type="submit">작성</button>
  </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>


</html>
