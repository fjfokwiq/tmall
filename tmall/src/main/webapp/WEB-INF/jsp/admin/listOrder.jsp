<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeader.jsp" %>

<%@include file="../include/admin/adminNavigator.jsp" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>订单管理</title>

<div>

    <h1 class="label label-primary">订单管理</h1>
    <br>
    <br>

    <div>
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead class="text-success">
            <tr>
                <th>ID</th>
                <th>状态</th>
                <th>金额</th>
                <th>商品数量</th>
                <th>买家名称</th>
                <th>创建时间</th>
                <th>支付时间</th>
                <th>发货时间</th>
                <th>确认收货时间</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${orderList}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.orderStart}</td>
                    <td>￥<fmt:formatNumber type="number" value="${order.total}" minFractionDigits="2"/></td>
                    <td align="center">${order.totalNumber}</td>
                    <td align="center">${order.user.name}</td>

                    <td><fmt:formatDate value="${order.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${order.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${order.deliveryDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><fmt:formatDate value="${order.confirmDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

                    <td>
                        <button class="btn btn-primary btn-xs">查看详情</button>

                        <c:if test="${order.status=='waitDelivery'}">
                            <a href="admin_order_delivery?id=${order.id}">
                                <button class="btn btn-primary btn-xs">发货</button>
                            </a>
                        </c:if>
                    </td>
                </tr>
                <tr class="orderPageOrderItemTR">
                    <td colspan="10" align="center">

                        <div  class="orderPageOrderItem">
                            <table width="800px" align="center" class="orderPageOrderItemTable">
                                <c:forEach items="${order.orderItems}" var="orderItem">
                                    <tr>
                                        <td align="left">
                                            <img width="40px" height="40px" src="../../../img/productSingle/629.jpg">
                                        </td>

                                        <td>
                                            <a href="foreproduct?pid=${orderItem.product.id}">
                                                <span>${orderItem.product.name}</span>
                                            </a>
                                        </td>
                                        <td align="right">

                                            <span class="text-muted">${orderItem.number}个</span>
                                        </td>
                                        <td align="right">

                                            <span class="text-muted">单价：￥${orderItem.product.promotePrice}</span>
                                        </td>

                                    </tr>
                                </c:forEach>

                            </table>
                        </div>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>