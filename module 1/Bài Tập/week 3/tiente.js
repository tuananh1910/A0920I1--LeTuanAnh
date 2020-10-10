function convert() {

    let x= document.getElementById('1').value;
    let y= parseInt(x);
    let fromCurrent= parseInt(document.getElementById('fromCurrent').value);
    let toCurrent= parseInt(document.getElementById('toCurrent').value);
    let current;
    if (fromCurrent === Viet Nam && toCurrent === USD){
        current= y/23000;
        alert(current);
    }
    else if(fromCurrent === USD && toCurrent === Viet Nam){
        current= y*23000;
        alert(current);
    }
    else{
        alert('nhap loai tien muon chuyen doi')
    }
}
