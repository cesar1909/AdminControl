/*
~ Autor:JULIO
~ Date: 26/05/2019

~ Description: JavaScript for html addDoctor
*/

$(window).on('load', () => {
    setTimeout(()=>{
        $(".orbit-spinner").css({visibility:"hidden",opacity:"0"}).fadeOut(100)
    }, 2000);
    setTimeout(()=>{
        $("#main").removeAttr("hidden").fadeIn(200)
    }, 2400);
});

$(window).on('load', () => {
    document.getElementById("password").value = "";
});

$(window).ready(() =>{
    $('#body').bootstrapMaterialDesign();
    const date = new Date()
    $('#txtCalendar').dateTimePicker({
        limitMax: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`
    });
    $('#txtDiagnosisdate').dateTimePicker({
        limitMax: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`
    });
    $('#txtDateInicioTratamiento').dateTimePicker({
        limitMin: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`
    });
});
//Aqui



function Validar (){

    //Julio
    const btnSave = $('#btnSave');
    const txtName = $('#txtName');
    const txtApPaterno = $('#txtApPaterno');
    const txtApMaterno = $('#txtApMaterno');
    const txtCalendar = $('#txtCalendar');
    const slcGener = $('#slcGener');
    const site = $('#site');
    const telf = $('#telf');
    const telm = $('#telm');
    const cel = $('#cel');
    const city = $('#city');
    const email = $('#email');
    const password = $('#password');
    const password1 = $('#password1');

    var errores = new String("");

    if (txtName.val()==""||
        txtApPaterno.val()==""||
        txtApMaterno.val()==""||
        slcGener.val()==""||
        txtCalendar.val()==""||
        site.val()==""||
        telf.val()==""||
        telm.val()==""||
        cel.val()==""||
        city.val()==""||
        email.val()=="")
    {
        errores = errores.concat("Todos los campos deben ser llenados obligatoriamente");
    }

    if(password.val() != password1.val()){
        errores = errores.concat("-Verificar contraseña\n");
    }

    if (errores.toString() != "")
    {
        var aux = new String("Por favor verifique lo siguiente: \n")
        aux = aux.concat(errores.toString());
        swal(aux.toString());
        return false;
    }
    else{
        swal("Medico Registrado", "", "success");
        return true;

    }


}
