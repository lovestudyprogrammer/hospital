$(function () {
    $(".dSourse ul li").click(function () {
        $(".dSourse ul li").removeClass("current");
        $t = $(this);
        $t.addClass("current");
        $("#tbNumber").val($t.data("num"));
    });
    $("#PostOrderForm").Validform({
        tiptype: 3,
        showAllError: true,
        postonce: true,
        ajaxPost: true,
        datatype: {
            "zh2-2": /^[\u4E00-\u9FA5\uf900-\ufa2d]{2}$/
        },
        beforeSubmit: function (curform) {
            $("#btnPostOrder").val("提交中...");
            $("#btnPostOrder").attr("disabled", "disabled");
        },
        callback: function (data) {
            $("#btnPostOrder").val("提交");
            $("#btnPostOrder").removeAttr("disabled");
            $("#Validform_msg").hide();
            if (data.status == "y") {
//					 window.top.document.location.href ="Contest.html";
                Kunyi.Msg.ShowTipsMsg(data.info, "1888", "1");
                window.setTimeout(function () {
                    window.top.document.location.href = "MemberReg.html";
                }, 1888);
            } else {
                Kunyi.Msg.ShowTipsMsg(data.info, "1888", "2");
                if (data.Type == 1) {
                    window.setTimeout(function () {
                        window.top.document.location.href = "login.html";
                    }, 1888);
                } else if (data.Type == 2) {
                    window.setTimeout(function () {
                        window.top.document.location.href = "BindPhone.html";
                    }, 1888);
                } else if (data.Type == 3) {
                    $("#IMGCheckcode").click();
                    $("#tbHashReg").val(data.hash);
                    $("#tbTokenOrder").val(data.token);
                } else if (data.Type == 4) {
                    $("#IMGCheckcode").click();
                    $("#tbHashReg").val(data.hash);
                    $("#tbTokenOrder").val(data.token);
                    if (data.Refresh == 1) {
                        window.setTimeout(function () {
                            window.top.document.location.reload(true);
                        }, 2888);
                    }
                }

            }

        }
    });
})
$__W.resize(function () {

});
$__W.load(function () {
    $(".dSourse ul li").eq(0).click();
});