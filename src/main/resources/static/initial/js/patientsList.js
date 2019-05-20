/*        
~ Autor: Eduardo Rodriguez
~ Date: 20/03/2019
~ Description: JavaScript for html patientsList
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
    $('#DataTable').DataTable(
        {

        }
    );
});
$.extend( true, $.fn.dataTable.defaults, dataTables);
const patientList = (() => {
    //----------Objects----------//

    //---------------------------//
    //----------Controls----------//
    const btnAddPatient = $("#btnAddPatient");
    const url = 'http://localhost:8080/patient/newForm';

    const btnAddConsultation = $("#btnAddConsultation");
    const url2 = 'http://localhost:8080/monthlyconsult/newMonthlyConsult';
    const url3 = 'http://localhost:8080/finalconsult/newFinForm';
    //-----------------------------//
    //----------Functions----------//
    btnAddPatient.click(()=>{
        Swal.fire({
            title: '¿Deseas agregar un paciente?',
            // text:'' ,
            showCancelButton: true,
            cancelButtonText: 'No',
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Si, agregar',
            reverseButtons: true
          }).then((result) => {
            if (result.value) {
                $(location).attr('href',url);
            }
          })
        }
    );


btnAddConsultation.click(()=>{
    Swal.fire({
    title: 'Seleccione el tipo de consulta',
    // text:'' ,
    // showCancelButton: true,
    // cancelButtonText: 'Cancelar',
    // confirmButtonColor: '#3085d6',
    // cancelButtonColor: '#d33',
    // confirmButtonText: 'Si, agregar',
    html: "" +
    "<br>" +
    '<button  class="btn1 btn btn-info"><i class="material-icons">note_add</i> Mensual</button>' +
    '<button  class="btn2 btn btn-info"><i class="material-icons">note_add</i> Final</button>',
    showCancelButton: false,
    showConfirmButton: false
}).then((result) => {
    if (result.value) {
    // $(location).attr('href',url);
}
})
}
);

$(document).on('click', '.btn1', function() {
    //Some code 1
    $(location).attr('href',url2);
});
$(document).on('click', '.btn2', function() {
    //Some code 2
    $(location).attr('href',url3);
});

    //-----------------------------//
    //----------Return----------//
    return{
    }
    //---------------------------//
})();

