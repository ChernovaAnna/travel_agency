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
<div class="content" style="background-image: url('/resources/image/back.jpg');height: 100%">
    <div class="modal-dialog" style="    width: 700px;
    padding-top: 160px;
    margin: auto;">
        <div class="modal-content">
            <div class="modal-body">
            ${error.code}
            </div>
        </div>

    </div>

<#--<div class="modal uui-modal fade" id="signin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"-->
<#--aria-hidden="true">-->
<#--<div class="modal-dialog">-->
<#--<div class="modal-content">-->
<#--<div class="modal-header">-->
<#--<h4 class="modal-title"><@spring.message "label.signing"/></h4>-->
<#--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">-->
<#--<span></span><span></span>-->
<#--</button>-->
<#--</div>-->
<#--<form class="form-signin" action="/sign_in" method="post">-->
<#--<div class="modal-body">-->

<#--<input type="text" id="signinLogin" name="login" class="form-control"-->
<#--placeholder="<@spring.message 'label.login'/>"-->
<#--required autofocus style="margin-top: 20px;margin-bottom: 20px">-->


<#--<input type="password" id="signinPassword" name="password" class="form-control"-->
<#--placeholder="<@spring.message 'label.password'/>"-->
<#--required style="margin-top: 20px;margin-bottom: 20px">-->
<#--<div class="checkbox">-->
<#--</div>-->
<#--</div>-->
<#--<div class="modal-footer">-->
<#--<button type="submit" class="uui-button lime-green"><@spring.message 'label.signin'/></button>-->
<#--</div>-->
<#--</form>-->
<#--</div>-->

<#--</div>-->

<#--</div>-->
</div>
</body>
<#include "footer.ftl">
</html>