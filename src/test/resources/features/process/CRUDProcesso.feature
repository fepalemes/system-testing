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

  Cenario: Usuário adiciona um novo processo - Create (Com o uso de background/contexto)
    Quando usuário clica em salvar na página de inclusão
    Então o usuário deveria visualizar a mensagem "Processo foi criado com sucesso."

  Cenario: Usuário visualiza o processo após adicionar o mesmo - Read
    Dado usuário está na home
    E usuário clicar na opção "processos" do menu lateral
    E usuário clica no botão de novo processo
    E usuário informa no campo "processo_vara" o valor igual a "Porto Alegre"
    E usuário informa no campo "processo_numero_processo" o valor igual a "9876"
    E usuário informa no campo "processo_natureza" o valor igual a "Criminal"
    E usuário informa no campo "processo_partes" o valor igual a "Felipe X Victor"
    E usuário seleciona o valor "Sim" no campo urgência
    E usuário seleciona o valor Sim no campo arbitramento
    E usuário informa no campo "processo_assistente_social" o valor igual a "Felipe"
    E usuário informa no campo "processo_data_entrada" o valor igual a "19/01/2021"
    E usuário informa no campo "processo_data_saida" o valor igual a "23/09/2021"
    E usuário informa no campo "processo_data_agendamento" o valor igual a "20/03/2022"
    E usuário informa no campo "processo_status" o valor igual a "Arquivado"
    E usuário informa no campo "processo_observacao" o valor igual a "OK read!"
    E usuário clica em salvar na página de inclusão
    E usuário clica no botão voltar
    Quando usuário clica no botao Mostrar do processo
    Então usuário visualizará a informação "Porto Alegre" no campo "vara"
    E usuário visualizará a informação "9876" no campo "numero"
    E usuário visualizará a informação "Criminal" no campo "natureza"
    E usuário visualizará a informação "Felipe X Victor" no campo "partes"
    E usuário visualizará a informação "S" no campo "urgente"
    E usuário visualizará a informação "S" no campo "arbitramento"
    E usuário visualizará a informação "Felipe" no campo "as_social"
    E usuário visualizará a informação "2021-01-19" no campo "dt_entrada"
    E usuário visualizará a informação "2021-09-23" no campo "dt_saida"
    E usuário visualizará a informação "2022-03-20" no campo "dt_agendamento"
    E usuário visualizará a informação "Arquivado" no campo "status"
    E usuário visualizará a informação "OK read!" no campo "observacao"

  Cenario: Usuário atualiza o processo após adicionar o mesmo - Update
    Dado usuário está na home
    E usuário clicar na opção "processos" do menu lateral
    E usuário clica no botão de novo processo
    E usuário informa no campo "processo_vara" o valor igual a "Fortaleza"
    E usuário informa no campo "processo_numero_processo" o valor igual a "2103"
    E usuário informa no campo "processo_natureza" o valor igual a "Criminal"
    E usuário informa no campo "processo_partes" o valor igual a "Felipe X Victor"
    E usuário seleciona o valor "Não" no campo urgência
    E usuário seleciona o valor Sim no campo arbitramento
    E usuário informa no campo "processo_assistente_social" o valor igual a "Marcos"
    E usuário informa no campo "processo_data_entrada" o valor igual a "10/01/2021"
    E usuário informa no campo "processo_data_saida" o valor igual a "27/09/2021"
    E usuário informa no campo "processo_data_agendamento" o valor igual a "25/03/2022"
    E usuário informa no campo "processo_status" o valor igual a "Aguardando"
    E usuário informa no campo "processo_observacao" o valor igual a "OK!"
    E usuário clica em salvar na página de inclusão
    E usuário clica no botão voltar
    E usuário clica no botao editar do processo
    E usuário informa no campo "processo_observacao" o valor igual a "TESTE UPDATE OK!"
    Quando usuário clica no botão salvar na página de editar
    Então usuário visualizará a informação "TESTE UPDATE OK!" no campo "observacao"

  Cenario: Usuário deleta processo após adicionar o mesmo - Delete
    Dado usuário está na home
    E usuário clicar na opção "processos" do menu lateral
    E usuário clica no botão de novo processo
    E usuário informa no campo "processo_vara" o valor igual a "Manaus"
    E usuário informa no campo "processo_numero_processo" o valor igual a "1234"
    E usuário informa no campo "processo_natureza" o valor igual a "Civil"
    E usuário informa no campo "processo_partes" o valor igual a "Felipe X Victor"
    E usuário seleciona o valor "Não" no campo urgência
    E usuário seleciona o valor Sim no campo arbitramento
    E usuário informa no campo "processo_assistente_social" o valor igual a "Marcos"
    E usuário informa no campo "processo_data_entrada" o valor igual a "10/01/2021"
    E usuário informa no campo "processo_data_saida" o valor igual a "27/09/2021"
    E usuário informa no campo "processo_data_agendamento" o valor igual a "25/03/2022"
    E usuário informa no campo "processo_status" o valor igual a "Aguardando"
    E usuário informa no campo "processo_observacao" o valor igual a "OK delete"
    E usuário clica em salvar na página de inclusão
    E usuário clica no botão voltar
    Quando usuário clica em Apagar dentro do processo
    E usuário confirma a ação de deletar
    Então botão Apagar não será apresentado

  @realizarteste
  Esquema do Cenario: Validação via Scenario Outline. Mensagem de retorno: <mensagem_retorno>
    Dado usuário está na home
    E usuário clicar na opção "processos" do menu lateral
    E usuário clica no botão de novo processo
    E usuário informa no campo "processo_vara" o valor igual a "<vara>"
    E usuário informa no campo "processo_numero_processo" o valor igual a "<num_processo>"
    E usuário informa no campo "processo_natureza" o valor igual a "<natureza>"
    E usuário informa no campo "processo_partes" o valor igual a "<partes>"
    E usuário seleciona o valor "Sim" no campo urgência
    E usuário seleciona o valor Sim no campo arbitramento
    E usuário informa no campo "processo_assistente_social" o valor igual a "<assistente_social>"
    E usuário informa no campo "processo_data_entrada" o valor igual a "06/02/2021"
    E usuário informa no campo "processo_data_saida" o valor igual a "07/03/2021"
    E usuário informa no campo "processo_data_agendamento" o valor igual a "19/08/2022"
    E usuário informa no campo "processo_status" o valor igual a "<status>"
    E usuário informa no campo "processo_observacao" o valor igual a "<obs>"

    Exemplos:
      | natureza  | vara       | status     | assistente_social | partes           | num_processo | obs        | mensagem_retorno  |
      | Civil     | São Carlos | Finalizado | Marcos            | Felipe X Victor  | 123456789    | scenario 1 | Salvo com sucesso |
      | Criminal  | Araraquara | Aguardando | Ricardo           | Victor X Felipe  | 987654321    | scenario 2 | Nao processado    |


