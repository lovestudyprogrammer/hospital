$(function () {
    $(".baseRight .title02 .itemBase .divType").click(function () {
        $t = $(this);
        $obj = $(".baseRight .title02 .itemBase ul");
        if ($t.data("state") == "0") {
            $obj.stop(true, false).fadeIn(function () {
                $t.data("state", "1");
            });
        } else {
            $obj.stop(true, false).fadeOut(function () {
                $t.data("state", "0");
            });
        }
    });
});