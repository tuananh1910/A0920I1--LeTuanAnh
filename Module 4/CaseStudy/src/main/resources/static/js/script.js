function onclickListEmployeeFunction() {
    $.ajax({
        url: "/furama-employee/employee-list",
        type: "GET",
        dataType: 'HTML',
        success: function (data) {
            $("#content").html(data);
        },
        error: function () {
            alert("ERROR PAGE !")
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

function onclickCreateNewEmployee() {
    $.ajax({
        url: "/furama-employee/create-new-employee",
        type: "GET",
        dataType: 'HTML',
        success: function (data) {
            $("#content").html(data);
        },
        error: function () {
            alert("ERROR PAGE !")
        }
    });
}








