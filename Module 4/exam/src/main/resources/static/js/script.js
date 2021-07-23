// list employee
// function onclickListEmployeeFunction() {
//     $.ajax({
//         url: "/furama-employee/employee-list",
//         type: "GET",
//         dataType: 'HTML',
//         success: function (data) {
//
//             $("#content").html(data);
//         },
//         error: function(jqXHR, textStatus, errorThrown) {
//             // When AJAX call has failed
//             console.log('AJAX call failed.');
//             console.log(textStatus + ': ' + errorThrown);
//         }
//
//     });
// }

// click admin
function onclickAdminFunction() {
    $.ajax({
        url: "/admin",
        type: "GET",
        dataType: 'HTML',
        success: function (data) {
            $("#content").html(data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // When AJAX call has failed
            console.log('AJAX call failed.');
            console.log(textStatus + ': ' + errorThrown);
        }

    });
}

// form create
// function onclickCreateNewEmployee() {
//     $.ajax({
//         url: "/furama-employee/create-new-employee",
//         type: "GET",
//         dataType: 'HTML',
//         success: function (data) {
//             $("#content").html(data);
//         },
//         error: function(jqXHR, textStatus, errorThrown) {
//             // When AJAX call has failed
//             console.log('AJAX call failed.');
//             console.log(textStatus + ': ' + errorThrown);
//         }
//     });
// }


// delete  - 500
// $(document).ready(function () {
//     var deleteLink = $("a:contains('Delete')");
//     $(deleteLink).click(function (event) {
//         console.log("delte");
//         console.log($(event.target).attr("href"))
//         $.ajax({
//             url: $(event.target).attr("href"),
//             type: "POST",
//             success: function (data) {
//                 var rowToDelete = $(event.target).closest("tr");
//                 rowToDelete.remove();
//
//                 alert("Đã xoá " );
//             },
//             error: function(jqXHR, textStatus, errorThrown) {
//                 // When AJAX call has failed
//                 console.log('AJAX call failed.');
//                 console.log(textStatus + ': ' + errorThrown);
//             }
//         });
//         event.preventDefault();
//     });
// });

// submit new employee  400 bad request


// edit form employee
// $(document).ready(function () {
//     var editLink = $("a:contains('Edit')");
//     $(editLink).click(function (event) {
//
//         $.ajax({
//             url: $(event.target).attr("href"),
//             type: "GET",
//             dataType : "HTML",
//             success: function (data) {
//                 $("#content").html(data);
//             },
//             error: function(jqXHR, textStatus, errorThrown) {
//                 // When AJAX call has failed
//                 console.log('AJAX call failed.');
//                 console.log(textStatus + ': ' + errorThrown);
//             }
//         });
//         event.preventDefault();
//     });
// });





