<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>


<title>用户管理</title>


<div>
    <h1 class="label label-primary">用户管理</h1>
    <br>
    <br>

    <div>
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
            <tr class="success">
                <td>ID</td>
                <td>用户名称</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>