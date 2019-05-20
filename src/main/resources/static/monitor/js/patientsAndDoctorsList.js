/*        
~ Autor: Julio Diaz
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