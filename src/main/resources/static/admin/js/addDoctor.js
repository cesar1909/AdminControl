/*        
~ Autor: Eduardo Rodriguez
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
    const tabPagUnoIC = $('#tabPagUnoIC');
    const tabPagDosIC = $('#tabPagDosIC');
    const tabPagTresIC = $('#tabPagTresIC');
    const tab1IC = $('#tab1IC');
    const tab2IC = $('#tab2IC');
    const tab3IC = $('#tab3IC');
    //-----------------------------//
    //----------Functions----------//
    txtName.blur(()=>{
        let name = txtName.val();
        if(name.length <= 0){
            txtName.addClass("txtError");
            formValidate.txtName = false;
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

    btnNext.click(()=>{
        let valid=true;
        // $.each(formValidate, (key, value)=>{
        //     if(value!=true)valid=false;
        // } );
        if(valid==true){
            tabGeneral.removeClass('active');
            tabDisease.removeClass('disabled');
            tabDisease.addClass('active');
            tab1.removeClass('active');
            tab2.addClass('active');
        }
        
    });
    btnNext2.click(()=>{
        let valid=true;
        // $.each(formValidate, (key, value)=>{
        //     if(value!=true)valid=false;
        // } );
        if(valid==true){
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
    btnNext1_initialConsultation.click(()=>{
        let valid=true;
        // $.each(formValidate, (key, value)=>{
        //     if(value!=true)valid=false;
        // } );
        if(valid==true){
            tabPagUnoIC.removeClass('active');
            tabPagDosIC.removeClass('disabled');
            tabPagDosIC.addClass('active');
            tab1IC.removeClass('active');
            tab2IC.addClass('active');
        }
        
    });
    btnNext2_initialConsultation.click(()=>{
        let valid=true;
        // $.each(formValidate, (key, value)=>{
        //     if(value!=true)valid=false;
        // } );
        if(valid==true){
            tabPagDosIC.removeClass('active');
            tabPagTresIC.removeClass('disabled');
            tabPagTresIC.addClass('active');
            tab2IC.removeClass('active');
            tab3IC.addClass('active');
        }
        
    });
    btnBack1_initialConsultation.click(()=>{
        tabDisease.addClass('active');
        tabPagUnoIC.removeClass('active');
        tab1IC.removeClass('active');
        tab2.addClass('active');
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