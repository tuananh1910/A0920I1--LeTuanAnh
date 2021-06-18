//delete
$(document).ready(function () {
    let deletelink = $("a:contains('Delete')");
    $(deletelink).click(function (event) {
        $.ajax({
            url: $(event.target).attributes("href"),
            type: "DELETE",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (blog) {
                var respContent = "";
                var rowToDelete = $(event.target).closest("tr");
                rowToDelete.remove();
                respContent += "<span class='success'>Blog was deleted: [";
                respContent += blog.name + " : ";
                respContent += blog.content + "]</span>";
                $("#blogFromResponse").html(respContent);
            }
        });
        event.preventDefault();
    });
});

// search
$(document).ready(function () {
    $('#searchBlog').submit(function (event) {
        $('#key_search').val();
        $.ajax({
            url: '/blogs/key-search',
            dataType: 'json',
            data: {key_search: $("#key_search").val()},
            type: "GET",

            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                var str = "";
                let page = "";
                if (data === "fail") {
                    alert('error');
                } else {
                    $.each(data, function (i) {

                        str += "<tr>";
                        str += "<td>" + data[i].id + "</td>";
                        str += "<td>" + data[i].name + "</td>";
                        str += "<td>" + data[i].content + "</td>";
                        str += "<td><a class='btn btn-success btnView' href='edit.html'>Edit |</a>" +
                            " <a href='/blogs/delete/{id}(id=" + data[i].id + ")'>Delete</a>" +
                            "</td>";
                        //{id}(id=${blog.getId()})
                        str += "</tr>";
                        page += " <a th:href=\"@{'/blogs'(page=${" + data.length - 1 + "}, key_search=${key_search})}" + " th:if=\"${blogs.hasPrevious()}" > Previous < /a>" +
                        "        <span th:text=\"${" + data.length + 1 + "}\"></span>/<span th:text=\"${" + data.length + "}\"></span>" +
                        "        <a th:href=\"@{'/blogs'(page=${" + data.length + 1 + "}, key_search=${key_search})}" + " th:if=\"${blogs.hasNext()}" > Next < /a>"
                    });
                    // id của thẻ tbody để hiển thị tất cả cá tr ra
                    $('#tbody').html(str);
                    $('#page').html(page);

                }
            }
        });
        event.preventDefault();
    });
});

// more
// $(document).ready(function(){
//     $("#more").click(function () {
//         $.ajax({
//             url: "/blogs/load-more",
//             dataType: 'json',
//             type: 'GET',
//             data: {key_search: $("#key_search").val()},
//             // cache:false,
//             beforeSend: function (xhr) {
//                 xhr.setRequestHeader("Accept", "application/json");
//                 xhr.setRequestHeader("Content-Type", "application/json");
//             },
//             success: function(data){
//                 /*console.log(data);*/
//                 var event_data = '';
//                 $.each(data, function(index){
//                     /*console.log(value);*/
//                     event_data += '<tr>';
//                     event_data += '<td>'+data[index].id+'</td>';
//                     event_data += '<td>'+data[index].name+'</td>';
//                     event_data += '<td>' + data[index].content + '</td>';
//                     event_data += "<td><a class='btn btn-success btnView' href='edit.html'>Edit |</a>" +
//                         " <a href='/blogs/delete/{id}(id="+data[index].id+")'>Delete</a>" +
//                         "</td>";
//                     event_data += '</tr>';
//
//                 });
//                 $("#table").append(event_data);
//             },
//             error: function(){
//                 /*console.log("error");*/
//                 alert("404. Please wait until the File is Loaded.");
//             }
//         });
//     })
//
// });


