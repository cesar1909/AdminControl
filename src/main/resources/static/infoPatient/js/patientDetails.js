/*        
~ Autor: Eduardo Rodriguez
~ Date: 21/04/2019
~ Description: JavaScript for html patientDetails
*/

$(window).on('load', () => {
    setTimeout(()=>{
        $(".orbit-spinner").css({visibility:"hidden",opacity:"0"}).fadeOut(100)
    }, 2000);
    setTimeout(()=>{
        $("#main").removeAttr("hidden").fadeIn(200)
    }, 2400);

    });

        // $.ajax({
        //     url : '/patient/finalInfo',
        //     success : function(data) {
        //         if (data.valueOf() == null) {
        //         }else {
        //             $( "#finalEmpty" ).remove();
        //             $('#result').html(data);
        //         }
        //     }
        // });

// });

$(window).ready(() =>{
    $('#body').bootstrapMaterialDesign();
});

window.onload = function() {
    var sizeArray = document.getElementById("myvar");
    // window.alert(sizeArray.textContent);
    var optionsAsString = "";
    for(var i = 0; i < sizeArray.textContent; i++) {
        optionsAsString += "<option value='" + (i+1) + "'>" + (i+1) + "</option>";
    }
    $( 'select[name="inptProduct"]' ).append( optionsAsString );};

function getFinalInfoJs(identificadorJs) {
    $.ajax({
        url: "/patient/getFinalInfo" + "?id=" + identificadorJs,
        success: function(data) {
            if (data == "no data") {
                console.log("Datos nulos");
            }
            else {
                console.log("Datos desde el servidor");
                $( "#noConsultation" ).remove();
                $('#result').html(data);
                // $('#result').load('/patient/getFinalInfo', "identificador=" + identificadorJs)
            }
        }
    });
}

function verifyMonthly(idPat) {
    $.ajax({
        url: "/patient/verifyMonthly" + "?idPaciente=" + idPat,
        success: function(data) {
            if (data == "no data") {
                $( "#selectConsult" ).remove();
                console.log("Datos nulos");
            }
            else {
                console.log("Datos desde el servidor");
                $( "#noConsultation2" ).remove();
                //$('#result2').html(data);
                // $('#result').load('/patient/getFinalInfo', "identificador=" + identificadorJs)
            }
        }
    });
}


function getMonthlyInfo(idCon) {
    var id = idCon.valueOf();
    var idPatient = document.getElementById("myvarid").textContent;
    console.log(id);
    console.log(idPatient);
    $.ajax({
        url: "/patient/getMonthlyInfo" + "?idConsulta=" + idCon + "&idPaciente=" + idPatient,
        success: function(data) {
                console.log("Nos comunicamos con el controlador de consulta mensual");
                $('#result2').html(data);
            }
    });
}

function createTable(selectedValue){
    window.alert(selectedValue.valueOf());
    // var x = document.getElementById("slcSelectCicle").value;
    // window.alert(x.valueOf());
    // $( 'select[name="var2"]' ).append( selectedValue );
}


const patientDetails = (() => {
    //----------Objects----------//

    //---------------------------//
    //----------Controls----------//
    const navLink1 = $('#navLink1');
    const navLink2 = $('#navLink2');
    const navLink3 = $('#navLink3');
    const navLink4 = $('#navLink4');
    //-----------------------------//
    //----------Functions----------//
    navLink1.click(()=>{
        navLink2.removeClass('active');
        navLink3.removeClass('active');
        navLink4.removeClass('active');
        navLink1.addClass('active');
    });
    navLink2.click(()=>{
        navLink1.removeClass('active');
        navLink3.removeClass('active');
        navLink4.removeClass('active');
        navLink2.addClass('active');
    });
    navLink3.click(()=>{
        navLink1.removeClass('active');
        navLink2.removeClass('active');
        navLink4.removeClass('active');
        navLink3.addClass('active');
    });
    navLink4.click(()=>{
        navLink1.removeClass('active');
        navLink2.removeClass('active');
        navLink3.removeClass('active');
        navLink4.addClass('active');
    });
    //-----------------------------//
    //----------Return----------//
    return{
    }
    //---------------------------//
})();




//Cuando cargue el la pag pedimos el ajax y ponemos el nombre de usuario
$(document).ready(function() {
   //alert("Cambia el nombre!! desde AJAX);
   $("#nameUSER").text('Prueba');
   $.ajax({
       url: "/patient/fullname",
       success: function(data) {
              //alert(data);
              $("#nameUSER").text("Médico: "+data);
           }
   });

});