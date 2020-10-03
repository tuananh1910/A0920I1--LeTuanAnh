let ly=prompt("nhập điểm lý:")
let hoa= prompt("nhập điểm hoá:")
let sinh= prompt("nhập điểm sinh:")
let diemly=parseInt(ly)
let diemhoa=parseInt(hoa)
let diemsinh=parseInt(sinh)
let tong= diemly+diemhoa+diemsinh
let diemtrungbinh=(diemly+diemhoa+diemsinh)/3
document.writeln("điểm tổng=" +tong)
document.writeln('<br/>')
document.writeln("Điểm trung bình=" +diemtrungbinh)