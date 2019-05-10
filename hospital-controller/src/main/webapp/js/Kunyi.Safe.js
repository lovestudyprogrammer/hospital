$(function(){
    $("#BindPhoneFrom").Validform({
        tiptype:3,
        showAllError:true,
        postonce:true,
        ajaxPost:true,
        beforeSubmit:function(curform){
            $("#btnBindPhone").val("提交中...");
            $("#btnBindPhone").attr("disabled","disabled");
        },
        callback:function(data){
            $("#Validform_msg").hide();
            if(data.status=="y"){
                $("#DIVStep01").remove();
                $(".baseRight .title01 em").removeClass("active");
                $(".baseRight .title01 em").eq(1).addClass("active");
                $("#DIVSuccess").fadeIn(588,"easeInQuad");
            }else{
                $("#btnBindPhone").val("下一步");
                Kunyi.Msg.ShowTipsMsg(data.info,"1888","2");
                if(data.Type==1){
                    window.top.document.location.reload(true);
                }
                $("#btnBindPhone").removeAttr("disabled");
            }
        }
    });
    $("#PostBindPhoneCode").click(function(){
        $obj=$("#PhoneStatus");
        $phone=$("#tbPhone");
        $num=0;
        if($obj.val()!=""){
            $num=parseInt($obj.val(),10);
        }
        if($num>=3){
            $(this).val("短信发送已上限");
            return false;
        }
        if (!$phone.val().match(/(^1(3[0-9]|4[0-9]|5[0-35-9]|7[0-9]|8[0235-9])\d{8}$)/)) {
            Kunyi.Msg.ShowTipsMsg('手机号格式不正确！请重新输入！如15800000000', '2888', '2');
            $phone.focus();
            return false;
        }
        Kunyi.SetTime($(this).get(0));
        $obj.val(($num+1));
        $.ajax({
            url: "DoPostBack/PostMessage",
            type: "POST",
            data: {
                Phone: $.trim($phone.val())
            },
            beforeSend: function(result) {
            },
            success: function(result){
                if (result != ""){
                    Kunyi.Msg.ShowTipsMsg(result,"2888","2");
                }
            },
            error: function(result, status){
            }
        });
    });
    $("#ChangePasswordFrom").Validform({
        tiptype:3,
        showAllError:true,
        postonce:true,
        ajaxPost:true,
        beforeSubmit:function(curform){
            $("#btnChangePassword").val("提交中...");
            $("#btnChangePassword").attr("disabled","disabled");
        },
        callback:function(data){
            $("#Validform_msg").hide();
            if(data.status=="y"){
                $("#DIVStep01").remove();
                $(".baseRight .title01 em").removeClass("active");
                $(".baseRight .title01 em").eq(1).addClass("active");
                $("#DIVSuccess").fadeIn(588,"easeInQuad");
            }else{
                $("#btnChangePassword").val("下一步");
                Kunyi.Msg.ShowTipsMsg(data.info,"1888","2");
                $("#btnChangePassword").removeAttr("disabled");
                if(data.Type==1){
                    window.top.document.location.reload(true);
                }
            }
        }
    });
    $("#PostPhoneCode").click(function(){
        $obj=$("#PhoneStatus01");
        $num=0;
        if($obj.val()!=""){
            $num=parseInt($obj.val(),10);
        }
        if($num>=3){
            $(this).val("短信发送已上限");
            return false;
        }
        Kunyi.SetTime($(this).get(0));
        $obj.val(($num+1));
        $.ajax({
            url: "DoPostBack/PostMessage",
            type: "POST",
            beforeSend: function(result) {
            },
            success: function(result){
                if (result != ""){
                    Kunyi.Msg.ShowTipsMsg(result,"2888","2");
                }
            },
            error: function(result, status){
            }
        });
    });
    $("#ChangePhoneFrom01").Validform({
        tiptype:3,
        showAllError:true,
        postonce:true,
        ajaxPost:true,
        beforeSubmit:function(curform){
            $("#btnChangePhone01").val("提交中...");
            $("#btnChangePhone01").attr("disabled","disabled");
        },
        callback:function(data){
            $("#Validform_msg").hide();
            if(data.status=="y"){
                location.replace("ChangePhone.html");
            }else{
                $("#btnChangePhone01").val("下一步");
                Kunyi.Msg.ShowTipsMsg(data.info,"1888","2");
                $("#btnChangePhone01").removeAttr("disabled");
            }
        }
    });
    $("#ChangePhoneFrom02").Validform({
        tiptype:3,
        showAllError:true,
        postonce:true,
        ajaxPost:true,
        beforeSubmit:function(curform){
            $("#btnChangePhone02").val("提交中...");
            $("#btnChangePhone02").attr("disabled","disabled");
        },
        callback:function(data){
            $("#Validform_msg").hide();
            if(data.status=="y"){
                $("#CPhone").text($("#tbPhone").val());
                $("#DIVStep02").remove();
                $(".baseRight .title01 em").removeClass("active");
                $(".baseRight .title01 em").eq(2).addClass("active");
                $("#DIVSuccess").fadeIn(588,"easeInQuad");
            }else{
                $("#btnChangePhone02").val("下一步");
                Kunyi.Msg.ShowTipsMsg(data.info,"1888","2");
                $("#btnChangePhone02").removeAttr("disabled");
            }
        }
    });
});