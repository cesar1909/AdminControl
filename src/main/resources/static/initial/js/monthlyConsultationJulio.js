
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
});

window.onload = function() {
    var sizeArray = document.getElementById("myvar");
    var optionsAsString = "";
        optionsAsString += "<option value='" + (+sizeArray.textContent+1) + "'>" + (+sizeArray.textContent+1) + "</option>";
    $( 'select[name="treatmentCycleNum"]' ).append( optionsAsString );};



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

    //JULIO
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

    

    ///

    //-----------------------------//
    //----------Functions----------//

    btnNext1.click(()=>{ //JULIO
            var errores = new String("");
            //alert("JULIO")

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
        if(Neutrofilos.val()< 0 || Neutrofilos.val()> 100000 || Neutrofilos.val() == ""){
                errores = errores.concat("-Neutrofilos: fuera del rango 0 a 100,000\n");
        }
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

    btnSave.click(()=>{
         swal("Consulta Mensual Registrada", "", "success");

    });

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
})()