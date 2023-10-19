<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>WebThuongMaiDienTu</title>

    <link href="<c:url value="https://fonts.googleapis.com/css?family=PT+Serif:400,400i,700,700ii%7CRoboto:300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic"/>"
          rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/ion.rangeSlider.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/ion.rangeSlider.skinFlat.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/jquery.bxslider.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/jquery.fancybox.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/flexslider.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/swiper.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/media.css"/>">
    <script src="<c:url value="/js/ion.rangeSlider.min.js"/>"></script>
    <script src="<c:url value="/js/chosen.jquery.min.js"/>"></script>
    <script src="<c:url value="/js/gmap.js"/>"></script>
    <script src="<c:url value="/js/jquery-1.11.2.min.js"/>"></script>
    <script src="<c:url value="/js/jQuery.Brazzers-Carousel.js"/>"></script>
</head>

<body>
<!-- Header - start -->
<jsp:include page="../header.jsp"/>

<!-- Main Content - start -->
<main>
    <section class="container stylization maincont">


        <ul class="b-crumbs">
            <li>
                <a>
                    Home
                </a>
            </li>
            <li>
                <span>Cart</span>
            </li>
        </ul>
        <h1 class="main-ttl"><span>Cart</span></h1>
        <!-- Cart Items - start -->
        <form action="#">

            <div class="cart-items-wrap">
                <table class="cart-items">
                    <thead>
                    <tr>
                        <td class="cart-image">&nbsp;</td>
                        <td class="cart-ttl">Sản phẩm</td>
                        <td class="cart-price">Giá</td>
                        <td class="cart-quantity">Số lượng</td>
                        <td class="cart-summ">Thành tiền</td>
                        <td class="cart-del">&nbsp;</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${carts}">
                    <tr>
                        <td class="cart-image">
                            <a>
                                <img src="img/<c:out value="${item.image}"/>">
                            </a>
                        </td>
                        <td class="cart-ttl">
                            <a><c:out value="${item.productName}"/></a>
                        </td>
                        <td class="cart-price">
                            <b><c:out value="${item.amount}"/></b>
                        </td>
                        <td class="cart-quantity">
                            <p class="cart-qnt">
                                <input value="<c:out value="${item.quantity}"/>" type="text">
                                <a href="cart-plus?id=<c:out value="${item.productID}"/>" class="cart-plus"><i class="fa fa-angle-up"></i></a>
                                <a href="cart-sub?id=<c:out value="${item.productID}"/>" class="cart-minus"><i class="fa fa-angle-down"></i></a>
                            </p>
                        </td>
                        <td class="cart-summ">
                            <b><c:out value="${item.quantity * item.amount}"/></b>
                        </td>
                        <td class="cart-del">
                            <a href="/cart-delete?id=<c:out value="${item.productID}"/>" class="cart-remove"></a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
<%--            <ul class="cart-total">--%>
<%--                <li class="cart-summ">Tổng : <b>20,469,000 đ</b></li>--%>
<%--            </ul>--%>
            <div class="cart-submit">
                <div class="cart-coupon">
                </div>
                <a href="/payment" class="cart-submit-btn">Thanh toán</a>
                <a href="/cart-all-delete" class="cart-clear">Clear cart</a>
            </div>
        </form>
        <!-- Cart Items - end -->

    </section>
</main>
<!-- Main Content - end -->




<jsp:include page="../footer.jsp"/>

<!-- jQuery plugins/scripts - start -->
<script src="<c:url value="/js/jquery-1.11.2.min.js"/>"></script>
<script src="<c:url value="/js/jquery.bxslider.min.js"/>"></script>
<script src="<c:url value="/js/fancybox/fancybox.js"/>"></script>
<script src="<c:url value="/js/fancybox/helpers/jquery.fancybox-thumbs.js"/>"></script>
<script src="<c:url value="/js/jquery.flexslider-min.js"/>"></script>
<script src="<c:url value="/js/swiper.jquery.min.js"/>"></script>
<script src="<c:url value="/js/jquery.waypoints.min.js"/>"></script>
<script src="<c:url value="/js/progressbar.min.js"/>"></script>
<script src="<c:url value="/js/ion.rangeSlider.min.js"/>"></script>
<script src="<c:url value="/js/chosen.jquery.min.js"/>"></script>
<script src="<c:url value="/js/jQuery.Brazzers-Carousel.js"/>"></script>
<script src="<c:url value="/js/plugins.js"/>"></script>
<script src="<c:url value="/js/main.js"/>"></script>
<script src="<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyDhAYvx0GmLyN5hlf6Uv_e9pPvUT3YpozE"/>"></script>
<script src="<c:url value="/js/gmap.js"/>"></script>
<!-- jQuery plugins/scripts - end -->

</body>
</html>