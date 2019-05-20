/*        
~ Autor: Eduardo Rodriguez
~ Date: 20/03/2019
~ Description: JavaScript for html index
*/

$(window).on('load', () => {
    setTimeout(()=>{
        $(".orbit-spinner").css({visibility:"hidden",opacity:"0"}).fadeOut(100)
    }, 2000);
    setTimeout(()=>{
        $("#main").removeAttr("hidden").fadeIn(200)
    }, 2400);
});

const index = (() => {
    //----------Objects----------//
    const login = {
        user:'Doctor',
        pass:'Doctor_'
    }
    //---------------------------//
    //----------Controls----------//
    const txtUser = $("#txtUser");
    const txtPass = $("#txtPass");
    const url = '../html/patientsList.html';
    //-----------------------------//
    //----------Functions----------//
    fnBtnEnter = () =>{
        (txtUser.val() != login.user  || txtPass.val() != login.pass)&&
        ohSnap('¡Error! Usuario y/o contraseña erroneos',{color: 'red'})||
        (txtUser.val() === login.user && txtPass.val() === login.pass)&&
        $(location).attr('href',url);
    }
    fnValidateUser = () =>{
        (txtUser.val().length <= 0)?txtUser.addClass("txtError"):txtUser.removeClass("txtError");
    }
    fnValidatePasssword = () =>{
        (txtPass.val().length <= 0)?txtPass.addClass("txtError"):txtPass.removeClass("txtError");
    }
    //-----------------------------//
    //----------Return----------//
    return{
        fnBtnEnter:fnBtnEnter,
        fnValidateUser: fnValidateUser,
        fnValidatePasssword:fnValidatePasssword
    }
    //---------------------------//
})();