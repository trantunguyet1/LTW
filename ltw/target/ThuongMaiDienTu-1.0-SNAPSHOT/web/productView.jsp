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
    <section class="container">


        <ul class="b-crumbs">
            <li>
                <a>
                    Doanh mục SP
                </a>
            </li>
            <li>
                <a>
                    ${category.categoryName}
                </a>
            </li>
        </ul>
        <!-- Catalog Sidebar - start -->
        <div class="section-sb">

            <!-- Catalog Categories - start -->
            <div class="section-sb-current">
                <h3><a>
                    ${category.categoryName}
                    <span id="section-sb-toggle"
                          class="section-sb-toggle">
                        <span
                                class="section-sb-ico"></span></span></a></h3>
                <ul class="section-sb-list" id="section-sb-list">
                    <c:forEach var="item" items="${model}">
                        <li class="categ-1">
                            <a href="/search-model?id=<c:out value="${item.id}"/>">
                                <span class="categ-1-label"><c:out value="${item.name}"/></span>
                            </a>
                        </li>
                    </c:forEach>
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
            <div class="section-top">

                <!-- View Mode -->

                <!-- Sorting -->

                <!-- Count per page -->

            </div>
            <!-- Catalog Topbar - end -->
            <div class="prod-items section-items">
                <c:forEach var="item" items="${products}">
                    <div class="prod-i">
                        <div class="prod-i-top">
                            <a class="prod-i-img"><!-- NO SPACE --><img src="img\<c:out value="${item.image}"/>" alt="Adipisci aperiam commodi"><!-- NO SPACE --></a>
                            <!--<p class="prod-i-info">
                                a href="#" class="qview-btn prod-i-qview"><span>Xem nhanh  </span><i class="fa fa-search"></i></a>
                            </p>-->
                            <a href="cart-add?id=<c:out value="${item.id}"/>" class="prod-i-buy">Thêm vào giỏ</a>
                            <p class="prod-i-properties-label"><i class="fa fa-info"></i></p>

                            <div class="prod-i-properties">
                                <dl>
                                    <c:out value="${item.description}"/>
                                </dl>
                            </div>
                        </div>
                        <h3>
                            <a href="detail?id=<c:out value="${item.id}"/>"><c:out value="${item.name}"/></a>
                        </h3>
                        <p class="prod-i-price">
                            <c:if test="${item.discount != null}">
                                <b><c:out value="${item.discount}"/>VND</b>
                                <del><c:out value="${item.price}"/>VND</del>
                            </c:if>
                            <c:if test="${item.discount == null}">
                                <b><c:out value="${item.price}"/>VND</b>
                            </c:if>
                        </p>
                    </div>
                </c:forEach>

            </div>

            <!-- Pagination - start --
            -- Pagination - end -->
        </div>
        <!-- Catalog Items | Gallery V1 - end -->

        <!-- Quick View Product - start -->
        <!-- Quick View Product - end -->
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