<%--
  Created by IntelliJ IDEA.
  User: okw
  Date: 2018/4/14 0014
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<title>编辑产品</title>

<div>
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_product_list?cid=${product.category.id}">${product.category.name}</a></li>
        <li class="active">${product.name}</li>
        <li class="active">编辑产品</li>
    </ol>

    <div class="panel panel-warning">
        <div class="panel-heading">编辑产品</div>
        <div class="panel-body">
            <form action="admin_product_update" method="post" id="editForm">
                <table>
                    <tr>
                        <td>产品名称</td>
                        <td><input type="text" class="form-control" value="${product.name}" id="name" name="name"></td>
                    </tr>
                    <tr>
                        <td>产品小标题</td>
                        <td><input type="text" class="form-control" value="${product.subTitle}" id="subTitle" name="subTitle"></td>
                    </tr>
                    <tr>
                        <td>原价格</td>
                        <td><input type="text" class="form-control" value="${product.originalPrice}" id="originalPrice" name="originalPrice"></td>
                    </tr>
                    <tr>
                        <td>优惠价格</td>
                        <td><input type="text" class="form-control" value="${product.promotePrice}" id="promotePrice" name="promotePrice"></td>
                    </tr>
                    <tr>
                        <td>库存</td>
                        <td><input type="text" class="form-control" value="${product.stock}" id="stock" name="sotck"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${product.id}">
                            <input type="hidden" name="cid" value="${product.category.id}">
                            <button type="submit" class="btn btn-success">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

