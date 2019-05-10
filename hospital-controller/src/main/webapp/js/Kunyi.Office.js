$(function () {
    $("img.loading").lazyload({
        effect: "fadeIn",
        event: "sporty"
    });
    setTimeout(function () {
        $("img.loading").trigger("sporty")
    }, 2888);
    $(".doctorsBase .tools .Aprev").click(function () {
        $obj = $(".doctorsBase .contents ul");
        $current = parseInt($obj.data("num"), 10);
        $Index = $current - 1;
        $LiSize = $obj.find("li").size();
        $BaseWidth = Kunyi.BaseMark.width();
        $Size = 0;
        $w = 0;
        $plus = 0;
        if ($BaseWidth >= 1200 && $BaseWidth < 1500) {
            $Size = Math.ceil($LiSize / 5);
            $w = 240 * 5;
            $plus = 30;
        } else if ($BaseWidth >= 980 && $BaseWidth < 1200) {
            $Size = Math.ceil($LiSize / 4);
            $w = (240 + 6) * 4;
            $plus = 17;
        } else {
            $Size = Math.ceil($LiSize / 6);
            $w = (240 + 12) * 6;
            $plus = 30;
        }
        if ($Index >= 0) {
            $obj.data("num", $Index);
            $obj.stop().animate({
                left: (-$w * $Index + $plus) + "px"
            }, 888, "easeOutQuart");
        } else {
            $obj.data("num", ($Size - 1));
            $obj.stop().animate({
                left: (-$w * ($Size - 1) + $plus) + "px"
            }, 888, "easeOutQuart");
        }
    });
    $(".doctorsBase .tools .Anext").click(function () {
        $obj = $(".doctorsBase .contents ul");
        $current = parseInt($obj.data("num"), 10);
        $Index = $current + 1;
        $LiSize = $obj.find("li").size();
        $BaseWidth = Kunyi.BaseMark.width();
        $Size = 0;
        $w = 0;
        $plus = 0;
        if ($BaseWidth >= 1200 && $BaseWidth < 1500) {
            $Size = Math.ceil($LiSize / 5);
            $w = 240 * 5;
            $plus = 30;
        } else if ($BaseWidth >= 980 && $BaseWidth < 1200) {
            $Size = Math.ceil($LiSize / 4);
            $w = (240 + 6) * 4;
            $plus = 17;
        } else {
            $Size = Math.ceil($LiSize / 6);
            $w = (240 + 12) * 6;
            $plus = 30;
        }
        if ($Index < $Size) {
            $obj.data("num", $Index);
            $obj.stop().animate({
                left: (-$w * $Index + $plus) + "px"
            }, 888, "easeOutQuart");
        } else {
            $obj.data("num", 0);
            $obj.stop().animate({
                left: (-$w * 0 + $plus) + "px"
            }, 888, "easeOutQuart");
        }
    });
    $(".PartBanner .bannerRight .rightbtn a.green").click(function () {
        if ($("#AreaDuty").length > 0) {
            $("html,body").stop().animate({scrollTop: ($("#AreaDuty").offset().top - 60) + "px"}, 888, "easeOutQuint");
        }
    });
});
$__W.resize(function () {
    $(".doctorsBase .contents ul").removeAttr("style").data("num", "0");
});
$__W.load(function () {
    $(".visitDate .visitList .namelist .list01").css("height", $(".visitDate .visitList .namelist").height() + "px");
});