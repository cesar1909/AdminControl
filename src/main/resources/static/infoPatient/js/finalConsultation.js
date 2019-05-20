/*        
~ Autor: Eduardo Rodriguez
~ Date: 07/04/2019
~ Description: JavaScript for html addFinalConsultation
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
    $('#txtFechaValoracionFinal').dateTimePicker({
        limitMin: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}` 
    });
});

const finalConsultation = (() => {
    //----------Objects----------//

    //---------------------------//
    //----------Controls----------//
    const btnNext1 = $('#btnNext1');
    const btnNext2 = $('#btnNext2');
    const btnBack2 = $('#btnBack2');
    const btnBack3 = $('#btnBack3');
    const tabConsultaFinal1 = $('#tabConsultaFinal1');
    const tabConsultaFinal2 = $('#tabConsultaFinal2');
    const tabConsultaFinal3 = $('#tabConsultaFinal3');
    const tab1 = $('#tab1');
    const tab2 = $('#tab2');
    const tab3 = $('#tab3');

    //-----------------------------//
    //----------Functions----------//

    btnNext1.click(()=>{
        let valid=true;
        // $.each(formValidate, (key, value)=>{
        //     if(value!=true)valid=false;
        // } );
        if(valid==true){
            tabConsultaFinal1.removeClass('active');
            tabConsultaFinal2.removeClass('disabled');
            tabConsultaFinal2.addClass('active');
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
            tabConsultaFinal2.removeClass('active');
            tabConsultaFinal3.removeClass('disabled');
            tabConsultaFinal3.addClass('active');
            tab2.removeClass('active');
            tab3.addClass('active');
        }
        
    });
    btnBack2.click(()=>{
        tabConsultaFinal1.addClass('active');
        tabConsultaFinal2.removeClass('active');
        tab2.removeClass('active');
        tab1.addClass('active');
    });
    btnBack3.click(()=>{
        tabConsultaFinal2.addClass('active');
        tabConsultaFinal3.removeClass('active');
        tab3.removeClass('active');
        tab2.addClass('active');
    });
    //-----------------------------//
    //----------Return----------//
    return{
    }
    //---------------------------//
})();