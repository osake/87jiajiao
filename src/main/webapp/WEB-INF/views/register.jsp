<div xmlns:spring="http://www.springframework.org/tags" 
	xmlns:util="urn:jsptagdir:/WEB-INF/tags/util" 
	xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html;charset=UTF-8" />
	<hr/>
	<h3>快速注册</h3>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<label for="username">账号：</label><input id="username" name="username" type="text"/>
		<br/>
		<label for="password">密码：</label><input id="password" name="password" type="text"/>
		<br/>	
		<input type="submit" value="注册"/><input type="reset" value="清空"/>
	</form>
</div>