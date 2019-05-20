/*        
~ Autor: Eduardo Rodriguez
~ Date: 07/04/2019
~ Description: JavaScript for html initialConsultation
*/

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
        limitMin: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}` 
    });
});

const initialConsultation = (() => {
    //----------Objects----------//

    //---------------------------//
    //----------Controls----------//
    const btnNext1_initialConsultation = $('#btnNext1_initialConsultation');
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
    //----------Return----------//
    return{
    }
    //---------------------------//
})();