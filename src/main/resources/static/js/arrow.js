
var sidebar_hidden = true;

$("#arrow").click(function() {toggleSidebar();});
$(window).on("load", function() {updateContentSize();});
$(window).resize(function() {updateContentSize();});

function toggleSidebar()
{

    if (!sidebar_hidden)
    {
        sidebar_hidden = true;
        $("#accordionSidebar").css("transform", "translate(-500px)");
        $("#arrowIcon").css("transform", "rotate(0deg)");
    }
    else
    {
        sidebar_hidden = false;
        $("#accordionSidebar").css("transform", "translate(0px)");
        $("#arrowIcon").css("transform", "rotate(180deg)");
    }

    updateContentSize();
}

function updateContentSize()
{
    var page_width;
    var sidebar_width = $("#accordionSidebar").width();
    var delta;

    if (!sidebar_hidden)
    {
        page_width = $("#wrapper").width();
        delta = page_width - sidebar_width;

        $("#content-wrapper").css("min-width", delta + "px");
        $("#content-wrapper").css("transform", "translate(0px)");
    }
    else
    {
        $("#content-wrapper").css("min-width", "");
        $("#content-wrapper").css("transform", "translate(-" + sidebar_width + "px)");
    }
}
