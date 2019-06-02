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
                $( "#divButtonsMonth1" ).remove();
                $( "#divButtonsMonth2" ).remove();
                $( "#divButtonsMonth3" ).remove();
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

    //Validaciones MENSUALES JULio
        //Variables
        var dateOfRealization = $("#txtCalendar").val();
        var albumin = $("#Albumina").val();
        var serumCalcium = $("#Calcio_serico").val();
        var lacticDehydrogenase = $("#Deshidrogenasa_Lactica").val();
        var hemoglobin = $("#Hemoglobina").val();
        var hematocrit = $("#Hematocrito").val();
        var leukocytes = $("#Leucocitos").val();
        var lymphocytes = $("#Linfocitos").val();
        var neutrophils = $("#Neutrofilos").val();
        var platelets = $("#Plaquetas").val();
        var igG = $("#IgG").val();
        var igA = $("#IgA").val();
        var igM = $("#IgM").val();
        var lightChainsKappa = $("#Cadenas_Ligeras_Kappa").val();
        var lightChainsLambda = $("#Cadenas_Ligeras_Lambda").val();
        var celPlasmaticEnMedulaOsea = $("#celplasmo").val();
        var electroForesisDeProteinasSuero = $("#electroforesis").val();
        var electroForesisDeProteinasOrina = $("#electroforesis2").val();
        var inmFijacionTipoIg = $("#inmunofijacionig").val();
        var inmFijacionTipoCll = $("#inmunofijacioncll").val();
        var enfermedadMinimaResidual = $("#minres").val();
        var repuestaATratamiento = $("#resTrat").val();
        var comentariosExtrax = $("#comment").val();

        //Comparaciones
        var errores = new String(""); //Aqui los alamacenamos
        if(dateOfRealization == ""){
            errores = errores.concat("-Fecha de valoracion: vacío");
        }
        if(Number(albumin) < 0.01 || Number(albumin) > 6 || !(Number(albumin))){
            errores = errores.concat("-Albumina: fuera del rango 0.01 a 6\n");
        }
        if (Number(serumCalcium) < 5 || Number(serumCalcium) > 20 || !(Number(serumCalcium)))
        {
           errores = errores.concat("-Calcio sérico: fuera del rango 5 a 20\n");
        }
        if (Number(lacticDehydrogenase) < 10 || Number(lacticDehydrogenase) > 2000 || !(Number(lacticDehydrogenase)))
        {
           errores = errores.concat("-Deshidrogenasa láctica: fuera del rango 10 a 2,000\n");
        }
        if (Number(hemoglobin) < 1 || Number(hemoglobin) > 20 || !(Number(hemoglobin)))
        {
           errores = errores.concat("-Hemoglobina: fuera del rango 1 a 20\n");
        }
        if (Number(hematocrit) < 3 || Number(hematocrit) > 20 || !(Number(hematocrit)))
        {
           errores = errores.concat("-Hematocrito: fuera del rango 3 a 20\n");
        }
        if (Number(leukocytes) < 0 || Number(leukocytes) > 100000 || !(Number(leukocytes)))
        {
           errores = errores.concat("-Leucocitos: fuera del rango 0 a 100,000\n");
        }
        if (Number(lymphocytes) < 0 || Number(lymphocytes) > 100000 || !(Number(lymphocytes)))
        {
           errores = errores.concat("-Linfocitos: fuera del rango 0 a 100,000\n");
        }
        if (Number(neutrophils) < 0 || Number(neutrophils) > 100000 || !(Number(neutrophils)))
        {
            errores = errores.concat("-Neutrofilos: fuera del rango 0 a 100,000\n");
        }
        if (Number(platelets) < 0 || Number(platelets) >  2000000 || !(Number(platelets)))
        {
            errores = errores.concat("-Plaquetas: fuera del rango 0 a 2,000,000\n");
        }
        if (Number(igG) < 0 || Number(igG) > 15000 || !(Number(igG)))
        {
            errores = errores.concat("-IgG: fuera del rango 0 a 15,000\n");
        }
        if (Number(igA) < 0 || Number(igA) > 10000 || !(Number(igA)))
        {
            errores = errores.concat("-IgA: fuera del rango 0 a 10,000\n");
        }
        if (Number(igM) < 0 || Number(igM) > 500 || !(Number(igM)))
        {
            errores = errores.concat("-IgM: fuera del rango 0 a 500\n");
        }
        if (Number(lightChainsKappa) < 0 || Number(lightChainsKappa) > 1000 || !(Number(lightChainsKappa)))
        {
            errores = errores.concat("-Cadenas Ligeras Kappa: fuera del rango 0 a 1,000\n");
        }
        if (Number(lightChainsLambda) < 0 || Number(lightChainsLambda) > 500 || !(Number(lightChainsLambda)))
        {
            errores = errores.concat("-Cadenas Ligeras Lambda: fuera del rango 0 a 1,000\n");
        }
        if (Number(celPlasmaticEnMedulaOsea) <  0 || Number(celPlasmaticEnMedulaOsea) > 100 || !(Number(celPlasmaticEnMedulaOsea)))
        {
            errores = errores.concat("-Células plasmáticas en Médula ósea: fuera del rango 0 a 100\n");
        }
        if (Number(electroForesisDeProteinasSuero) < 0 || Number(electroForesisDeProteinasSuero) > 10000 || !(Number(electroForesisDeProteinasSuero)))
        {
            errores = errores.concat("-Electroforesis de proteínas suero: fuera del rango 0 a 10,000\n");
        }
        if (Number(electroForesisDeProteinasOrina) < 0 || Number(electroForesisDeProteinasOrina) > 10000 || !(Number(electroForesisDeProteinasOrina)))
        {
            errores = errores.concat("-Electroforesis de proteínas orina: fuera del rango 0 a 10,000\n");
        }

        if (Number(enfermedadMinimaResidual) < -1 || Number(enfermedadMinimaResidual) > 1000 || !(Number(enfermedadMinimaResidual)))
        {
            errores = errores.concat("-Enfermedad mínima residual (eventos x10(-7)): fuera del rango 0 a 10,000\n");
        }
         //FIN VALIACIONES

        if (errores.toString() != "")
        {
            var aux = new String("Por favor verifique lo siguiente: \n")
            aux = aux.concat(errores.toString());
            swal(aux.toString());
        }
        else //Todo bien sigue el ajax :D
        {

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
    //Validaciones EDIT finales JULIO
        //Variables
        var dateOfRealization = $('#txtFechaValoracionCiclo').val();
        var albumin = $('#txtAlbuminaCiclo').val();
        var serumCalcium = $('#txtCalcioSericoCiclo').val();
        var lacticDehydrogenase = $('#txtDeshidrogenasaLacticaCiclo').val();
        var hemoglobin = $('#txtHemoglobinaCiclo').val();
        var hematocrit = $('#txtHematocritoCiclo').val();
        var leukocytes = $('#txtLeucocitosCiclo').val();
        var lymphocytes = $('#txtLinfocitosCiclo').val();
        var neutrophils = $('#txtNeutrofilosCiclo').val();
        var platelets = $('#txtPlaquetasCiclo').val();
        var igG = $('#txtIgGCiclo').val();
        var igA = $('#txtIgACiclo').val();
        var igM = $('#txtIgMCiclo').val();
        var lightChainsKappa = $('#txtCadenasKappaCiclo').val();
        var lightChainsLambda = $('#txtCadenasLambdaCiclo').val();
        var toxHemtoRedSerie = $('#txtToxicidadSerieRojaCiclo').val();
        var toxHemtoNeutrophils = $('#txtToxicidadNeutrofilosCiclo').val();
        var toxHemtoPlatelets = $('#txtToxicidadPlaquetasCiclo').val();
        var toxHepatics = $('#txtToxicidadHepaticaCiclo').val();
        var toxRenal = $('#txtToxicidadRenalCiclo').val();
        var toxGastroNausea = $('#txtToxicidadNauseaCiclo').val();
        var toxGastroDiarrhea = $('#txtToxicidadDiarreaCiclo').val();
        var toxNeuroatiaPerif = $('#txtToxicidadNeuropatiaCiclo').val();
        var toxInfectious = $('#txtToxicidadInfecciosaCiclo').val();
        var infectionSite = $('#txtSitioInfeccionCiclo').val();
        var infusionMedReaction = $('#txtReaccionMedicamentoCiclo').val();
        var adverseReaction = $('#txtReaccionAdversaCiclo').val();


        // Comparaciones
        var errores = new String(""); //Aqui los alamacenamos
        if(dateOfRealization == ""){
            errores = errores.concat("-Fecha de valoracion: vacío");
        }
        if(Number(albumin) < 0.01 || Number(albumin) > 6 || !(Number(albumin))){
            errores = errores.concat("-Albumina: fuera del rango 0.01 a 6\n");
        }
        if (Number(serumCalcium) < 5 || Number(serumCalcium) > 20 || !(Number(serumCalcium)))
        {
           errores = errores.concat("-Calcio sérico: fuera del rango 5 a 20\n");
        }
        if (Number(lacticDehydrogenase) < 10 || Number(lacticDehydrogenase) > 2000 || !(Number(lacticDehydrogenase)))
        {
           errores = errores.concat("-Deshidrogenasa láctica: fuera del rango 10 a 2,000\n");
        }
        if (Number(hemoglobin) < 1 || Number(hemoglobin) > 20 || !(Number(hemoglobin)))
        {
           errores = errores.concat("-Hemoglobina: fuera del rango 1 a 20\n");
        }
        if (Number(hematocrit) < 3 || Number(hematocrit) > 20 || !(Number(hematocrit)))
        {
           errores = errores.concat("-Hematocrito: fuera del rango 3 a 20\n");
        }
        if (Number(leukocytes) < 0 || Number(leukocytes) > 100000 || !(Number(leukocytes)))
        {
           errores = errores.concat("-Leucocitos: fuera del rango 0 a 100,000\n");
        }
        if (Number(lymphocytes) < 0 || Number(lymphocytes) > 100000 || !(Number(lymphocytes)))
        {
           errores = errores.concat("-Linfocitos: fuera del rango 0 a 100,000\n");
        }
        if (Number(neutrophils) < 0 || Number(neutrophils) > 100000 || !(Number(neutrophils)))
        {
            errores = errores.concat("-Neutrofilos: fuera del rango 0 a 100,000\n");
        }
        if (Number(platelets) < 0 || Number(platelets) >  2000000 || !(Number(platelets)))
        {
            errores = errores.concat("-Plaquetas: fuera del rango 0 a 2,000,000\n");
        }
        if (Number(igG) < 0 || Number(igG) > 15000 || !(Number(igG)))
        {
            errores = errores.concat("-IgG: fuera del rango 0 a 15,000\n");
        }
        if (Number(igA) < 0 || Number(igA) > 10000 || !(Number(igA)))
        {
            errores = errores.concat("-IgA: fuera del rango 0 a 10,000\n");
        }
        if (Number(igM) < 0 || Number(igM) > 500 || !(Number(igM)))
        {
            errores = errores.concat("-IgM: fuera del rango 0 a 500\n");
        }
        if (Number(lightChainsKappa) < 0 || Number(lightChainsKappa) > 1000 || !(Number(lightChainsKappa)))
        {
            errores = errores.concat("-Cadenas Ligeras Kappa: fuera del rango 0 a 1,000\n");
        }
        if (Number(lightChainsLambda) < 0 || Number(lightChainsLambda) > 500 || !(Number(lightChainsLambda)))
        {
            errores = errores.concat("-Cadenas Ligeras Lambda: fuera del rango 0 a 1,000\n");
        }
        if (Number(toxHemtoRedSerie) < 0 || Number(toxHemtoRedSerie) > 5 || !(Number(toxHemtoRedSerie)))
        {
            errores = errores.concat("-Toxicidad Toxicidad Hematológica - Serie Roja: fuera del rango 0 a 5\n");
        }
        if (Number(toxHemtoNeutrophils) < 0 || Number(toxHemtoNeutrophils) > 5 || !(Number(toxHemtoNeutrophils)))
        {
            errores = errores.concat("-Toxicidad Hematológica – Neutrófilos: fuera del rango 0 a 5\n");
        }
        if (Number(toxHemtoPlatelets) < 0 || Number(toxHemtoPlatelets) > 5 || !(Number(toxHemtoPlatelets)))
        {
            errores = errores.concat("-Toxicidad Hematologica - Plaquetas : fuera del rango 0 a 5\n");
        }
        if (Number(toxHepatics) < 0 || Number(toxHepatics) > 5 || !(Number(toxHepatics)))
        {
            errores = errores.concat("-Toxicidad Hepática: fuera del rango 0 a 5\n");
        }
        if (Number(toxRenal) < 0 || Number(toxRenal) > 5 || !(Number(toxRenal)))
        {
            errores = errores.concat("-Toxicidad Renal: fuera del rango 0 a 5\n");
        }
        if (infectionSite == "")
        {
            errores = errores.concat("-Sitio de infección: vacío\n");
        }
        if (Number(toxInfectious) < 0 || Number(toxInfectious) > 5 || !(Number(toxInfectious)))
        {
            errores = errores.concat("-Toxicidad Infecciosa: fuera del rango 0 a 5\n");
        }
        if (Number(toxGastroNausea) < 0 || Number(toxGastroNausea) > 5 || !(Number(toxGastroNausea)))
        {
            errores = errores.concat("-Toxicidad gastrointestinal - Nausea: fuera del rango 0 a 5\n");
        }
        if (Number(toxGastroDiarrhea) < 0 || Number(toxGastroDiarrhea) > 5 || !(Number(toxGastroDiarrhea)))
        {
            errores = errores.concat("-Toxicidad Gastrointestinal - Nausea: fuera del rango 0 a 5\n");
        }
        if (Number(toxNeuroatiaPerif) < 0 || Number(toxNeuroatiaPerif) > 5 || !(Number(toxNeuroatiaPerif)))
        {
            errores = errores.concat("-Toxicidad Toxicidad neuropatía periférica: fuera del rango 0 a 5\n");
        }
        if (Number(infusionMedReaction) < 0 || Number(infusionMedReaction) > 5 || !(Number(infusionMedReaction)))
        {
            errores = errores.concat("-Reacción a infusión de medicamentos: fuera del rango 0 a 5\n");
        }

        //FIN VALIACIONES

        if (errores.toString() != "")
        {
            var aux = new String("Por favor verifique lo siguiente: \n")
            aux = aux.concat(errores.toString());
            swal(aux.toString());
        }
        else //Todo bien sigue el ajax :D
        {




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