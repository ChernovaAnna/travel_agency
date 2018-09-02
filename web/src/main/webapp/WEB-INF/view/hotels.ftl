<#import "/spring.ftl" as spring/>
<#include "header.ftl">
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- jQuery Core -->
    <script src="/resources/uui/js/lib/jquery-1.12.0.min.js"></script>

    <!-- Bootstrap Core -->
    <link rel="stylesheet" href="/resources/uui/bootstrap/css/bootstrap.min.css"/>
    <script src="/resources/uui/bootstrap/js/bootstrap.min.js"></script>

    <!-- EPAM UUI JavaScript Core -->
    <script src="/resources/uui/js/uui-core.min.js" type="text/javascript"></script>

    <!-- EPAM UUI Styles Core -->
    <link rel="stylesheet" href="/resources/uui/css/uui-all.css"/>

    <!-- Scroll for UUI Sidebar -->
    <link rel="stylesheet" href="/resources/uui/css/lib/components/jquery.mCustomScrollbar.min.css"/>
    <script src="/resources/uui/js/lib/components/jquery.mCustomScrollbar.concat.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<#include "header.ftl">
<#include "footer.ftl">
<div class="uui-main-container">
            <#if hotelList??>
                <#list hotelList as hotel>
    <section class="uui-animated-image-panel" style="margin: 10px;min-height: 250px">
        <a href="#">
            <span class="animated-panel-image"><img src="https://unsplash.it/2000/1250?image=675"
                                                    alt="Third Image"></span>
            <span class="animated-panel-footer" style="height: 120px;"><@spring.message "label.name"/>:${hotel.name}<br>
                <@spring.message "label.website"/>:${hotel.website}<br>
            <@spring.message "label.features"/>: <#list hotel.feature as feature> feature.valueOf </#list><br>
</span>
        </a>
    </section>
                </#list>
            </#if>
</div>
</body>
</html>