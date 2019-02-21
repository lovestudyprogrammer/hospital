Kunyi.GetRequest=function(){
    var url = window.location.toString();
    var theRequest = new Array(2);
    if (url.indexOf("#") != -1) {
        var str = url.substr(url.indexOf("#"));
        var base=str.replace("#", "");
        if(!isNaN(base)){
            $("html,body").animate({ scrollTop: ($(".baseRight .choosetitle").offset().top-30) }, 888, "easeOutQuint");
            $(".general .visitList .namelist a[data-index='"+base+"']").addClass("current");
        }
    }
}
$(function(){
    $objDIVWeekday =$("#DIVWeekdayC");
    if ($objDIVWeekday.length > 0) {
        $WeekdayTop = $objDIVWeekday.offset().top-45;
        $__W.bind('scroll', function() {
            var scrollTop = $__D.scrollTop();
            var heg1 = $WeekdayTop;
            if (scrollTop <= heg1) {
                if ($objDIVWeekday.css("position") == "fixed")
                    $objDIVWeekday.css({"position": "absolute","top":"30px"});
            } else {
                if ($objDIVWeekday.css('position') == "absolute")
                    $objDIVWeekday.css({"position": "fixed","top":"45px"});
            }
        });
    }
});
$__W.load(function(){
    $(".general .visitList .namelist").each(function(i, e) {
        $t=$(this);
        $t.find(".list01").css("height",($t.height()-43)+"px");;
    });
    Kunyi.GetRequest();
});