
$(window).on('load', () => {
    setTimeout(()=>{
        $(".orbit-spinner").css({visibility:"hidden",opacity:"0"}).fadeOut(100)
    }, 2000);
    setTimeout(()=>{
        $("#main").removeAttr("hidden").fadeIn(200)
    }, 2400);
});

$(window).ready(() =>{
    $('#body').bootstrapMaterialDesign();
    const date = new Date()
    $('#txtDateInicioTratamiento').dateTimePicker({
        limitMax: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`
    });
    $('#txtDateTrasplante').dateTimePicker({
            limitMax: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`
    });
    $('#txtDateInjertoMie').dateTimePicker({
                limitMax: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`
    });
    $('#txtDateInjertoPla').dateTimePicker({
                    limitMax: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}`
     });

});

const initialConsultation = (() => {
    //----------Objects----------//

    //---------------------------//
    //----------Controls----------//
    const btnNext1 = $('#btnNext1');
    const btnNext2 = $('#btnNext2');
    const btnSave = $('#btnSave');
    const btnBack2 = $('#btnBack2');
    const btnBack3 = $('#btnBack3');
    const tabConsulta1 = $('#tabConsulta1');
    const tabConsulta2 = $('#tabConsulta2');
    const tabConsulta3= $('#tabConsulta3');
    const tab1 = $('#tab1');
    const tab2 = $('#tab2');
    const tab3 = $('#tab3');


    //Julio

   

    const Albumina = $('#Albumina');
    const Calcio_serico = $('#Calcio_serico');
    const Deshidrogenasa_Lactica = $('#Deshidrogenasa_Lactica');
    const Hemoglobina = $('#Hemoglobina');
    const Hematocrito = $('#Hematocrito');
    const Leucocitos = $('#Leucocitos');
    const Linfocitos = $('#Linfocitos');
    const Neutrofilos = $('#Neutrofilos');



    const Plaquetas = $('#Plaquetas');
    const IgG = $('#IgG');
    const IgA = $('#IgA');
    const IgM = $('#IgM');
    const Cadenas_Ligeras_Kappa = $('#Cadenas_Ligeras_Kappa');
    const Cadenas_Ligeras_Lambda = $('#Cadenas_Ligeras_Lambda');
    const Toxicidad_Hematologica_Serie_Roja = $('#Toxicidad_Hematologica_Serie_Roja');
    const Toxicidad_Hematologica_Neutrofilos = $('#Toxicidad_Hematologica_Neutrofilos');
    const celplasmo = $('#celplasmo');
    const electroforesis = $('#electroforesis');
    const electroforesis2 = $('#electroforesis2');

     const minres = $('#minres');
    
    

    //-----------------------------//
    //----------Functions----------//

btnNext1.click(()=>{

    var errores = new String("");


       if(Albumina.val()< 0.01 || Albumina.val()> 6 || Albumina.val() == ""){
            errores = errores.concat("-Albumina: fuera del rango 0.01 a 6\n");
        }
        if(Deshidrogenasa_Lactica.val()< 10 || Deshidrogenasa_Lactica.val()> 2000 || Deshidrogenasa_Lactica.val() == ""){
            errores = errores.concat("-Deshidrogenasa láctica: fuera del rango 10 a 2,000\n");
        }
        if(Calcio_serico.val()< 5 || Calcio_serico.val()> 20 || Calcio_serico.val() == ""){
            errores = errores.concat("-Calcio sérico: fuera del rango 5 a 20\n");
        }
        if(Hemoglobina.val()< 1 || Hemoglobina.val()> 20 || Hemoglobina.val() == ""){
            errores = errores.concat("-Hemoglobina: fuera del rango 1 a 20\n");
        }
        if(Hematocrito.val()< 3 || Hematocrito.val()> 20 || Hematocrito.val() == ""){
            errores = errores.concat("-Hematocrito: fuera del rango 3 a 20\n");
        }
        if(Leucocitos.val()< 0 || Leucocitos.val()> 100000 || Leucocitos.val() == ""){
            errores = errores.concat("-Leucocitos: fuera del rango 0 a 100,000\n");
        }
        if(Linfocitos.val()< 0 || Linfocitos.val()> 100000 || Linfocitos.val() == ""){
            errores = errores.concat("-Linfocitos: fuera del rango 0 a 100,000\n");
        }
        if(Neutrofilos.val()< 0 || Neutrofilos.val()> 100000 || Neutrofilos.val() == ""){
            errores = errores.concat("-Neutrofilos: fuera del rango 0 a 100,000\n");
        }
        

        if (errores.toString() != "") 
        {
            var aux = new String("Por favor verifique lo siguiente: \n")
            aux = aux.concat(errores.toString());
            swal(aux.toString());
        }
        else{
            tabConsulta1.removeClass('active');
        tabConsulta2.removeClass('disabled');
        tabConsulta2.addClass('active');
        tab1.removeClass('active');
        tab2.addClass('active');
        }
        
    });
btnNext2.click(()=>{
       var errores = new String("");
        if(Plaquetas.val()< 0 || Plaquetas.val()> 2000000 || Plaquetas.val() == ""){
                errores = errores.concat("-Plaquetas: fuera del rango 0 a 2,000,000\n");
        }
        if(IgG.val()< 0 || IgG.val()> 15000 || IgG.val() == ""){
                errores = errores.concat("-IgG: fuera del rango 0 a 15,000\n");
        }
        if(IgA.val()< 0 || IgA.val()> 10000 || IgA.val() == ""){
                errores = errores.concat("-IgA: fuera del rango 0 a 10,000\n");
        }
        if(IgM.val()< 0 || IgM.val()> 500 || IgM.val() == ""){
                errores = errores.concat("-IgM: fuera del rango 0 a 500\n");
        }

        if(Cadenas_Ligeras_Kappa.val()< 0 || Cadenas_Ligeras_Kappa.val()> 1000 || Cadenas_Ligeras_Kappa.val() == ""){
                errores = errores.concat("-Cadenas Ligeras Kappa: fuera del rango 0 a 1,000\n");
        }
        if(Cadenas_Ligeras_Lambda.val()< 0 || Cadenas_Ligeras_Lambda.val()> 500 || Cadenas_Ligeras_Lambda.val() == ""){
                errores = errores.concat("-Cadenas Ligeras Lambda: fuera del rango 0 a 1,000\n");
        }
        if(Toxicidad_Hematologica_Serie_Roja.val()< 0 || Toxicidad_Hematologica_Serie_Roja.val()> 5 || Toxicidad_Hematologica_Serie_Roja.val() == ""){
                errores = errores.concat("-Toxicidad Toxicidad Hematológica - Serie Roja: fuera del rango 0 a 5\n");
        }
        if(Toxicidad_Hematologica_Neutrofilos.val()< 0 || Toxicidad_Hematologica_Neutrofilos.val()> 5 || Toxicidad_Hematologica_Neutrofilos.val() == ""){
                errores = errores.concat("-Toxicidad Hematológica – Neutrófilos: fuera del rango 0 a 5\n");
        }

        if(celplasmo.val()< 0 || celplasmo.val()> 100 || celplasmo.val() == ""){
                errores = errores.concat("-Células plasmáticas en Médula ósea: fuera del rango 0 a 100\n");
        }
        
        if(electroforesis.val()< 0 || electroforesis.val()> 10000 || electroforesis.val() == ""){
                errores = errores.concat("-Electroforesis de proteínas suero: fuera del rango 0 a 10,000\n");
        }

        if(electroforesis2.val()< 0 || electroforesis2.val()> 10000 || electroforesis2.val() == ""){
                errores = errores.concat("-Electroforesis de proteínas orina: fuera del rango 0 a 10,000\n");
        }

    
        if (errores.toString() != "") 
            {
                var aux = new String("Por favor verifique lo siguiente: \n")
                aux = aux.concat(errores.toString());
                swal(aux.toString());
            }
        else{
            tabConsulta2.removeClass('active');
            tabConsulta3.removeClass('disabled');
            tabConsulta3.addClass('active');
            tab2.removeClass('active');
            tab3.addClass('active');
      }
        
    });

    //Se remplazo por Validar() ver abajo
    /*btnSave.click(()=>{
        var errores = new String("");
        

        if(minres.val()< 0 || minres.val()> 1000 || minres.val() == ""){
            errores = errores.concat("-Enfermedad mínima residual (eventos: fuera del rango 0 a 1,000\n");
        }
    
        if (errores.toString() != "") 
            {
                var aux = new String("Por favor verifique lo siguiente: \n")
                aux = aux.concat(errores.toString());
                swal(aux.toString());
                  return false;
            }
        else{
            swal("Consulta Final Registrada", "", "success");
            return true;
        }
        
    });*/




    btnBack2.click(()=>{
        tabConsulta1.addClass('active');
        tabConsulta2.removeClass('active');
        tab2.removeClass('active');
        tab1.addClass('active');
    });
    btnBack3.click(()=>{
        tabConsulta2.addClass('active');
        tabConsulta3.removeClass('active');
        tab3.removeClass('active');
        tab2.addClass('active');
    });
    //-----------------------------//
    //----------Return----------//
    return{
    }
    //---------------------------//
})();

var botonMarcado;
//PAra antes de enviar los datos
function Validar (){

        const minres = $('#minres');
        const txtDateTrasplante =$("#txtDateTrasplante");
        const celCD34 = $("#celCD34");
        const txtDateInjertoMie = $("#txtDateInjertoMie");
        const txtDateInjertoPla = $("#txtDateInjertoPla");

        var errores = new String("");


        if(minres.val()< 0 || minres.val()> 1000 || minres.val() == ""){
            errores = errores.concat("-Enfermedad mínima residual (eventos: fuera del rango 0 a 1,000\n");
        }
        if (botonMarcado == true) //Solo si se habilito el check
        {

             if(txtDateTrasplante.val() == ""){
                 errores = errores.concat("-Seleccione Fecha de trasplante\n");
              }
              if(celCD34.val()< 0 || celCD34.val()> 10 || celCD34.val() == ""){
                  errores = errores.concat("-Número de CD34 infundidas fuera del rango 0 a 10\n");
               }
              if(txtDateInjertoMie.val() == ""){
               errores = errores.concat("-Seleccione  Fecha injerto mieloide\n");
              }
              if(txtDateInjertoPla.val() == ""){
             errores = errores.concat("-Seleccione  Fecha injerto plaquetario\n");
            }
        }


        if (errores.toString() != "")
        {
            var aux = new String("Por favor verifique lo siguiente: \n")
            aux = aux.concat(errores.toString());
            swal(aux.toString());
            return false;
        }
        else{
            swal("Consulta Final Registrada", "", "success");
            return true;
        }
}

//Esperamso que se checke la parte del trasplante
$('input[type="checkbox"]').on('change', function(e){
    if (this.checked) {
       botonMarcado = true;
        swal("Campos trasplante habilitados");
        document.getElementById("txtDateTrasplante").removeAttribute("disabled");
       document.getElementById("celCD34").removeAttribute("disabled");
        document.getElementById("txtDateInjertoMie").removeAttribute("disabled");
        document.getElementById("txtDateInjertoPla").removeAttribute("disabled");
        document.getElementById("Toxicidad_Hematologica_Plaquetas").removeAttribute("disabled");
        document.getElementById("Toxicidad_Hepatica").removeAttribute("disabled");
        document.getElementById("Toxicidad_Renal").removeAttribute("disabled");
        document.getElementById("Toxicidad_neuropatia_periferica").removeAttribute("disabled");
        document.getElementById("Toxicidad_Hematologica_Neutrofilos").removeAttribute("disabled");
        document.getElementById("Toxicidad_Hematologica_Serie_Roja").removeAttribute("disabled");
        document.getElementById("Sitio_de_infeccion").removeAttribute("disabled");
        document.getElementById("Toxicidad_Infecciosa").removeAttribute("disabled");
        document.getElementById("Toxicidad_Gastrointestinal-Nausea").removeAttribute("disabled");
        document.getElementById("Reaccion_a_infusion_de_medicamentos").removeAttribute("disabled");



    } else {
        botonMarcado = false;
         swal("Campos trasplante deshabilitados");

         $("#txtDateTrasplante").val('');
         $("#celCD34").val(0);
         $("#txtDateInjertoMie").val('');
         $("#txtDateInjertoPla").val('');
         $("#Toxicidad_Hematologica_Plaquetas").val('0');
         $("#Toxicidad_Hepatica").val('0');
         $("#Toxicidad_Renal").val('0');
         $("#Toxicidad_neuropatia_periferica").val('0');
         $("#Toxicidad_Hematologica_Neutrofilos").val('0');
         $("#Toxicidad_Hematologica_Serie_Roja").val('0');
         $("#Sitio_de_infeccion").val('Ninguna');
         $("#Toxicidad_Infecciosa").val('0');
         $("#Toxicidad_Gastrointestinal-Nausea").val('0');
         $("#Reaccion_a_infusion_de_medicamentos").val('0');

         document.getElementById("txtDateTrasplante").setAttribute("disabled",true);
         document.getElementById("celCD34").setAttribute("disabled",true);
         document.getElementById("txtDateInjertoMie").setAttribute("disabled",true);
         document.getElementById("txtDateInjertoPla").setAttribute("disabled",true);
         document.getElementById("Toxicidad_Hematologica_Plaquetas").setAttribute("disabled",true);
         document.getElementById("Toxicidad_Hepatica").setAttribute("disabled",true);
         document.getElementById("Toxicidad_Renal").setAttribute("disabled",true);
         document.getElementById("Toxicidad_neuropatia_periferica").setAttribute("disabled",true);
         document.getElementById("Toxicidad_Hematologica_Neutrofilos").setAttribute("disabled",true);
         document.getElementById("Toxicidad_Hematologica_Serie_Roja").setAttribute("disabled",true);
         document.getElementById("Sitio_de_infeccion").setAttribute("disabled",true);
         document.getElementById("Toxicidad_Infecciosa").setAttribute("disabled",true);
         document.getElementById("Toxicidad_Gastrointestinal-Nausea").setAttribute("disabled",true);
         document.getElementById("Reaccion_a_infusion_de_medicamentos").setAttribute("disabled",true);




    }
});