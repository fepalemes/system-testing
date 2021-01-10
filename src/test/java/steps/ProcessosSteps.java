package steps;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.*;
import support.BaseSteps;

public class ProcessosSteps extends BaseSteps {
    private PaginaInicial inicial = new PaginaInicial(driver);
    private MenuLateral menuLateral = new MenuLateral(driver);
    private OpcoesProcessos opcoesProcessos = new OpcoesProcessos(driver);
    private PostProcessos postProcessos = new PostProcessos(driver);
    private EditaProcesso editarProcesso = new EditaProcesso(driver);
    private MostrarProcessos mostrarProcessos = new MostrarProcessos(driver);

    @Dado("^usuário está na home$")
    public void usuarioEstaNaHome() {
        inicial.abrirPagina();
    }
    @E("^usuário clicar na opção \"([^\"]*)\" do menu lateral$")
    public void oUsuarioClicarNoMenu(String vMenu) throws Throwable {
        menuLateral.clicarMenuLateral(vMenu);
    }
    @E("^usuário clica no botão de novo processo$")
    public void oUsuarioClicarNoBotaoNovoProcesso() {
        opcoesProcessos.botaoNovoProcesso();
    }

    @E("^usuário informa no campo \"([^\"]*)\" o valor igual a \"([^\"]*)\"$")
    public void oUsuarioDigitarNoCampoOValor(String campo, String valor) throws Throwable {
        postProcessos.preencherCampo(campo, valor);
    }
    @E("^usuário digita no campo \"([^\"]*)\" o valor igual a \"([^\"]*)\"$")
    public void oUsuarioDigitarNoCampoDeEditarOValor(String campo, String valor) throws Throwable {
        editarProcesso.preencherCampo(campo, valor);
    }
    @Quando("^usuário clica em salvar na página de inclusão$")
    public void oUsuarioClicarNoBotaoSalvar() {
        postProcessos.clicarSalvar();
        postProcessos.setCode(mostrarProcessos.recuperaCodigo());
    }
    @Quando("^usuário clica no botão salvar na página de editar$")
    public void oUsuarioClicarNoBotaoSalvarEmEditar() {
        editarProcesso.clicarSalvar();
    }

    @Então("^o usuário deveria visualizar a mensagem \"([^\"]*)\"$")
    public void oUsuarioDeveriaVisualizarAMensagem(String message) throws Throwable {
        Assert.assertEquals(message, mostrarProcessos.recuperarMensagemDeSucesso());
    }
    @E("^usuário seleciona o valor \"([^\"]*)\" no campo urgência$")
    public void oUsuárioSelecionaNoCampoOValor(String valor) throws Throwable {
        postProcessos.selecionarUrgencia(valor);
    }
    @E("^usuário seleciona o valor Sim no campo arbitramento$")
    public void oUsuárioClicaNoCampoArbitramentoComOValorSim() {
        postProcessos.clicarArbitramentoSim();
    }

    @Quando("^usuário clica no botão voltar$")
    public void oUsuárioClicarEmVoltar() {
        mostrarProcessos.clicarVoltar();
    }

    @Quando ("^usuário clica no botao Mostrar do processo$")
    public void oUsuarioClicaNoBotaoMostrarDoUsuarioCadastrado(){
        opcoesProcessos.botaoMostrar(postProcessos.getCode());
    }
    @Quando ("^usuário clica no botao editar do processo$")
    public void oUsuarioClicaNoBotaoEditarDoUsuarioCadastrado(){
        opcoesProcessos.botaoEditar(postProcessos.getCode());
    }

    @Então("^usuário visualizará a informação \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerOValorNoCampo(String value, String field) throws Throwable{
        Assert.assertEquals(value, mostrarProcessos.getField(field));
    }

    @Quando("^usuário clica em Apagar dentro do processo$")
    public void oUsuarioClicarNoBotaoApagarDoProcessoCadastrado() {
        opcoesProcessos.botaoDeletar(postProcessos.getCode());
    }

    @E("^usuário confirma a ação de deletar$")
    public void oUsuarioConfirmarADelecao() {
        opcoesProcessos.confirmaDelecao();
    }

    @Então("^botão Apagar não será apresentado$")
    public void oBotaoApagarNaoPodeMaisExisterParaOProcessoCadastrado() {
        Assert.assertFalse(opcoesProcessos.existeBotaoApagar(postProcessos.getCode()));
    }
}
