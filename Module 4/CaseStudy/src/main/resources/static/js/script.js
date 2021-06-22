
$(document).ready(function () {
    let employeeListLink = $("a:contains('Employee List')");
    $(employeeListLink).click(function (event) {
        $.ajax({
            url: $(event.target).attributes("href"),
            type: "GET",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                var str = "";
                if (data === "fail") {
                    alert('error');
                } else {
                    $.each(data, function (i) {
                        str += '<table>' +
                            '               <thead>' +
                            '                <tr>' +
                            '                    <th>ID</th>' +
                            '                    <th>Name</th>' +
                            '                    <th>Birthday</th>' +
                            '                    <th>ID Card</th>' +
                            '                    <th>Salary</th>' +
                            '                    <th>Phone</th>' +
                            '                    <th>Email</th>' +
                            '                    <th>Address</th>' +
                            '                    <th>Position</th>' +
                            '                    <th>Education</th>' +
                            '                    <th>Division</th>' +
                            '                    <th>User</th>' +
                            '                    <th>Action</th>' +
                            '                </tr>' +
                            '                </thead>' +
                            '                <tbody>' +
                            '                <tr>' +
                            '                <td>' + data[i].employee_id + '</td>' +
                            '                <td>' + data[i].employee_name + '</td>' +
                            '                <td>' + data[i].employee_birthday + '</td>' +
                            '                <td>' + data[i].employee_id_card + '</td>' +
                            '                <td>' + data[i].employee_salary + '</td>' +
                            '                <td>' + data[i].employee_phone + '</td>' +
                            '                <td>' + data[i].employee_email + '</td>' +
                            '                <td>' + data[i].employee_address + '</td>' +
                            '                <td>' + data[i].position.position_name + '</td>' +

                            '                </tbody>' +
                            '            </table>'

                    });
                    $("#content").html(str);
                }

            },
        });
    });
});



