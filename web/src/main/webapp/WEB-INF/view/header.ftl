<#import "/spring.ftl"as spring>

<header>
    <div class="uui-header navigation-header">
        <nav>
            <!--Responsive html-layout-->
            <div class="uui-responsive-header">
                <div class="responsive-header">
                    <div class="responsive-toggle-box">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <div class="responsive-hide-menu">
                        <span></span>
                        <span></span>
                    </div>
                    <a href="#" class="responsive-brand-logo">
                        <span class="arrow fa fa-angle-left"></span>
                        <span class="logo">
                            <img src="/images/ic_logo_UUi.svg" alt=""/>
                        </span>
                        <span class="title">TRAVEL AGENCY</span>
                    </a>
                </div>
                <div class="responsive-menu">
                    <div class="menu-wrapper">
                        <div class="menu-scroll">
                            <ul class="nav navbar-nav">
                                <li><a href="#"><span><@spring.message "label.tours"/></span></a></li>
                                <li><a href="#"><span><@spring.message "label.reviews"/></span></a></li>
                                <li><a href="#"><span><@spring.message "label.hotels"/></span></a></li>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!---->
            <a href="#" class="brand-logo">
                <span class="logo">
                    <img src="/resources/uui/images/ic_logo_UUi.svg" alt=""/>
                </span>
                Travel Agency
            </a>
            <ul class="uui-navigation nav navbar-nav">
                <li><a href="/tours"><@spring.message "label.tours"/></a></li>
                <li><a href="#"><@spring.message "label.reviews"/></a></li>
                <li><a href="/hotels"><@spring.message "label.hotels"/></a></li>
            </ul>
                    <#if user??&&user.role.name()=="MEMBER">
                            <ul class="uui-header-tools nav navbar-nav">
                                <li class="dropdown uui-profile-menu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <div class="profile-photo">
                                            <img src="/resources/uui/images/icons/no_photo.png" alt=""/>
                                        </div>
                                    </a>
                                    <div class="dropdown-menu" role="menu">
                                        <span class="menu-arrow"></span>
                                        <ul class="profile-links">
                                            <li><a href="#"><@spring.message "label.mytours"/></a></li>
                                            <li><a href="#"><@spring.message "label.myreviwes"/></a></li>
                                            <li><a href="#"><@spring.message "label.myprofile"/></a></li>
                                            <li class="logout"><a href="#"><i class="fa fa-sign-out"></i><@spring.message "label.signout"/></a></li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                    <#else>
                    <ul class="uui-header-tools nav navbar-nav">
                        <li class="uui-header-button">
                        <li><a  href="/go_to_sign_in"><@spring.message "label.signin"/>
                        </a></li>
                        <li><a href="/go_to_sign_up"><@spring.message "label.signup"/>
                        </a></li>
                        </li>
                    </ul>
                    </#if>


        </nav>
    </div>
</header>
