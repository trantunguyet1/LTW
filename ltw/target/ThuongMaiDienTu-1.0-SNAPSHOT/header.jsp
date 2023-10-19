<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>


<div>
    <!-- Logo, Shop-menu - start -->
    <c:if test="${isShow == true}">
        <div class="header-middle">
            <div class="container header-middle-cont">
                <div class="toplogo">
                    <a href="web/index.jsp">
                        <img src="img/logo.png">
                    </a>
                </div>
                <div class="shop-menu">
                    <ul>
                        <li class="topsearch">
                            <a id="topsearch-btn" class="topsearch-btn" href="#"><i class="fa fa-search"></i></a>
                            <form class="topsearch-form" action="search">
                                <input type="text" placeholder="Search products" name="textSearch">
                                <button type="submit"><i class="fa fa-search"></i></button>
                            </form>
                        </li>
                        <li class="topauth">
                            <a href="/register">
                                <i class="fa fa-lock"></i>
                                <span class="shop-menu-ttl">Đăng kí</span>
                            </a>
                            <a href="/login">
                                <span class="shop-menu-ttl">Đăng nhập</span>
                            </a>
                        </li>

                        <li>
                            <div class="h-cart">
                                <a href="/cart">
                                    <i class="fa fa-shopping-cart"></i>
                                    <span class="shop-menu-ttl">Giỏ hàng</span>
                                </a>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </c:if>
    <!-- Logo, Shop-menu - end -->

    <!-- Topmenu - start -->
    <div class="header-bottom">
        <div class="container">
            <nav class="topmenu">

                <!-- Catalog menu - start -->
                <div class="topcatalog">
                    <a class="topcatalog-btn" href="#">Danh mục SP</a>
                    <ul class="topcatalog-list">
                        <c:forEach var="item" items="${categories}">
                            <li>
                                <a>
                                    <c:out value="${item.categoryName}"/>
                                </a>
                                <i class="fa fa-angle-right"></i>
                                <ul>
                                    <c:forEach var="model" items="${models}">
                                        <c:if test="${item.id == model.categoryID}">
                                            <li>
                                                <a href="/search-model?id=<c:out value="${model.id}"/>">
                                                    <c:out value="${model.name}"/>
                                                </a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <!-- Catalog menu - end -->

                <!-- Main menu - start -->
                <button type="button" class="mainmenu-btn">Service</button>

                <ul class="mainmenu">
                    <li>
                        <a href="/home" class="active">
                            Trang Chủ
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            About Us
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            Chính sách bảo hành
                        </a>

                    </li>
                    <li>
                        <a href="#">
                            Chính sách trả góp
                        </a>
                    </li>
                    <li class="menu-item-has-children">
                        <a href="#">
                            Pages <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="sub-menu">
                            <li>
                                <a href="web/contacts.html">
                                    Contacts
                                </a>
                            </li>
                            <li>
                                <a href="web/404.html">
                                    Tin Công Nghệ
                                </a>
                            </li>
                            <li>
                                <a href="https://www.youtube.com/channel/UCdxRpD_T4-HzPsely-Fcezw">
                                    Youtube
                                </a>
                            </li>
                        </ul>
                    </li>

                </ul>
                <!-- Main menu - end -->

                <!-- Search - start -->

                <!-- Search - end -->

            </nav>
        </div>
    </div>
    <!-- Topmenu - end -->

</div>
<!-- Header - end -->