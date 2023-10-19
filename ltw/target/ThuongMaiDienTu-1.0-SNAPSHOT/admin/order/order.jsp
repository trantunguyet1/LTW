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
<div class="header-bottom">
    <div class="container">
        <nav class="topmenu">
            <!-- Catalog menu - end -->

            <ul class="mainmenu" style="margin-left: 100px">
                <li>
                    <a href="/home" class="active">
                        Trang Chủ
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- Header - end -->


<!-- Main Content - start -->
<main>
    <section class="container">


        <ul class="b-crumbs">
            <li>
                <a>
                    Admin
                </a>
            </li>
            <li>
                <a>
                    Đơn hàng
                </a>
            </li>
        </ul>
        <!-- Catalog Sidebar - start -->
        <div class="section-sb">
            <h3><span id="section-sb-toggle" class="section-sb-toggle"><span class="section-sb-ico"></span></span></h3>
            <!-- Catalog Categories - start -->
            <div class="section-sb-current">
                <ul class="section-sb-list" id="section-sb-list">
                    <li class="categ-1">
                        <a href="/admin">
                            <span class="categ-1-label">Doanh thu</span>
                        </a>
                    </li>
                    <li class="categ-1">
                        <a href="/order">
                            <span class="categ-1-label">Quản lý đơn</span>
                        </a>
                    </li>
                    <li class="categ-1">
                        <a href="/user">
                            <span class="categ-1-label">Quản lý User</span>
                        </a>
                    </li>
                    <li class="categ-1">
                        <a href="/categories">
                            <span class="categ-1-label">Loại sản phẩm</span>
                        </a>
                    </li>
                    <li class="categ-1">
                        <a href="/product">
                            <span class="categ-1-label">Sản phẩm</span>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- Catalog Categories - end -->

            <!-- Filter - start -->

            <!-- Filter - end -->

        </div>
        <!-- Catalog Sidebar - end -->
        <!-- Catalog Items | Gallery V1 - start -->
        <div class="section-cont">

            <!-- Catalog Topbar - start -->
            <table class="table table-hover table-text-center">
                <thead class="thead-light">
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Tên KH</th>
                    <th scope="col">Tổng tiền</th>
                    <th scope="col">Ngày tạo đơn</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody id="content-table">
                <c:forEach var="item" items="${orders}" varStatus="loop">
                    <tr>
                        <td><c:out value='${loop.index + 1}'/></td>
                        <td><c:out value='${item.userName}'/></td>
                        <td><c:out value='${item.totalAmount}'/></td>
                        <td><c:out value='${item.orderDate}'/></td>
                        <td><a href="/order/edit?id=<c:out value='${item.id}'/>">Edit</a><span>/ </span>
                            <a href="/order/view?id=<c:out value='${item.userID}'/>">Xem chi tiết</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <!-- Pagination - end -->
        </div>
        <!-- Catalog Items | Gallery V1 - end -->

        <!-- Quick View Product - start -->
        <!-- Quick View Product - end -->
    </section>
</main>
<!-- Main Content - end -->

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