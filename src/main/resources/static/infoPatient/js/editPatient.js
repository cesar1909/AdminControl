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
        url: "/monitor/getFinalInfoToEdit" + "?id=" + identificadorJs,
        success: function(data) {
            if (data == "no data") {
                console.log("Datos nulos");
                $( "#divButtonsFinal" ).remove();
                $( "#divButtonsFinal2" ).remove();
                $( "#divButtonsFinal3" ).remove();
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

function getMonthlyInfotoEdit(idCon) {
    var id = idCon.valueOf();
    var idPatient = document.getElementById("myvarid").textContent;
    console.log(id);
    console.log(idPatient);
    $.ajax({
        url: "/monitor/getMonthlyInfotoEdit" + "?idConsulta=" + idCon + "&idPaciente=" + idPatient,
        success: function(data) {
            console.log("Nos comunicamos con el controlador de consulta mensual");
            $('#result2').html(data);
        }
    });
}

// function submitFinal() {
//     var fecha = document.getElementById("txtCalendar").value;
//     console.log(fecha);
//     $.ajax({
//         url: "/monitor/testForm" + "?fecha=" + fecha,
//         success: function(data) {
//             console.log("Nos comunicamos con el controlador de consulta mensual");
//             //$('#result2').html(data);
//         },
//         error: function () {
//             alert('Error while request..');
//
//         }
//     });
// }

// $('#submitFormFinal').submit(function(evento) {
//     $.ajax({
//         url: 'monitor/testForm',
//         type: 'POST',
//         data: 'fecha=' + $("#txtCalendar").val(),
//         processData: false,
//         contentType: "application/json",
//                 success: function(response){
//             alert('No hubo error')
//             // $('#result').html("");
//             // var obj = JSON.parse(response);
//             // $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email);
//         },
//         error: function(){
//             alert('Error while request..');
//         }
//     })
//     evento.preventDefault();
// });


// function madeAjaxCall(){
//     $.ajax({
//         type: "POST",
//         url: "/monitor/testForm",
//         cache: false,
//         data:'fecha=' + $("#txtCalendar").val(),
//         // data:'firstName=' + $("#firstName").val() + "&lastName;=" + $("#lastName").val() + "&email;=" + $("#email").val(),
//         success: function(response){
//             alert('No hubo error')
//             // $('#result').html("");
//             // var obj = JSON.parse(response);
//             // $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email);
//         },
//         error: function(){
//             alert('Error while request..');
//         }
//     });
// }


function subirForm() {
    var data = {};
    data["idPatient"] = $("#idPatient").val();
    data["dateOfRealization"] = $("#txtCalendar").val();
    data["albumin"] = $("#Albumina").val();
    data["serumCalcium"] = $("#Calcio_serico").val();
    data["lacticDehydrogenase"] = $("#Deshidrogenasa_Lactica").val();
    data["hemoglobin"] = $("#Hemoglobina").val();
    data["hematocrit"] = $("#Hematocrito").val();
    data["leukocytes"] = $("#Leucocitos").val();
    data["lymphocytes"] = $("#Linfocitos").val();
    data["neutrophils"] = $("#Neutrofilos").val();
    data["platelets"] = $("#Plaquetas").val();
    data["igG"] = $("#IgG").val();
    data["igA"] = $("#IgA").val();
    data["igM"] = $("#IgM").val();
    data["lightChainsKappa"] = $("#Cadenas_Ligeras_Kappa").val();
    data["lightChainsLambda"] = $("#Cadenas_Ligeras_Lambda").val();
    data["celPlasmaticEnMedulaOsea"] = $("#celplasmo").val();
    data["electroForesisDeProteinasSuero"] = $("#electroforesis").val();
    data["electroForesisDeProteinasOrina"] = $("#electroforesis2").val();
    data["inmFijacionTipoIg"] = $("#inmunofijacionig").val();
    data["inmFijacionTipoCll"] = $("#inmunofijacioncll").val();
    data["enfermedadMinimaResidual"] = $("#minres").val();
    data["repuestaATratamiento"] = $("#resTrat").val();
    data["comentariosExtrax"] = $("#comment").val();

    // $("#btn-save").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/editpatientconsult/final",
        data: JSON.stringify(data),
        timeout: 600000,
        success: function (response) {
            console.log("Formulario Procesado");
            console.log(response);
            swal({
                title: "Consulta Final Editada Correctamente",
                icon: "success",
                text: false,
                button: "Ok"
            });
            getFinalInfoJs(data.idPatient);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error en la comunicación con spring");
            console.log(textStatus, errorThrown);

        }
    });
}

function subirFormMensual() {
    var data = {};
    data["idMonthlyConsultation"] = $("#idPatient").val();
    data["treatmentCycleNum"] = $("#numCiclo").val();
    data["dateOfRealization"] = $("#txtFechaValoracionCiclo").val();
    data["albumin"] = $("#txtAlbuminaCiclo").val();
    data["serumCalcium"] = $("#txtCalcioSericoCiclo").val();
    data["lacticDehydrogenase"] = $("#txtDeshidrogenasaLacticaCiclo").val();
    data["hemoglobin"] = $("#txtHemoglobinaCiclo").val();
    data["hematocrit"] = $("#txtHematocritoCiclo").val();
    data["leukocytes"] = $("#txtLeucocitosCiclo").val();
    data["lymphocytes"] = $("#txtLinfocitosCiclo").val();
    data["neutrophils"] = $("#txtNeutrofilosCiclo").val();
    data["platelets"] = $("#txtPlaquetasCiclo").val();
    data["igG"] = $("#txtIgGCiclo").val();
    data["igA"] = $("#txtIgACiclo").val();
    data["igM"] = $("#txtIgMCiclo").val();
    data["lightChainsKappa"] = $("#txtCadenasKappaCiclo").val();
    data["lightChainsLambda"] = $("#txtCadenasLambdaCiclo").val();
    data["toxHemtoRedSerie"] = $("#txtToxicidadSerieRojaCiclo").val();
    data["toxHemtoNeutrophils"] = $("#txtToxicidadNeutrofilosCiclo").val();
    data["toxHemtoPlatelets"] = $("#txtToxicidadPlaquetasCiclo").val();
    data["toxHepatics"] = $("#txtToxicidadHepaticaCiclo").val();
    data["toxRenal"] = $("#txtToxicidadRenalCiclo").val();
    data["toxGastroNausea"] = $("#txtToxicidadNauseaCiclo").val();
    data["toxGastroDiarrhea"] = $("#txtToxicidadDiarreaCiclo").val();
    data["toxNeuroatiaPerif"] = $("#txtToxicidadNeuropatiaCiclo").val();
    data["toxInfectious"] = $("#txtToxicidadInfecciosaCiclo").val();
    data["infectionSite"] = $("#txtSitioInfeccionCiclo").val();
    data["infusionMedReaction"] = $("#txtReaccionMedicamentoCiclo").val();
    data["adverseReaction"] = $("#txtReaccionAdversaCiclo").val();
    // $("#btn-save").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/editpatientmothlyconsult/mensual",
        data: JSON.stringify(data),
        timeout: 600000,
        success: function (response) {
            console.log("Formulario Procesado");
            console.log(response);
            swal({
                title: "Consulta Mensual Editada Correctamente",
                icon: "success",
                text: false,
                button: "Ok"
            });
            console.log(data.treatmentCycleNum);
            getMonthlyInfotoEdit(data.treatmentCycleNum);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Error en la comunicación con spring");
            console.log(textStatus, errorThrown);

        }
    });
}

// $(function () {
//     var token = $("meta[name='_csrf']").attr("content");
//     var header = $("meta[name='_csrf_header']").attr("content");
//     $(document).ajaxSend(function(e, xhr, options) {
//         xhr.setRequestHeader(header, token);
//     });
// });




// $(function() {
//     /*  Submit form using Ajax */
//     $('button[type=submit]').click(function(e) {
//
//         //Prevent default submission of form
//         e.preventDefault();
//
//         //Remove all errors
//         $('input').next().remove();
//
//         $.post({
//             url : 'saveEmployee',
//             data : $('form[name=employeeForm]').serialize(),
//             success : function(res) {
//
//                 if(res.validated){
//                     //Set response
//                     $('#resultContainer pre code').text(JSON.stringify(res.employee));
//                     $('#resultContainer').show();
//
//                 }else{
//                     //Set error messages
//                     $.each(res.errorMessages,function(key,value){
//                         $('input[name='+key+']').after('<span class="error">'+value+'</span>');
//                     });
//                 }
//             }
//         })
//     });
// });


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


//Julio
//Cuando cargue el la pag pedimos el ajax y ponemos el nombre de usuario
$(document).ready(function() {
   //alert("Cambia el nombre!! desde AJAX);
   $("#nameUSER").text('Prueba');
   $.ajax({
       url: "/patient/fullname",
       success: function(data) {
              //alert(data);
              $("#nameUSER").text("Monitor: "+data);
           }
   });

});