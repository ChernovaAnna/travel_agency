<#import "/spring.ftl" as spring/>
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
<#include "header.ftl">
<body>
<div class="uui-main-container">
            <#if tourList??>
                <#list tourList as tour>
    <section class="uui-animated-image-panel" style="margin: 10px;min-height: 350px;    width: 48%;
    display: inline-block;">
        <a href="#">
            <span class="animated-panel-image"><img src="https://unsplash.it/2000/1250?image=675"
                                                    alt="Third Image"></span>
            <span class="animated-panel-footer"
                  style="height: 160px;"><@spring.message "label.date"/>:${tour.date}  <@spring.message "label.duration"/>:${tour.duration}<br>
                <@spring.message "label.cost"/>:${tour.cost}<br>
               <@spring.message "label.country"/>:${tour.country.name}  <@spring.message "label.hotel"/>:${tour.hotel.name}<br>
            <@spring.message "label.type"/>:${tour.tourType}</span>
            <form action="/${tour.id}" method="get">
                <button type="submit" class="uui-button lime-green" style="    position: relative;
    margin-left: 80%;
    margin-top: 32%;"><@spring.message 'label.reviews'/></button>
            </form>
            <button type="submit" class="uui-button lime-green" style="    position: relative;
    margin-left: 80%;
    margin-top:5%;"><@spring.message 'label.hotel'/></button>

        </a>
    </section>
                </#list>
            </#if>
</div>
</body>
<#include "footer.ftl">
</html>
