/*        
~ Autor: 
~ Date: 03/04/2019
~ Description: JavaScript for html addPatient
*/
 
$(window).on('load', () => {

    setTimeout(()=>{
        $(".orbit-spinner").css({visibility:"hidden",opacity:"0"}).fadeOut(100)
    }, 2000);
    setTimeout(()=>{
        $("#main").removeAttr("hidden").fadeIn(200)
    }, 2400);
    document.getElementById("btnSave_initialConsultation").disabled = true;
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

const addPatient = (() => {
   
    //----------Objects----------//
    const formValidate = {
        txtName:false,
        txtPaterno:false,
        txtMaterno:false,
        slcGener:false,
        txtCalendar:false,
        txtDiagnosisdate:false,
        txtHeight: false,
        txtWeight: false
    }
    //---------------------------//
    //----------Controls----------//
    const txtName = $("#txtName");
    const txtApPaterno = $('#txtApPaterno');
    const txtApMaterno = $('#txtApMaterno');
    const txtCalendar = $('#txtCalendar');
    const txtDiagnosisdate = $('#txtDiagnosisdate');
    const txtYears = $('#txtYears');
    const txtHeight = $('#txtHeight');
    const txtWeight = $('#txtWeight');
    const btnNext = $('#btnNext');
    const btnNext2 = $('#btnNext2');
    const btnBack2 = $('#btnBack2');
    const slcGener = $('#slcGener');
    const txtIMC = $('#txtIMC');
    const txtSC = $('#txtSC');
    const tabGeneral = $('#tabGeneral');
    const tabDisease = $('#tabDisease');
    const tab1 = $('#tab1');
    const tab2 = $('#tab2');
    const btnNext1_initialConsultation = $('#btnNext1_initialConsultation');
    const btnBack1_initialConsultation = $('#btnBack1_initialConsultation');
    const btnNext2_initialConsultation = $('#btnNext2_initialConsultation');
    const btnBack2_initialConsultation = $('#btnBack2_initialConsultation');
    const btnBack3_initialConsultation = $('#btnBack3_initialConsultation');
    //Julio
    const btnSave_initialConsultation =  $('#btnSave_initialConsultation');
    const tabPagUnoIC = $('#tabPagUnoIC');
    const tabPagDosIC = $('#tabPagDosIC');
    const tabPagTresIC = $('#tabPagTresIC');
    const tab1IC = $('#tab1IC');
    const tab2IC = $('#tab2IC');
    const tab3IC = $('#tab3IC');

    //Variables pantalla dos
    const slcDeabetes = $('#slcDeabetes');
    const slcHipertension = $('#slcHipertension');
    const slcArritmias = $('#slcArritmias');
    const slcCardiopatia = $('#slcCardiopatia');
    const slcNeumopatia = $('#slcNeumopatia');
    const slcHepatopatia = $('#slcHepatopatia');
    
    //Variables pantalla3 consulta inicial parte1
    const txtSerica = $('#txtSerica');
    const txtDepuracion = $('#txtDepuracion');
    const txtECOG = $('#txtECOG');
    const slcActiva = $('#slcActiva');
    const txtNumPlasmocitomas = $('#txtNumPlasmocitomas');
    const txtCelulasPlasmáticasMédulaÓsea = $('#txtCelulasPlasmáticasMédulaÓsea');
    const txtCelulasPlasmáticasSangre = $('#txtCelulasPlasmáticasSangre');
    const txtIgG = $('#txtIgG');
    const txtIgA = $('#txtIgA');

    //Varibles pantalla4 consulta inicial parte2
    const txtIgM = $('#txtIgM');
    const txtCadenasKappa = $('#txtCadenasKappa');
    const txtCadenasLambda = $('#txtCadenasLambda'); 
    const txtProteinasSuero = $('#txtProteinasSuero');
    const txtProteinasOrina = $('#txtProteinasOrina');
    const slcAmiloidosis = $('#slcAmiloidosis');
    const txtB2Microglobulina = $('#txtB2Microglobulina');
    const txtAlbumina = $('#txtAlbumina');
    const txtCalcioSer = $('#CalcioSer');





    //-----------------------------//
    //----------Functions----------//
    txtName.blur(()=>{
        let name = txtName.val();
        if(name.length <= 0){
            txtName.addClass("txtError");
            formValidate.txtName = false;
            //swal("Todos los campos deben ser llenados obligatoriamente");
        }
        else{
            txtName.removeClass("txtError");
            formValidate.txtName = true;
        }
    });

    txtApPaterno.blur(()=>{
        let paterno = txtApPaterno.val();
        if(paterno.length <= 0){
            txtApPaterno.addClass("txtError");
            formValidate.txtPaterno = false;
        }
        else{
            txtApPaterno.removeClass("txtError");
            formValidate.txtPaterno = true;
        }
    });

    txtApMaterno.blur(()=>{
        let materno = txtApMaterno.val();
        if(materno.length <= 0){
            txtApMaterno.addClass("txtError");
            formValidate.txtMaterno = false;
        }
        else{
            txtApMaterno.removeClass("txtError");
            formValidate.txtMaterno = true;
        }
    });

    slcGener.change(()=>{
        formValidate.slcGener=true;
    });

    txtHeight.blur(()=>{
        let height = txtHeight.val();
        if(height.length <= 0 || !/^([0-9])*$/.test(height)){
            txtHeight.addClass("txtError");
            formValidate.txtHeight = false;
        }
        else{
            txtHeight.removeClass("txtError");
            formValidate.txtHeight = true;
            if(height.length > 0 && txtWeight.val().length > 0){
                fnCalcIMC_SC();
            }
        }
    });

    txtCalendar.blur(()=>{
        let calendar = txtCalendar.val();
        let date = moment(calendar);
        let years = Math.floor(moment().diff(date, 'years', true));
        txtYears.val((Object.is(years,NaN))?'':`${years}`);
        if(Object.is(years,NaN)){
            formValidate.txtCalendar = false;
        }
        else{
            formValidate.txtCalendar = true;
            _calculateAge(txtCalendar);
        }
    });

    txtDiagnosisdate.blur(()=>{
        let diagnosis = txtDiagnosisdate.val();
        if(diagnosis.length <= 0){
            formValidate.txtDiagnosisdate = false;
        }
        else{
            formValidate.txtDiagnosisdate = true;
        }
    });

    txtWeight.blur(()=>{
        let weight = txtWeight.val();
        if(weight.length <= 0 || !/^([0-9])*$/.test(weight)){
            txtWeight.addClass("txtError");
            formValidate.txtWeight = false;
        }
        else{
            txtWeight.removeClass("txtError");
            formValidate.txtWeight = true;
            if(txtHeight.val().length > 0 && weight.length > 0){
                fnCalcIMC_SC();
            }
        }
    });

    fnCalcIMC_SC=()=>{
        let imc = parseInt(txtWeight.val()) / Math.pow((parseFloat(txtHeight.val())/100),2);
        let sc =parseFloat(parseFloat(Math.sqrt((((parseInt(txtWeight.val())*parseInt(txtHeight.val())))/3600))).toFixed(2));
        txtIMC.val(`${(Object.is(parseInt(imc), NaN))?0:parseInt(imc)}`);
        txtSC.val(`${sc} m²`);
    }

    //Primer pantalla
    btnNext.click(()=>{
        //Julio valiamos que los camapos no esten vacios
        //alert("julio");
        if(txtName.val().length <= 0 ||
            txtApPaterno.val().length <= 0 ||
            txtApMaterno.val().length <= 0 ||
            txtCalendar.val().length <= 0 ||
            txtDiagnosisdate.val().length <= 0 ||
            txtYears.val().length <= 0 ||
            txtHeight.val().length <= 0 ||
            txtWeight.val().length <= 0
            ){
            swal("Todos los campos deben ser llenados obligatoriamente");
        }
        else
        {
            tabGeneral.removeClass('active');
            tabDisease.removeClass('disabled');
            tabDisease.addClass('active');
            tab1.removeClass('active');
            tab2.addClass('active');
       }

    });

    //Segunda pantalla
    btnNext2.click(()=>{

        if(slcDeabetes.val() == "Si" ||
            slcHipertension.val() == "Si" ||
            slcArritmias.val() == "Si" ||
            slcCardiopatia.val() == "Si" ||
            slcNeumopatia.val() == "Si" ||
            slcHepatopatia.val() == "Si" ||
            slcDeabetes.val() == null ||
            slcHipertension.val() == null ||
            slcArritmias.val() == null ||
            slcCardiopatia.val() == null ||
            slcNeumopatia.val() == null ||
            slcHepatopatia.val() == null
            ){
            
            var textoAlerta = new String("El paciente no puede pertenecer al programa debido a: \n");
            if(slcDeabetes.val() == "Si"){
                textoAlerta = textoAlerta.concat("-Diabetes\n");
            }
            if(slcHipertension.val() == "Si"){
                textoAlerta = textoAlerta.concat("-Hipertension\n");
            }
            if(slcArritmias.val() == "Si"){
                textoAlerta = textoAlerta.concat("-Arritmias\n");
            }
            if(slcCardiopatia.val() == "Si"){
                textoAlerta = textoAlerta.concat("-Cardiopatia\n");
            }
            if(slcNeumopatia.val() == "Si"){
                textoAlerta = textoAlerta.concat("-Neumopatia\n");
            }
            if(slcHepatopatia.val() == "Si"){
                textoAlerta = textoAlerta.concat("-Hepatopatia\n");
            }
            if(slcDeabetes.val() == null){
                textoAlerta = textoAlerta.concat("-Asigne un valor a: Diabetes\n");
            }
            if(slcHipertension.val() == null){
                textoAlerta = textoAlerta.concat("-Asigne un valor a: Hipertension\n");
            }
            if(slcArritmias.val() == null){
                textoAlerta = textoAlerta.concat("-Asigne un valor a: Arritmias\n");
            }
            if(slcCardiopatia.val() == null){
                textoAlerta = textoAlerta.concat("-Asigne un valor a: Cardiopatia\n");
            }
            if(slcNeumopatia.val() == null){
                textoAlerta = textoAlerta.concat("-Asigne un valor a: Neumopatia\n");
            }
            if(slcHepatopatia.val() == null){
                textoAlerta = textoAlerta.concat("-Asigne un valor a: Hepatopatia\n");
            }
            swal(textoAlerta.toString());
        }

        else
        {
            tabDisease.removeClass('active');
            tabPagUnoIC.removeClass('disabled');
            tabPagUnoIC.addClass('active');
            tab2.removeClass('active');
            tab1IC.addClass('active');
       }

        
    });
    btnBack2.click(()=>{
        tabGeneral.addClass('active');
        tabDisease.removeClass('active');
        tab2.removeClass('active');
        tab1.addClass('active');
    });

    //Tercer pantalla (ConsultaInicialParte1)
    btnNext1_initialConsultation.click(()=>{
        var errores = new String("");
        
        if(txtSerica.val()< 0 || txtSerica.val()> 10 || txtSerica.val() == ""){
            errores = errores.concat("-Creatina Sérica fuera del rango 0 a 10\n");
        }
        if (txtDepuracion.val()<0 || txtDepuracion.val()>200 || txtDepuracion.val() == "") {
            errores = errores.concat("-Depuración creatinina fuera del rango 0 a 200\n");
        }
        if (txtECOG.val() == "" || txtECOG.val() <0 || txtECOG.val()>2  ){
            errores = errores.concat("-ECOG fuera del rango 0 a 2, paciente no puede pertenecer a la investigación\n");
        }
        if (slcActiva.val() == "Si" ) {
            errores = errores.concat("-Infección activa, debe esperar la resolución\n");
        }
         if (slcActiva.val() == "" ) {
            errores = errores.concat("-Asigne un valor a Infección activa\n");
        }
        if (txtNumPlasmocitomas.val()<0 || txtNumPlasmocitomas.val()>20 || txtNumPlasmocitomas.val() == "" ) {
            errores = errores.concat("-Número Plasmocitomas fuera del rango 0 a 20\n");
        }
        if(txtCelulasPlasmáticasMédulaÓsea.val()<0 || txtCelulasPlasmáticasMédulaÓsea.val()>100 || txtCelulasPlasmáticasMédulaÓsea.val() == ""){
            errores = errores.concat("-Células plasmáticas en Médula ósea fuera del rango 0 a 100\n");
        }
        if(txtCelulasPlasmáticasMédulaÓsea.val()>0 && txtCelulasPlasmáticasMédulaÓsea.val()<10 ){
            errores = errores.concat("-Reconsiderar diagnóstico, Células plasmáticas en Médula Ósea menor a 10%\n");
        }

        if (txtCelulasPlasmáticasSangre.val()<0 || txtCelulasPlasmáticasSangre.val()>20  ) {
            errores = errores.concat("-El paciente es propenso a padecer LEUCEMIA DE CÉLULAS PLASMÁTICA, no apto\n");
        }
        if (txtCelulasPlasmáticasSangre.val()<0 || txtCelulasPlasmáticasSangre.val()>20 || txtCelulasPlasmáticasSangre.val() == "") {
            errores = errores.concat("-Células plasmáticas en sangre fuera del rango 0 a 20\n");
        }
        if (txtIgG.val()<0 || txtIgG.val()>15000 || txtIgA.val() == "" ) {
            errores = errores.concat("-IgG fuera del rango 0 a 15,000\n");
        }
        if (txtIgA.val()<0 || txtIgA.val()>10000 || txtIgA.val() == "" ) {
            errores = errores.concat("-IgA fuera del rango 0 a 10,000\n");
        }
        
        
        if(errores.toString() != "") //Hubo errores?
        {   
            var aux = new String("Por favor verifique lo siguiente: \n")
            aux = aux.concat(errores.toString());
            swal(aux.toString());
        }
        else{
            tabPagUnoIC.removeClass('active');
            tabPagDosIC.removeClass('disabled');
            tabPagDosIC.addClass('active');
            tab1IC.removeClass('active');
            tab2IC.addClass('active');
        }
        
    });
    //Cuarta pantalla (ConsultaInicialParte2)
    btnNext2_initialConsultation.click(()=>{
        var errores = new String("");
        
        if(txtIgM.val()< 0 || txtIgM.val()> 500 || txtIgM.val() == ""){
            errores = errores.concat("-IgG fuera del rango 0 a 500, reconsiderar diagnóstico\n");
        }
        if(txtCadenasKappa.val()< 0 || txtCadenasKappa.val()> 1000 || txtCadenasKappa.val() == ""){
            errores = errores.concat("-Cadenas ligeras kappa: fuera del rango 0 a 1000\n");
        }
        if(txtCadenasLambda.val()< 0 || txtCadenasLambda.val()> 1000 || txtCadenasLambda.val() == ""){
            errores = errores.concat("-Cadenas ligeras lambda: fuera del rango 0 a 1000\n");
        }
        if(txtProteinasSuero.val()< 0 || txtProteinasSuero.val()> 10000 || txtProteinasSuero.val() == ""){
            errores = errores.concat("-Electroforesis de proteínas suero: fuera del rango 0 a 10,000\n");
        }
        if(txtProteinasOrina.val()< 0 || txtProteinasOrina.val()> 10000 || txtProteinasOrina.val() == ""){
            errores = errores.concat("-Electroforesis de proteínas orina: fuera del rango 0 a 10,000\n");
        }
        if(slcAmiloidosis.val() == ""){
            errores = errores.concat("-Seleccione una opción para Amiloidosis sistémica\n");
        }
        if(slcAmiloidosis.val() == "Si"){
            errores = errores.concat("-El paciente no puede pertenecer a la investigación debido a Amiloidosis sistémica\n");
        }
        if(txtB2Microglobulina.val()< 0.01 || txtB2Microglobulina.val()> 10 || txtB2Microglobulina.val() == ""){
            errores = errores.concat("-B2 microglubina: fuera del rango 0.01 a 10\n");
        }
        if(txtAlbumina.val()< 0.01 || txtAlbumina.val()> 6 || txtAlbumina.val() == ""){
            errores = errores.concat("-Albumina: fuera del rango 0.01 a 6\n");
        }
        if(txtCalcioSer.val()< 5 || txtCalcioSer.val()> 20 || txtCalcioSer.val() == ""){
                    errores = errores.concat("-Calcio sérico: fuera del rango 5 a 20\n");
        }

        
        if (errores.toString() != "") 
        {
            var aux = new String("Por favor verifique lo siguiente: \n")
            aux = aux.concat(errores.toString());
            swal(aux.toString());
        }
        else{
            tabPagDosIC.removeClass('active');
            tabPagTresIC.removeClass('disabled');
            tabPagTresIC.addClass('active');
            tab2IC.removeClass('active');
            tab3IC.addClass('active');
            document.getElementById("btnSave_initialConsultation").disabled = false;
        }
        
    });

    //Se cambio por la function Validar() VER ABAJO
    //Quinta pantalla (ConsultaInicialParte3s)
    // btnSave_initialConsultation.click(()=>{
    //
    //     var errores = new String("");
    //
    //     if(txtDeshidrogenasa.val()< 10 || txtDeshidrogenasa.val()> 2000 || txtDeshidrogenasa.val() == ""){
    //         errores = errores.concat("-Deshidrogenasa láctica: fuera del rango 10 a 2000\n");
    //     }
    //     if(txtHemoglobina.val()< 1 || txtHemoglobina.val()> 20 || txtHemoglobina.val() == ""){
    //         errores = errores.concat("-Hemoglobina : fuera del rango 1 a 20\n");
    //     }
    //     if(txtHematocrito.val()< 3 || txtHematocrito.val()> 60 || txtHematocrito.val() == ""){
    //         errores = errores.concat("-Hematocrito : fuera del rango 3 a 60\n");
    //     }
    //     if(txtLeucocitos.val()< 0 || txtLeucocitos.val()> 100000 || txtLeucocitos.val() == ""){
    //         errores = errores.concat("-Leucocitos : fuera del rango 0 a 100,000\n");
    //     }
    //     if(txtLinfocitos.val()< 0 || txtLinfocitos.val()> 100000 || txtLinfocitos.val() == ""){
    //         errores = errores.concat("-Linfocitos : fuera del rango 0 a 100,000\n");
    //     }
    //     if(txtNeutrofilos.val()< 0 || txtNeutrofilos.val()> 100000 || txtNeutrofilos.val() == ""){
    //         errores = errores.concat("-Neutrófilos : fuera del rango 0 a 100,000\n");
    //     }
    //     if(txtPlaquetas.val()< 0 || txtPlaquetas.val()> 2000000 || txtPlaquetas.val() == ""){
    //         errores = errores.concat("-Plaquetas : fuera del rango 0 a 2,000,000\n");
    //     }
    //
    //     if (errores.toString() != "")
    //     {
    //         var aux = new String("Por favor verifique lo siguiente: \n")
    //         aux = aux.concat(errores.toString());
    //         swal(aux.toString());
    //     }
    //     else{
    //         tabPagDosIC.removeClass('active');
    //         tabPagTresIC.removeClass('active');
    //         tabPagTresIC.addClass('active');
    //         tab2IC.removeClass('active');
    //         tab3IC.addClass('active');
    //         swal("Paciente Registrado", "", "success");
    //     }
    // });
    



    btnBack1_initialConsultation.click(()=>{
        tabDisease.addClass('active');
        tabPagUnoIC.removeClass('active');
        tab1IC.removeClass('active');
        tab2.addClass('active');
        var nom = document.getElementsByName("txtName").value;

    });
    btnBack2_initialConsultation.click(()=>{
        tabPagUnoIC.addClass('active');
        tabPagDosIC.removeClass('active');
        tab2IC.removeClass('active');
        tab1IC.addClass('active');
    });
    btnBack3_initialConsultation.click(()=>{
        tabPagDosIC.addClass('active');
        tabPagTresIC.removeClass('active');
        tab3IC.removeClass('active');
        tab2IC.addClass('active');
    });


    //-----------------------------//
    //----------Return------------//

    //---------------------------//
})();



function Validar (){

    //Julio
    //Variables pantalal5 consutlta inicial parte3

    const txtDeshidrogenasa = $('#txtDeshidrogenasaJulio');
    const txtHemoglobina = $('#txtHemoglobinaJulio');
    const txtHematocrito = $('#txtHematocritoJulio');
    const txtLeucocitos = $('#txtLeucocitosJulio');
    const txtLinfocitos = $('#txtLinfocitosJulio');
    const txtNeutrofilos = $('#txtNeutrofilosJulio');
    const txtPlaquetas = $('#txtPlaquetasJulio');

    var errores = new String("");

     if(txtDeshidrogenasa.val()< 10 || txtDeshidrogenasa.val()> 2000 || txtDeshidrogenasa.val() == ""){
         errores = errores.concat("-Deshidrogenasa láctica: fuera del rango 10 a 2000\n");
     }
     if(txtHemoglobina.val()< 1 || txtHemoglobina.val()> 20 || txtHemoglobina.val() == ""){
         errores = errores.concat("-Hemoglobina : fuera del rango 1 a 20\n");
     }
     if(txtHematocrito.val()< 10 || txtHematocrito.val()> 60 || txtHematocrito.val() == ""){
         errores = errores.concat("-Hematocrito : fuera del rango 10 a 60\n");
     }
     if(txtLeucocitos.val()< 0 || txtLeucocitos.val()> 100000 || txtLeucocitos.val() == ""){
         errores = errores.concat("-Leucocitos : fuera del rango 0 a 100,000\n");
     }
     if(txtLinfocitos.val()< 0 || txtLinfocitos.val()> 100000 || txtLinfocitos.val() == ""){
         errores = errores.concat("-Linfocitos : fuera del rango 0 a 100,000\n");
     }
     if(txtNeutrofilos.val()< 0 || txtNeutrofilos.val()> 100000 || txtNeutrofilos.val() == ""){
         errores = errores.concat("-Neutrófilos : fuera del rango 0 a 100,000\n");
     }
     if(txtPlaquetas.val()< 0 || txtPlaquetas.val()> 2000000 || txtPlaquetas.val() == ""){
         errores = errores.concat("-Plaquetas : fuera del rango 0 a 2,000,000\n");
     }

    if (errores.toString() != "")
    {
        var aux = new String("Por favor verifique lo siguiente: \n")
        aux = aux.concat(errores.toString());
        swal(aux.toString());
        return false;
    }
    else{
        swal("Paciente Registrado", "", "success");
        return true;

    }


}


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