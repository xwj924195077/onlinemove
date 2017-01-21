// huawei.js
/*panrongsheng 2015-02-05*/
$(".link-list a").each(function (i) {
    var url = $.trim($(this).attr("href"));
    var text = encodeURI($.trim($(this).html()));
    //var ret = /\?([\s\S]+?)=/;
    if (url != "") {
        return url;
    } else {
        url = "http://www.huawei.com/cn/group-search/index.htm?ssUserText=" + text;
        $(this).attr("href", url);
    }

})


$(document).ready(function () {
    try {
        var title = $("meta[name*='DRETITLE']").attr("content");
        var descript = $("meta[name*='DOC_DESCRIPTION']").attr("content");
        var url = window.location.href;
    } catch (e) {

    }
    $("a[href$='.pdf']").each(function () {
        if (typeof ($(this).attr("mark")) == "undefined") {
            $(this).attr("mark", "1");
        }
    });
    $(".share-list").attr("data-share-title", title);
    $(".share-list").attr("data-share-description", descript);
    $(".share-list").attr("data-share-url", url);



    

});

//Psirt Function
var psirtFunction = function () {
    var pageSize = 9;
    var psirtIndexFunction = function (obj) {
        var url = $(".js-tab-title.active").attr("data-url");
        $(obj).attr("href", url);
    }

    var loadData = function (year, currentPageIndex) {
        //alert("load Data:year-"+ year+"|index-"+currentPageIndex);
        var url = "";
        var ret = /\?sc_itemid/;
        var path = window.location.href;
        if (ret.exec(path) == "?sc_itemid") {
            url = path + "&d=ws";
        } else {
            url = "?d=ws";
        }
        url = url + "&Year=" + year;
        url = url + "&PageIndex=" + currentPageIndex;
        $.ajax({
            url: url,
            type: "GET",
            beforeSend: function () {
            },
            success: function (html) {
                $("#psirtMore").show();
                if ($($.trim(html)).find("td").length / 3 < 9) {
                    $("#psirtMore").hide();
                }
                if (currentPageIndex === 1) {
                    $("tbody").html("");
                }
                $("tbody").append(html);
                if ($(".table.table-striped.security tbody tr").length >= $("#num").val())
                {
                    $("#psirtMore").hide();
                }
            },
            error: function (responseText) {
                alert("Load Error");
            }
        });
    }

    var psirtYearsFilterFunciont = function (obj) {
        var year = $(obj).attr("data-id");
        $(".link-wrap a").each(function () {
            $(this).attr("data-select", 0);
        });
        if (year != "") {
            $(".link-wrap a[data-id=" + year + "]").each(function () {
                $(this).attr("data-select", 1);
            });
        }
        loadData(year, 1);
    }

    var psirtListMoreFunciont = function () {
        var year = "";
        var arrayYears = $(".link-wrap a[data-select=1]");
        if (arrayYears.length > 0) {
            year = $(arrayYears[0]).attr("data-id");
        }
        var currentPageIndex = Math.ceil($("tbody tr").length / pageSize) + 1;
        loadData(year, currentPageIndex);
    }

    return {
        psirtIndex: function (obj) { psirtIndexFunction(obj); },
        psirtYearsFilter: function (obj) { psirtYearsFilterFunciont(obj); },
        psirtMoreList: function () { psirtListMoreFunciont(); }
    }

}();


