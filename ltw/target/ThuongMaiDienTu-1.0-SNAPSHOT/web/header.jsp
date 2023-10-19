<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>



<div class="header">
    <!-- Logo, Shop-menu - start -->
    <div class="header-middle">
        <div class="container header-middle-cont">
            <div class="toplogo">
                <a href="index.jsp">
                    <img src="img/logo.png">
                </a>
            </div>
            <div class="shop-menu">
                <ul>
                    <li class="topsearch">
                        <a id="topsearch-btn" class="topsearch-btn" href="#"><i class="fa fa-search"></i></a>
                        <form class="topsearch-form" action="#">
                            <input type="text" placeholder="Search products">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </li>
                    <li class="topauth">
                        <a href="../login.html">
                            <i class="fa fa-lock"></i>
                            <span class="shop-menu-ttl">Đăng kí</span>
                        </a>
                        <a href="../login.html">
                            <span class="shop-menu-ttl">Đăng nhập</span>
                        </a>
                    </li>

                    <li>
                        <div class="h-cart">
                            <a href="cart.html">
                                <i class="fa fa-shopping-cart"></i>
                                <span class="shop-menu-ttl">Giỏ hàng</span> (
                                <b>0</b>)
                            </a>
                        </div>
                    </li>

                </ul>
            </div>
        </div>
    </div>
    <!-- Logo, Shop-menu - end -->

    <!-- Topmenu - start -->
    <div class="header-bottom">
        <div class="container">
            <nav class="topmenu">

                <!-- Catalog menu - start -->
                <div class="topcatalog">
                    <a class="topcatalog-btn" href="#">Danh mục SP</a>
                    <ul class="topcatalog-list">
                        <li>
                            <a href="LapTop.html">
                                Laptop
                            </a>
                            <i class="fa fa-angle-right"></i>
                            <ul>
                                <li>
                                    <a href="LapTopAcer.html">
                                        Acer
                                    </a>
                                </li>
                                <li>
                                    <a href="LapTopasus.html">
                                        Asus
                                    </a>
                                </li>
                                <li>
                                    <a href="LapTopMsi.html">
                                        Msi
                                    </a>
                                </li>
                                <li>
                                    <a href="LapTopDell.html">
                                        Dell
                                    </a>
                                </li>
                                <li>
                                    <a href="LapTopLenovo.html">
                                        Lenovo
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="PCGaming.html">
                                PC-Gaming
                            </a>
                            <i class="fa fa-angle-right"></i>
                            <ul>
                                <li>
                                    <a href="PCGamingTamTrung.html">
                                        PC Gaming Tầm Trung
                                    </a>
                                </li>
                                <li>
                                    <a href="PCGamingCaoCap.html">
                                        PC Gaming Cao Cấp
                                    </a>
                                </li>
                                <li>
                                    <a href="PCGamingSieuCaoCap.html">
                                        PC Gaming Siêu Cao Cấp
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="PCWorkStation.html">
                                PC-Workstation
                            </a>
                            <i class="fa fa-angle-right"></i>
                            <ul>
                                <li>
                                    <a href="PCWorkIntel.html">
                                        PC Workstation Intel Xeon
                                    </a>
                                </li>
                                <li>
                                    <a href="PCworkrezy.html">
                                        PC Workstation Ryzen
                                    </a>
                                </li>

                            </ul>
                        </li>
                        <li>
                            <a href="linhkien.html">
                                Linh Kiện
                            </a>
                            <i class="fa fa-angle-right"></i>
                            <ul>
                                <li>
                                    <a href="CPU.html">
                                        CPU
                                    </a>

                                </li>
                                <li>
                                    <a href="RAM.html">
                                        RAM
                                    </a>

                                </li>

                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- Catalog menu - end -->

                <!-- Main menu - start -->
                <button type="button" class="mainmenu-btn">Service</button>

                <ul class="mainmenu">
                    <li>
                        <a href="index.jsp" class="active">
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
                                <a href="contacts.html">
                                    Contacts
                                </a>
                            </li>
                            <li>
                                <a href="404.html">
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