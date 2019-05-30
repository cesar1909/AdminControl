/*        
~ Autor: Julio Diaz
~ Date: 29/05/2019
~ Description: JavaScript for html patientsListDoctor

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
    const url = '../html/addPatient.html';
    //-----------------------------//
    //----------Functions----------//
    btnAddPatient.click(()=>{
        Swal.fire({
            title: '¿Deseas agregar un paciente?',
            // text:'' ,
            type: 'question',
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
    //-----------------------------//
    //----------Return----------//
    return{
    }
    //---------------------------//
})();


function selecTipoConsultaAAA (idPaciente, nombrePaciente){
    alert("Dentro");
    swal({
            title: 'Title',
            html: "Some Text" +
                "<br>" +
                '<button type="button" role="button" class="btn btn-success">' + 'Button1' + '</button>' +
                '<button type="button" role="button" class="btn btn-success">' + 'Button2' + '</button>',
            showCancelButton: false,
            showConfirmButton: false
        });

 }

 function selecTipoConsulta (idPaciente){
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
         '<a href=/monthlyconsult/newMonthlyConsult?id='+idPaciente+' class="btn1 btn btn-info"><i class="material-icons">note_add</i> Mensual</a>' +
         '<a href=/finalconsult/newFinForm?id='+idPaciente+' class="btn1 btn btn-info"><i class="material-icons">note_add</i> Final</a>' ,
         showCancelButton: false,
         showConfirmButton: false
     }).then((result) => {
         if (result.value) {
            alert("Hola");
        }
        })
 }
