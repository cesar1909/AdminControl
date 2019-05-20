
$(window).on('load', () => {
    setTimeout(()=>{
        $(".orbit-spinner").css({visibility:"hidden",opacity:"0"}).fadeOut(20)
    }, 20);
    setTimeout(()=>{
        $("#main").removeAttr("hidden").fadeIn(0)
    }, 0);
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
    const btnAddDoctor = $("#btnAddDoctor");
    const url = '../html/addDoctor.html';
    //-----------------------------//
    //----------Functions----------//
    btnAddDoctor.click(()=>{
        Swal.fire({
            title: '¿Deseas agregar un doctor?',
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