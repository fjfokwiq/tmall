<%--
  Created by IntelliJ IDEA.
  User: okw
  Date: 2018/4/12 0012
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>

<title>属性编辑</title>

<div>
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="#">${propertity.category.name}</a></li>
        <li>编辑属性</li>
    </ol>
    <div>
        <div class="panel panel-warning">
            <div class="panel-heading">编辑属性</div>
            <div class="panel-body">
                <form method="post" id="editForm" action="admin_property_update">
                    <table class="editTable">
                        <tr>
                            <td>属性名称</td>
                            <td><input type="text" id="name" name="name" class="form-control" value="${propertity.name}"> </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="hidden" name="id" value="${propertity.id}">
                                <input type="hidden" name="cid" value="${propertity.category.id}">
                                <button type="submit" class="btn btn-success">提交</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
