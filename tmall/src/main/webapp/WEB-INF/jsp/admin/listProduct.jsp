<%--
  Created by IntelliJ IDEA.
  User: okw
  Date: 2018/4/13 0013
  Time: 23:13
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>

<title>产品列表</title>
<div>
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="#">${category.name}</a></li>
        <li>编辑产品</li>
    </ol>

    <div>
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead class="success">
            <tr>
                <th>ID</th>
                <th>图片</th>
                <th>产品名称</th>
                <th>产品小标题</th>
                <th>原价格</th>
                <th>优惠价格</th>
                <th>库存数量</th>
                <th>图片管理</th>
                <th>设置属性</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td></td>
                    <td>${product.name}</td>
                    <td>${product.subTitle}</td>
                    <td>${product.originalPrice}</td>
                    <td>${product.promotePrice}</td>
                    <td>${product.stock}</td>
                    <td><a href="admin_productImage_list?pid=${product.id}" class="glyphicon glyphicon-picture"></a></td>
                    <td><a href="admin_propertyValue_edit?pid=${product.id}" class="glyphicon glyphicon-th-list"></a></td>
                    <td><a href="admin_product_edit?id=${product.id}" class="glyphicon glyphicon-edit"></a></td>
                    <td><a href="admin_product_delete?id=${product.id}" class="glyphicon glyphicon-trash"></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">
            <div class="panel-body">
                <form action="admin_product_add" id="addForm" method="post">
                    <table>
                        <tr>
                            <td>产品名称</td>
                            <td><input type="text" class="form-control" id="name" name="name"></td>
                        </tr>
                        <tr>
                            <td>产品小标题</td>
                            <td><input type="text" class="form-control" id="subTitle" name="subTitle"></td>
                        </tr>
                        <tr>
                            <td>原价格</td>
                            <td><input type="text" class="form-control" id="originalPrice" name="originalPrice"></td>
                        </tr>
                        <tr>
                            <td>优惠价格</td>
                            <td><input type="text" class="form-control" id="promotePrice" name="promotePrice"></td>
                        </tr>
                        <tr>
                            <td>库存</td>
                            <td><input type="text" class="form-control" id="stock" name="stock"></td>
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
</div>


