$(function () {
    findAll();
})

function findAll() {

    let res = myAjax("/index", {}, "get");
    console.log(res);
    if (res != null) {

        setNewModelList(res.newsModelList);
        setProductModelList(res.productModelList);
    }
}


function setNewModelList(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += ' <div>\n' +
            '                            <div class="single-over font-title">' + data[i].title +
            '                            </div>\n' +
            '                            <div class="single-over font-content"></div>' + data[i].content +
            '                        </div>';
    }
    $("#news").html(html);
}

function setProductModelList(data) {

    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<div>\n' +
            '                        <div></div>\n' +
            '                        <div class="single-over font-title">' + data[i].name + '</div>\n' +
            '                        <div class="single-over font-content">' + data[i].content + '</div>\n' +
            '                    </div>';
    }
    $("#product").html(html);
}