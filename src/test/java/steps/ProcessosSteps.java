package steps;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class ProcessosSteps extends BaseSteps {
    private PaginaInicial home = new PaginaInicial(driver, driver);
    private MenuLateral menu = new MenuLateral(driver);
    private ProcessosOpcoes optionsProcessos = new ProcessosOpcoes(driver);
    private ProcessosPost processosPost = new ProcessosPost(driver);
    private ProcessoEdit processoEdit = new ProcessoEdit(driver);
    private ProcessosMostrar processosMostrar = new ProcessosMostrar(driver);

    @Dado("^usuário está na home$")
    public void usuarioEstaNaHome() {
        home.abrirPagina();
    }
    @E("^usuário clicar na opção \"([^\"]*)\" do menu lateral$")
    public void oUsuarioClicarNoMenu(String vMenu) throws Throwable {
        menu.clicarMenuLateral(vMenu);
    }
    @E("^usuário clica no botão de novo processo$")
    public void oUsuarioClicarNoBotaoNovoProcesso() {
        optionsProcessos.botaoNovoProcesso();
    }

    @E("^usuário informa no campo \"([^\"]*)\" o valor igual a \"([^\"]*)\"$")
    public void oUsuarioDigitarNoCampoOValor(String campo, String valor) throws Throwable {
        processosPost.preencherCampo(campo, valor);
    }
    @E("^usuário digita no campo \"([^\"]*)\" o valor igual a \"([^\"]*)\"$")
    public void oUsuarioDigitarNoCampoDeEditarOValor(String campo, String valor) throws Throwable {
        processoEdit.preencherCampo(campo, valor);
    }
    @Quando("^usuário clica em salvar na página de inclusão$")
    public void oUsuarioClicarNoBotaoSalvar() {
        processosPost.clicarSalvar();
        processosPost.setCode(processosMostrar.recuperaCodigo());
    }
    @Quando("^usuário clica no botão salvar na página de editar$")
    public void oUsuarioClicarNoBotaoSalvarEmEditar() {
        processoEdit.clicarSalvar();
    }

    @Então("^o usuário deveria visualizar a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveriaVisualizarAMensagem(String message) throws Throwable {
        Assert.assertEquals(message, processosMostrar.recuperarMensagemDeSucesso());
    }
    @E("^usuário seleciona o valor \"([^\"]*)\" no campo urgência$")
    public void oUsuárioSelecionaNoCampoOValor(String valor) throws Throwable {
        processosPost.selecionarUrgencia(valor);
    }
    @E("^usuário seleciona o valor Sim no campo arbitramento$")
    public void oUsuárioClicaNoCampoArbitramentoComOValorSim() {
        processosPost.clicarArbitramentoSim();
    }

    @Quando("^usuário clica no botão voltar$")
    public void oUsuárioClicarEmVoltar() {
        processosMostrar.clicarVoltar();
    }

    @Quando ("^usuário clica no botao Mostrar do processo$")
    public void oUsuarioClicaNoBotaoMostrarDoUsuarioCadastrado(){
        optionsProcessos.botaoMostrar(processosPost.getCode());
    }
    @Quando ("^usuário clica no botao editar do processo$")
    public void oUsuarioClicaNoBotaoEditarDoUsuarioCadastrado(){
        optionsProcessos.botaoEditar(processosPost.getCode());
    }

    @Então("^usuário visualizará a informação \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerOValorNoCampo(String value, String field) throws Throwable{
        Assert.assertEquals(value,processosMostrar.getField(field));
    }

    @Quando("^usuário clica em Apagar dentro do processo$")
    public void oUsuarioClicarNoBotaoApagarDoProcessoCadastrado() {
        optionsProcessos.botaoDeletar(processosPost.getCode());
    }

    @E("^usuário confirma a ação de deletar$")
    public void oUsuarioConfirmarADelecao() {
        optionsProcessos.confirmaDelecao();
    }

    @Então("^botão Apagar não será apresentado$")
    public void oBotaoApagarNaoPodeMaisExisterParaOProcessoCadastrado() {
        Assert.assertFalse(optionsProcessos.existeBotaoApagar(processosPost.getCode()));
    }
}
