<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<!-- <script type="text/javascript">
	$(function(){
		$
	});
</script> -->

<script type="text/javascript">
    function reflesh(){
        $("#box").attr("src","list.jsp")
    }
    setTimeout("reflesh()",10000);
</script>
</head>
<body>
 <table border="1">
  <div id="box">
        <tbody>
        	<tr>
        		<td><a href="add.jsp">添加</a></td>
        	</tr>
         
            <tr>
			   <th>id</th>
               <th>name</th>
               <th>pwd</th>
               <th>操作</th>
             </tr>
            <%-- <c:if test="${!empty list }"> --%>
                <c:forEach items="${list}" var="user">
                  <tr>
						<td>${user.id }</td>
                        <td>${user.userName }</td>
                        <td>${user.password }</td> 
                        <td><a href="delete.do?id=${user.id}">删除</a>
                        	<a href="edit.do?id=${user.id }">修改</a>
                    </tr>                
                </c:forEach>
             
            <%-- </c:if> --%>
         </tbody>
         
<iframe allowtransparency="true" id="iframeReload" name="jc" id="jc" src="list.jsp" style="display:none;"></iframe>
      </div>
    </table>

 
</body>
</html>