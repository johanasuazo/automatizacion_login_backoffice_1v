package co.com.konex.certification.login.backoffice.stepdefinitions;

import co.com.konex.cetificacion.login.backoffice.model.TablaUsuarios;
import co.com.konex.cetificacion.login.backoffice.questions.Validar;
import co.com.konex.cetificacion.login.backoffice.questions.Verificar;
import co.com.konex.cetificacion.login.backoffice.tasks.Abrir;
import co.com.konex.cetificacion.login.backoffice.tasks.Digitar;
import co.com.konex.cetificacion.login.backoffice.tasks.Ingresar;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.List;

public class MyStepdefinitions {

    @Before
    public void iniciarEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^que el usuario ingresa al Backoffice$")
    public void queElUsuarioIngresaAlBackoffice() {
        OnStage.theActorCalled("Usuario").wasAbleTo(Abrir.laPagina());
    }

    @When("^digita usuario y contrasenna$")
    public void digitaUsuarioYContrasenna(List<TablaUsuarios> tablaUsuarios) {
        OnStage.theActorInTheSpotlight().attemptsTo(Ingresar.credenciales(tablaUsuarios.get(0)));
    }

    @Then("^verifica que ingreso correctamente$")
    public void verificaQueIngresoCorrectamente() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Verificar.home(), Matchers.equalTo("Inicio")));

    }

    //Caso2
    @Given("^que el usuario ingrese al Backoffice$")
    public void queElUsuarioIngreseAlBackoffice() {
            OnStage.theActorCalled("Usuario").wasAbleTo(Abrir.laPagina());
    }

    @When("^digita usuario o contrasenna incorrectas$")
    public void digitaUsuarioOContrasennaIncorrectas(List<TablaUsuarios> tablaUsuarios) {
        OnStage.theActorInTheSpotlight().attemptsTo(Digitar.credencialesIncorrectas(tablaUsuarios.get(0)));

    }

    @Then("^verifica el mensaje de error$")
    public void verificaElMensajeDeError() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Validar.mensajeError(),Matchers.equalTo("Credenciales incorrectas. Inténtalo de nuevo.")));
    }
}
