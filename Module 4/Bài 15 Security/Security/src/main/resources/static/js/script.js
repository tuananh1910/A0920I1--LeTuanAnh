function onclickListEmployeeFunction() {
    $.ajax({
        url: "/employee-list",
        type: "GET",
        dataType: 'HTML',
        success: function (data) {
            $("#content").html(data);
        }
    });
}

function onclickAdminFunction() {
    $.ajax({
        url: "/admin",
        type: "GET",
        dataType: 'HTML',
        success: function (data) {
            $("#content").html(data);
        },
        error: function () {
            alert("Ban khong duoc quyen truy cap vao trang ADMIN !")
        }

    });
}





