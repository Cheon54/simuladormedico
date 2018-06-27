function verificar(){
    
    var a = document.getElementById("comuna").value;
    var b = document.getElementById("prevision").value;
    
    if(a!= 0){
        if( b != 0){
            return true;
        }else{
            alert("Ingrese Prevision");
            return false;
        }
    }else{
        alert("Ingrese Comuna");
        return false;
    }
    
}
function verificarmedico(){
    var a = document.getElementById("medico").value;
    if(a != 0){
        return true;
    }else{
        alert("Ingrese Medico");
        return false;
    }
}