#language: pt
Funcionalidade: Processos CRUD - System testing

  Contexto:
    Dado usuário está na home
    E usuário clicar na opção "processos" do menu lateral
    E usuário clica no botão de novo processo
    E usuário informa no campo "processo_vara" o valor igual a "Rio de Janeiro"
    E usuário informa no campo "processo_numero_processo" o valor igual a "4392"
    E usuário informa no campo "processo_natureza" o valor igual a "Criminal"
    E usuário informa no campo "processo_partes" o valor igual a "Felipe X Victor"
    E usuário seleciona o valor "Sim" no campo urgência
    E usuário seleciona o valor Sim no campo arbitramento
    E usuário informa no campo "processo_assistente_social" o valor igual a "Pedro"
    E usuário informa no campo "processo_data_entrada" o valor igual a "09/01/2021"
    E usuário informa no campo "processo_data_saida" o valor igual a "30/09/2021"
    E usuário informa no campo "processo_data_agendamento" o valor igual a "21/03/2022"
    E usuário informa no campo "processo_status" o valor igual a "Finalizado"
    E usuário informa no campo "processo_observacao" o valor igual a "OK!"

  Cenario: Usuário adiciona um novo processo - Create (Com o uso de background/contexto) (TESTE OK)
    Quando usuário clica em salvar na página de inclusão
    Então o usuário deveria visualizar a mensagem "Processo foi criado com sucesso."

  Cenario: Usuário visualiza o processo após adicionar o mesmo - Read (TESTE FALHOU)
    Quando usuário clica no botao Mostrar do processo
    Então usuário visualizará a informação "Rio de Janeiro" no campo "vara"
    E usuário visualizará a informação "4392" no campo "numero"
    E usuário visualizará a informação "Criminal" no campo "natureza"
    E usuário visualizará a informação "Felipe X Victor" no campo "partes"
    E usuário visualizará a informação "S" no campo "urgente"
    E usuário visualizará a informação "S" no campo "arbitramento"
    E usuário visualizará a informação "Pedro" no campo "as_social"
    E usuário visualizará a informação "2021-01-09" no campo "dt_entrada"
    E usuário visualizará a informação "2021-09-30" no campo "dt_saida"
    E usuário visualizará a informação "2022-03-21" no campo "dt_agendamento"
    E usuário visualizará a informação "Finalizado" no campo "status"
    E usuário visualizará a informação "OK!" no campo "observacao"

  Cenario: Usuário atualiza o processo após adicionar o mesmo - Update (TESTE OK)
    Quando usuário clica no botão salvar na página de editar
    Então usuário visualizará a informação "Rio de Janeiro" no campo "vara"

  Cenario: Usuário deleta processo após adicionar o mesmo - Delete (TESTE FALHOU)
    Quando usuário clica em Apagar dentro do processo
    E usuário confirma a ação de deletar
    Então botão Apagar não será apresentado

  @realizarteste
  Esquema do Cenario: Validação via Scenario Outline. Teste: <mensagem retorno> (TESTE OK)
    Dado usuário está na home
    E usuário clicar na opção "processos" do menu lateral
    E usuário clica no botão de novo processo
    E usuário informa no campo "processo_vara" o valor igual a "Curitiba"
    E usuário informa no campo "processo_numero_processo" o valor igual a "2103"
    E usuário informa no campo "processo_natureza" o valor igual a "<natureza>"
    E usuário informa no campo "processo_partes" o valor igual a "Felipe X Victor"
    E usuário seleciona o valor "Sim" no campo urgência
    E usuário seleciona o valor Sim no campo arbitramento
    E usuário informa no campo "processo_assistente_social" o valor igual a "Marcos"
    E usuário informa no campo "processo_data_entrada" o valor igual a "06/02/2021"
    E usuário informa no campo "processo_data_saida" o valor igual a "07/03/2021"
    E usuário informa no campo "processo_data_agendamento" o valor igual a "19/08/2022"
    E usuário informa no campo "processo_status" o valor igual a "Pendente"
    E usuário informa no campo "processo_observacao" o valor igual a "OK!"

    Exemplos:
      | natureza | mensagem retorno        |
      | Cívil    | Salvo com sucesso       |
      | Criminal | Nao processado          |


