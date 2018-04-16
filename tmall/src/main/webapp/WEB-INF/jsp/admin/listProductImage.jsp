<%--
  Created by IntelliJ IDEA.
  User: okw
  Date: 2018/4/14 0014
  Time: 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<title>产品图片管理</title>

<div>
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_product_list?cid=${product.cid}">${product.category.name}</a></li>
        <li class="active">${product.name}</li>
        <li class="active">产品图片管理</li>
    </ol>
    <table class="addPictureTable" align="center">
        <tr>
            <td class="addPictureTableTD">
                <div>
                    <div class="panel panel-warning addPictureDiv">
                        <div class="panel-heading">新增产品<b class="text-primary"> 单个 </b>图片</div>
                        <div class="panel-body">
                            <form method="post" class="addFormSingle" action="admin_productImage_add" enctype="multipart/form-data">
                                <table class="addTable">
                                    <tr>
                                        <td>
                                            <input id="filepathSingle" type="file" name="image" />
                                        </td>
                                    </tr>
                                    <tr class="submitTR">
                                        <td align="center">
                                            <input type="hidden" name="type" value="type_single" />
                                            <input type="hidden" name="pid" value="${product.id}" />
                                            <button type="submit" class="btn btn-success">提 交</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover  table-condensed">
                        <thead>
                        <tr class="success">
                            <th>ID</th>
                            <th>产品单个图片缩略图</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productImageListSingle}" var="single">
                            <tr>
                                <td>${single.id}</td>
                                <td>
                                    <a title="点击查看原图" href="img/productSingle/${single.id}.jpg"><img height="50px" src="img/productSingle/${single.id}.jpg"></a>
                                </td>
                                <td><a
                                       href="admin_productImage_delete?id=${single.id}"><span
                                        class=" 	glyphicon glyphicon-trash"></span></a></td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </td>
            <td class="addPictureTableTD">
                <div>

                    <div class="panel panel-warning addPictureDiv">
                        <div class="panel-heading">新增产品<b class="text-primary"> 详情 </b>图片</div>
                        <div class="panel-body">
                            <form method="post" class="addFormDetail" action="admin_productImage_add" enctype="multipart/form-data">
                                <table class="addTable">
                                    <tr>
                                        <td>
                                            <input id="filepathDetail"  type="file" name="image" />
                                        </td>
                                    </tr>
                                    <tr class="submitTR">
                                        <td align="center">
                                            <input type="hidden" name="type" value="type_detail" />
                                            <input type="hidden" name="pid" value="${product.id}" />
                                            <button type="submit" class="btn btn-success">提 交</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                    <table class="table table-striped table-bordered table-hover  table-condensed">
                        <thead>
                        <tr class="success">
                            <th>ID</th>
                            <th>产品详情图片缩略图</th>
                            <th>删除</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${productImageListDetail}" var="detail">
                            <tr>
                                <td>${detail.id}</td>
                                <td>
                                    <a title="点击查看原图" href="img/productDetail/${detail.id}.jpg"><img height="50px" src="img/productDetail/${detail.id}.jpg"></a>
                                </td>
                                <td><a
                                       href="admin_productImage_delete?id=${detail.id}"><span
                                        class=" 	glyphicon glyphicon-trash"></span></a></td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </td>
        </tr>
    </table>

</div>

