$(function () {
    $objFixPartNav = $(".baseLeft .partNav");
    if ($objFixPartNav.length > 0) {
        $objFixPartNavTop = $objFixPartNav.offset().top - 55;
        $__W.bind('scroll', function () {
            var scrollTop = $__D.scrollTop();
            var heg1 = $objFixPartNavTop;
            if (scrollTop <= heg1) {
                if ($objFixPartNav.css("position") == "fixed")
                    $objFixPartNav.css({
                        "position": "relative"
                    });
            } else {
                if ($objFixPartNav.css('position') == "relative")
                    $objFixPartNav.css({
                        "position": "fixed"
                    });
            }
        });
        $("div.partNav ul li a").click(function () {
            $t = $(this);
            $("html,body").stop().animate({scrollTop: ($("#Department" + $t.data("index")).offset().top - 60) + "px"}, 888, "easeOutQuint");
        });
    }
    $("#GoToOffice").click(function (e) {
        if ($("#ddlOffices").val() != null && $("#ddlOffices").val() != "0") {
            var str = "Office-" + $("#ddlOffices").val() + ".html";
            window.location.href = str;
        }
    });
});