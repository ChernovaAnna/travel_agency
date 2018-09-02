<#import "/spring.ftl"as spring>
<!-- Modal -->
<div class="modal uui-modal fade" id="signin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><@spring.message "label.signing"/></h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span></span><span></span>
                </button>
            </div>
            <form class="form-signin" action="/sign_in" method="post">
                <div class="modal-body">

                    <input type="text" id="signinLogin" name="login" class="form-control"
                           placeholder="<@spring.message 'label.login'/>"
                           required autofocus style="margin-top: 20px;margin-bottom: 20px">


                    <input type="password" id="signinPassword" name="password" class="form-control"
                           placeholder="<@spring.message 'label.password'/>"
                           required style="margin-top: 20px;margin-bottom: 20px">
                    <div class="checkbox">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="uui-button lime-green"><@spring.message 'label.signin'/></button>
                </div>
            </form>
        </div>

    </div>
</div>

<div class="modal uui-modal fade" id="signup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Modal Tittle</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span></span><span></span>
                </button>
            </div>
            <div class="modal-body">
                Modal content
            </div>
            <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="uui-button transparent">Cancel</button>
                <button type="button" class="uui-button lime-green">Save changes</button>
            </div>
        </div>
    </div>
</div>