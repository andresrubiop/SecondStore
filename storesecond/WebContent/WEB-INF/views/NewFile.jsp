<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

<form action="/login" method="post">
<input type="text" name="username" />
<input type="text" name="password" />
<input type="submit" value="fuck it" />
</form>

<c:forEach var="brand" items="${brands}">
<c:out value="{brand.idBrand}"/>
<c:out value="{brand.nameBrand}"/>

</c:forEach>
</body>
</html>