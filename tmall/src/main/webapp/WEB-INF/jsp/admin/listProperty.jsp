<%--
  Created by IntelliJ IDEA.
  User: okw
  Date: 2018/4/11 0011
  Time: 6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>

<title>属性管理</title>

<div>
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_property_list?cid=${category.id}">${category.name}</a></li>
        <li class="active">属性管理</li>
    </ol>

    <div>
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead class="success">
            <tr>
                <th>属性id</th>
                <th>属性名称</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${properties}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td><a href="admin_property_edit?id=${p.id}" class="glyphicon glyphicon-edit"></a></td>
                    <td><a href="admin_property_delete?id=${p.id}" class="glyphicon glyphicon-trash"></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增属性</div>
        <div class="panel-body">
            <form id="#form" action="admin_property_add">
                <table class="addTable">
                    <tr>
                        <td>属性名称</td>
                        <td><input type="text" class="form-control" id="name" name="name"> </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="hidden" name="cid" value="${category.id}">
                            <button type="submit" class="btn btn-success">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>
