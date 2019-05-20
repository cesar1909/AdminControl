/*        
~ Autor: Eduardo Rodriguez
~ Date: 21/04/2019
~ Description: JavaScript for html patientDetails
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
});

window.onload = function() {
    var sizeArray = document.getElementById("myvar");
    // window.alert(sizeArray.textContent);
    var optionsAsString = "";
    for(var i = 0; i < sizeArray.textContent; i++) {
        optionsAsString += "<option value='" + (i+1) + "'>" + (i+1) + "</option>";
    }
    $( 'select[name="inptProduct"]' ).append( optionsAsString );};


function createTable(selectedValue){
    window.alert(selectedValue.valueOf());
    $( 'select[name="var2"]' ).append( selectedValue );


// return [
        // "<div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtFechaValoracionCiclo\">Fecha de Valoración</label>\n" +
        // "                              <input type=\"text\" id=\"txtFechaValoracionCiclo\" class=\"form-control\" th:text=\"${monthly.size()}\">\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtAlbuminaCiclo\">Albumina (g/dL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtAlbuminaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtCalcioSericoCiclo\">Calcio sérico (mg/dL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtCalcioSericoCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>\n" +
        // "                    <br/>\n" +
        // "                    <div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtDeshidrogenasaLacticaCiclo\">Deshidrogenasa Lactica (U/L)</label>\n" +
        // "                              <input type=\"text\" id=\"txtDeshidrogenasaLacticaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtHemoglobinaCiclo\">Hemoglobina (g/dL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtHemoglobinaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtHematocritoCiclo\">Hematocrito (%)</label>\n" +
        // "                              <input type=\"text\" id=\"txtHematocritoCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>\n" +
        // "                    <br />\n" +
        // "                    <div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtLeucocitosCiclo\">Leucocitos (cels x 10(3)/uL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtLeucocitosCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtLinfocitosCiclo\">Linfocitos (cels x 10(3)/uL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtLinfocitosCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtNeutrofilosCiclo\">Neutrofilos (cels x 10(3)/uL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtNeutrofilosCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>\n" +
        // "                    <br/>\n" +
        // "                    <div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtPlaquetasCiclo\">Plaquetas (cels x 10(3)/uL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtPlaquetasCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtIgGCiclo\">IgG (mg/dL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtIgGCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtIgACiclo\">IgA (mg/dL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtIgACiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>\n" +
        // "                    <br />\n" +
        // "                    <div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtIgMCiclo\">IgM (mg/dL)</label>\n" +
        // "                              <input type=\"text\" id=\"txtIgMCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtCadenasKappaCiclo\">Cadenas Ligeras Kappa (mg/L)</label>\n" +
        // "                              <input type=\"text\" id=\"txtCadenasKappaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtCadenasLambdaCiclo\">Cadenas Ligeras Lambda (mg/L)</label>\n" +
        // "                              <input type=\"text\" id=\"txtCadenasLambdaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>\n" +
        // "                    <br/>\n" +
        // "                    <div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadSerieRojaCiclo\">Toxicidad Hematologica - Serie Roja</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadSerieRojaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadNeutrofilosCiclo\">Toxicidad Hematologica - Neutrofilos</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadNeutrofilosCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadPlaquetasCiclo\">Toxicidad Hematologica - Plaquetas</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadPlaquetasCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>\n" +
        // "                    <br/>\n" +
        // "                    <div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadHepaticaCiclo\">Toxicidad Hepática</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadHepaticaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadRenalCiclo\">Toxicidad Renal</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadRenalCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadInfecciosaCiclo\">Toxicidad Infecciosa</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadInfecciosaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>\n" +
        // "                    <br/>\n" +
        // "                    <div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtSitioInfeccionCiclo\">Sitio de infección</label>\n" +
        // "                              <input type=\"text\" id=\"txtSitioInfeccionCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadNauseaCiclo\">Toxicidad gastrointestinal - Nausea</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadNauseaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadDiarreaCiclo\">Toxicidad gastrointestinal - Diarrea</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadDiarreaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>\n" +
        // "                    <br/>\n" +
        // "                    <div class=\"row\">\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtToxicidadNeuropatiaCiclo\">Toxicidad neuropatía periférica</label>\n" +
        // "                              <input type=\"text\" id=\"txtToxicidadNeuropatiaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtReaccionMedicamentoCiclo\">Reacción a infusión de medicamentos</label>\n" +
        // "                              <input type=\"text\" id=\"txtReaccionMedicamentoCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                      <div class=\"col-lg-4 col-md-4 col-sm-4\">\n" +
        // "                        <fieldset disabled>\n" +
        // "                            <div class=\"form-group\">\n" +
        // "                              <label for=\"txtReaccionAdversaCiclo\">Reaccion adversa otra</label>\n" +
        // "                              <input type=\"text\" id=\"txtReaccionAdversaCiclo\" class=\"form-control\" />\n" +
        // "                            </div>\n" +
        // "                        </fieldset>\n" +
        // "                      </div>\n" +
        // "                    </div>"
    // ].join('\n');
}


const patientDetails = (() => {
    //----------Objects----------//

    //---------------------------//
    //----------Controls----------//
    const navLink1 = $('#navLink1');
    const navLink2 = $('#navLink2');
    const navLink3 = $('#navLink3');
    const navLink4 = $('#navLink4');
    //-----------------------------//
    //----------Functions----------//
    navLink1.click(()=>{
        navLink2.removeClass('active');
        navLink3.removeClass('active');
        navLink4.removeClass('active');
        navLink1.addClass('active');
    });
    navLink2.click(()=>{
        navLink1.removeClass('active');
        navLink3.removeClass('active');
        navLink4.removeClass('active');
        navLink2.addClass('active');
    });
    navLink3.click(()=>{
        navLink1.removeClass('active');
        navLink2.removeClass('active');
        navLink4.removeClass('active');
        navLink3.addClass('active');
    });
    navLink4.click(()=>{
        navLink1.removeClass('active');
        navLink2.removeClass('active');
        navLink3.removeClass('active');
        navLink4.addClass('active');
    });
    //-----------------------------//
    //----------Return----------//
    return{
    }
    //---------------------------//
})();