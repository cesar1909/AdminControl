/*        
~ Autor: Eduardo Rodriguez
~ Date: 07/04/2019
~ Description: JavaScript for html addmonthlyConsultation
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
    $('#txtFechaValoracion').dateTimePicker({
        limitMin: `${date.getFullYear()}-${date.getMonth()+1}-${date.getDate()}` 
    });
});

const monthlyConsultation = (() => {
    //----------Objects----------//

    //---------------------------//
    //----------Controls----------//
    const btnNext1 = $('#btnNext1');
    const btnNext2 = $('#btnNext2');
    const btnBack2 = $('#btnBack2');
    const btnBack3 = $('#btnBack3');
    const tabConsulta1 = $('#tabConsulta1');
    const tabConsulta2 = $('#tabConsulta2');
    const tabConsulta3= $('#tabConsulta3');
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
            tabConsulta1.removeClass('active');
            tabConsulta2.removeClass('disabled');
            tabConsulta2.addClass('active');
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
            tabConsulta2.removeClass('active');
            tabConsulta3.removeClass('disabled');
            tabConsulta3.addClass('active');
            tab2.removeClass('active');
            tab3.addClass('active');
        }
        
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
})();