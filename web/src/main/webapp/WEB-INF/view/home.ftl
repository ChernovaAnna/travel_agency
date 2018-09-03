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
<div class="content">
    <div id="slider-wrap">
        <div id="slider">
            <div class="internal">
                <div class="slide"><img src="/resources/image/back.jpg" alt="Third Image"></div>
            </div>
        </div>
    </div>
</div>
</body>
<#include "footer.ftl">
</html>