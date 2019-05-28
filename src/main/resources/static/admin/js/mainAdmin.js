//Julio: 26/may/2019 ya implementan la verificacion de eliminar doctor y monitor

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




function deseaEliminarDoctor (idDoctor){
    var resultado = false;
    swal({
      title: "¿Desea eliminar el doctor?",
      text: "Si elimina, no podrá recuperar la información!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        swal("Registro eliminado", {
          icon: "success",
        });
        resultado = true;
        //alert("hola AJAX");
            /*$.ajax({
                    async:true,
                    type: 'POST',
                    url: '/admin/deleteUser',
                    data: {'id':idDoctor},
                    success: function () {
                      alert('form fue enviado');
                    },
                     error : function(e) {
                         alert('error');
                         console.log("ERROR: ", e);
                     }
                  });*/
             location.href = "/admin/deleteUser?id="+idDoctor;
      } else {
        swal("Eliminacion cancelada");
        resultado = false;
        //alert(resultado);
      }
    });

    //alert("id docotor "+idDoctor+typeof(idDoctor));
}

function deseaEliminarMonitor (idMonitor){
    var resultado = false;
    swal({
      title: "¿Desea eliminar el monitor?",
      text: "Si elimina, no podrá recuperar la información!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        swal("Registro eliminado", {
          icon: "success",
        });
        resultado = true;

             location.href = "/admin/deleteUser?id="+idMonitor;
      } else {
        swal("Eliminacion cancelada");
        resultado = false;

      }
    });

}
function deseaEliminarPaciente (idPaciente){
    var resultado = false;
    swal({
      title: "¿Desea eliminar el paciente?",
      text: "Si elimina, no podrá recuperar la información de sus consultas!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        swal("Registro eliminado", {
          icon: "success",
        });
        resultado = true;

             location.href = "/admin/deletePatient?id="+idPaciente;
      } else {
        swal("Eliminacion cancelada");
        resultado = false;

      }
    });

}