<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>


<main>
    <section class="container">


        <!-- Slider -->
        <div class="fr-slider-wrap">
            <div class="fr-slider">
                <ul class="slides">
                    <li>
                        <img src="img/banner/tulanh.jpg" alt="">

                    </li>
                    <li>
                        <img src="img/banner/dieuhoa.png" alt="">

                    </li>
                    <li>
                        <img src="img/banner/tivi.png" alt="">

                    </li>
                    <li>
                        <img src="img/banner/maygiat.jpg" alt="">

                    </li>
                    <li>
                        <img src="img/banner/all.png" alt="">

                    </li>

                </ul>
            </div>
        </div>

        <!-- Popular Products -->
        <c:if test="${isNew == true}">
            <div class="fr-pop-wrap">
                <ul class="fr-pop-tabs sections-show">
                    <li><h4 class="active">sản phẩm mới nhất </h4></li>
                    <li><a>Xem thêm >></a></li>
                </ul>

                <!-- Catalog Topbar - end -->

                <div class="prod-items section-items">
                    <c:forEach var="item" items="${listBestNew}">
                        <div class="prod-i">
                            <div class="prod-i-top">
                                <a class="prod-i-img"><!-- NO SPACE -->
                                    <img src="img\product\<c:out value="${item.image}"/>"><!-- NO SPACE --></a>

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
                                <b><c:out value="${item.price}"/>VND</b>
                            </p>
                        </div>
                    </c:forEach>
                </div>
                <!-- .fr-pop-tab-cont -->
            </div>
        </c:if>


        <!-- Popular Products -->
        <c:if test="${isDiscount == true}">
            <div class="fr-pop-wrap">
                <ul class="fr-pop-tabs sections-show">
                    <li><h4 class="active">sản phẩm khuyến mãi</h4></li>
                    <li><a>Xem thêm >></a></li>
                </ul>

                <!-- Catalog Topbar - end -->

                <div class="prod-items section-items">
                    <c:forEach var="item" items="${listPromotions}">
                        <div class="prod-i">
                            <div class="prod-i-top">
                                <a class="prod-i-img"><!-- NO SPACE --><img
                                        src="img\<c:out value="${item.image}"/>"
                                ><!-- NO SPACE --></a>

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
                                <b><c:out value="${item.discount}"/>VND</b>
                                <del><c:out value="${item.price}"/>VND</del>
                            </p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>


        <!-- Popular Products -->
        <c:if test="${isSeller == true}">
            <div class="fr-pop-wrap">
                <ul class="fr-pop-tabs sections-show">
                    <li><h4 class="active">sản phẩm bán chạy</h4></li>
                    <li><a>Xem thêm >></a></li>
                </ul>

                <!-- Catalog Topbar - end -->
                <div class="prod-items section-items">
                    <c:forEach var="item" items="${listTopSeller}">
                        <div class="prod-i">
                            <div class="prod-i-top">
                                <a class="prod-i-img"><!-- NO SPACE -->
                                    <img src="img\<c:out value="${item.image}"/>"><!-- NO SPACE --></a>
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
            </div>
        </c:if>

        <!-- Subscribe Form -->
        <div class="newsletter">
            <h2>Mua hàng với nhiều ưu đãi hơn</h2>
            <p>Đăng ký với chúng tôi để nhận được thông báo!</p>
            <form action="#">
                <input placeholder="Your e-mail" type="text">
                <input name="OK" value="Subscribe" type="submit">
            </form>
        </div>

        <!-- Quick View Product - start -->
        <div class="qview-modal">
            <div class="prod-wrap">
                <a href="#">
                    <h1 class="main-ttl">
                        <span>Reprehenderit adipisci</span>
                    </h1>
                </a>
                <div class="prod-slider-wrap">
                    <div class="prod-slider">
                        <ul class="prod-slider-car">
                            <li>
                                <a data-fancybox-group="popup-product" class="fancy-img"
                                   href="http://placehold.it/500x525">
                                    <img src="http://placehold.it/500x525" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-fancybox-group="popup-product" class="fancy-img"
                                   href="http://placehold.it/500x591">
                                    <img src="img/PCWork/PC9.PNG" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-fancybox-group="popup-product" class="fancy-img"
                                   href="http://placehold.it/500x525">
                                    <img src="http://placehold.it/500x525" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-fancybox-group="popup-product" class="fancy-img"
                                   href="http://placehold.it/500x722">
                                    <img src="http://placehold.it/500x722" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-fancybox-group="popup-product" class="fancy-img"
                                   href="http://placehold.it/500x722">
                                    <img src="http://placehold.it/500x722" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-fancybox-group="popup-product" class="fancy-img"
                                   href="http://placehold.it/500x722">
                                    <img src="http://placehold.it/500x722" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-fancybox-group="popup-product" class="fancy-img"
                                   href="http://placehold.it/500x722">
                                    <img src="http://placehold.it/500x722" alt="">
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="prod-thumbs">
                        <ul class="prod-thumbs-car">
                            <li>
                                <a data-slide-index="0" href="#">
                                    <img src="http://placehold.it/500x525" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-slide-index="1" href="#">
                                    <img src="http://placehold.it/500x591" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-slide-index="2" href="#">
                                    <img src="http://placehold.it/500x525" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-slide-index="3" href="#">
                                    <img src="http://placehold.it/500x722" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-slide-index="4" href="#">
                                    <img src="http://placehold.it/500x722" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-slide-index="5" href="#">
                                    <img src="http://placehold.it/500x722" alt="">
                                </a>
                            </li>
                            <li>
                                <a data-slide-index="6" href="#">
                                    <img src="http://placehold.it/500x722" alt="">
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="prod-cont">
                    <p class="prod-actions">
                        <a href="#" class="prod-favorites"><i class="fa fa-heart"></i> Add to Wishlist</a>
                        <a href="#" class="prod-compare"><i class="fa fa-bar-chart"></i> Compare</a>
                    </p>
                    <div class="prod-skuwrap">
                        <p class="prod-skuttl">Color</p>
                        <ul class="prod-skucolor">
                            <li class="active">
                                <img src="img/color/blue.jpg" alt="">
                            </li>
                            <li>
                                <img src="img/color/red.jpg" alt="">
                            </li>
                            <li>
                                <img src="img/color/green.jpg" alt="">
                            </li>
                            <li>
                                <img src="img/color/yellow.jpg" alt="">
                            </li>
                            <li>
                                <img src="img/color/purple.jpg" alt="">
                            </li>
                        </ul>
                        <p class="prod-skuttl">Sizes</p>
                        <div class="offer-props-select">
                            <p>XL</p>
                            <ul>
                                <li><a href="#">XS</a></li>
                                <li><a href="#">S</a></li>
                                <li><a href="#">M</a></li>
                                <li class="active"><a href="#">XL</a></li>
                                <li><a href="#">L</a></li>
                                <li><a href="#">4XL</a></li>
                                <li><a href="#">XXL</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="prod-info">
                        <p class="prod-price">
                            <b class="item_current_price">$238</b>
                        </p>
                        <p class="prod-qnt">
                            <input type="text" value="1">
                            <a href="#" class="prod-plus"><i class="fa fa-angle-up"></i></a>
                            <a href="#" class="prod-minus"><i class="fa fa-angle-down"></i></a>
                        </p>
                        <p class="prod-addwrap">
                            <a href="#" class="prod-add">Add to cart</a>
                        </p>
                    </div>
                    <ul class="prod-i-props">
                        <li>
                            <b>SKU</b> 05464207
                        </li>
                        <li>
                            <b>Manufacturer</b> Mayoral
                        </li>
                        <li>
                            <b>Material</b> Cotton
                        </li>
                        <li>
                            <b>Pattern Type</b> Print
                        </li>
                        <li>
                            <b>Wash</b> Colored
                        </li>
                        <li>
                            <b>Style</b> Cute
                        </li>
                        <li>
                            <b>Color</b> Blue, Red
                        </li>
                        <li><a href="#" class="prod-showprops">All Features</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Quick View Product - end -->
    </section>
</main>
<!-- Main Content - end -->