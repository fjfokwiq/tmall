<%--
  Created by IntelliJ IDEA.
  User: okw
  Date: 2018/4/7 0007
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<title>编辑分类</title>

<script>
    $(function () {
        $("#editForm").submit(function () {
            if (!checkEmpty("categoryName", "分类名称"))
                return false
            return true;
        });
    });
</script>
<div>
    <div>
        <ol class="breadcrumb">
            <li><a href="admin_category_list">所有分类</a></li>
            <li class="active">编辑分类</li>
        </ol>
    </div>
    <div class="panel panel-warning">
        <div class="panel-heading">编辑分类</div>
        <div class="panel-body">
            <form action="admin_category_update" method="post" id="editForm" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>分类名称</td>
                            <td><input type="text" id="name" name="name" class="form-control" value="${category.name}"></td>
                    </tr>
                    <tr>
                        <td>分类图片</td>
                        <td><input type="file" id="categoryPic" name="categoryImage" class="form-control" accept="image/*"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${category.id}">
                            <button type="submit" class="btn btn-success">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

    </div>
</div>